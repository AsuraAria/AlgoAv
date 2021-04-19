package B;

import resources.CoinList;

import java.util.Arrays;

public class AlgoDynamique {
    CoinList coinList;
    float objective;
    int[] compacteSolution;
    float[] solution;

    public AlgoDynamique(CoinList coinList, float objective) {
        // create coinList object
        this.coinList = coinList;
        // define objective
        this.objective = objective;
        // init solution on coinList valutList length
        this.solution = new float[]{};
    }

    //GETTERS
    public CoinList getCoinList() {
        return coinList;
    }

    public float getObjective() {
        return objective;
    }

    public int[] getCompacteSolution() {
        return this.compacteSolution;
    }

    public float[] getSolution() {
        return this.solution;
    }

    // SETTERS
    public void setCompacteSolution(int[] cs) {
        this.compacteSolution = cs;
    }

    public void setSolution(float[] solution) {
        this.solution = solution;
    }

    // UTILITY
    private void generateCompacteSolution() {
        int[] sol = new int[getCoinList().getValueList().length];
        for (int i = 0; i < getCoinList().getValueList().length; i++) {
            for (float val : getSolution()) {
                if (val == getCoinList().getValueList()[i]) {
                    sol[i] += 1;
                }
            }
        }
        setCompacteSolution(sol);
    }

    public void resolve() {
        // Variables, multiplié par 100 pour calculer les centimes en tant qu'entier
        int objectiveCent = (int) (objective * 100);
        int[] tableMem = new int[objectiveCent + 1];
        int[] coinUsed = new int[objectiveCent + 1];
        int[] coinListEntier = new int[getCoinList().getValueList().length];
        // On remplit le tableau de pièces sous forme d'entier
        for (int i = 0; i < getCoinList().getValueList().length; i++) {
            coinListEntier[i] = (int) (getCoinList().getValueList()[i] * 100);
        }
        // Le montant minimum de pièces à utiliser pour faire de la monnaie pour 0 est 0
        tableMem[0] = 0;
        coinUsed[0] = 0;
        // On initialize toutes les cases du tableau tableMem à une valeur plus grande que l'objectif
        for (int i = 1; i <= objectiveCent; i++) {
            tableMem[i] = objectiveCent + 1;
        }
        // Calcule le nombre de pièces minimum requis pour toutes les valeurs de 1 à l'objectif
        // Pour chaque case de tableMem, on mémorise également les pièces à rendre
        for (int i = 0; i <= objectiveCent; i++) {
            for (int j = 0; j < coinListEntier.length; j++) {
                if (coinListEntier[j] <= i) {
                    int potentialAnswer = 1 + tableMem[i - coinListEntier[j]];
                    tableMem[i] = Math.min(tableMem[i], potentialAnswer);
                    if (tableMem[i] >= potentialAnswer) {
                        coinUsed[i] = coinListEntier[j];
                    }
                }
            }
        }

        // On affiche la solution
        if (tableMem[objectiveCent] > objectiveCent) {
            System.out.println("Fail\nNo solution found\n");
        } else {
            System.out.println("Success");
            System.out.println("Objective is : " + getObjective());
            System.out.println("Coins values are :" + Arrays.toString((getCoinList().getValueList())));

            // On récupère les pièces utilisés grâce à coinUsed
            int index = objectiveCent;
            int coinSubtract = coinUsed[objectiveCent];
            while (index != 0) {
                getCoinList().addCoinOnList((float) (coinSubtract / 100.0));
                index = index - coinSubtract;
                coinSubtract = coinUsed[index];

            }
            setSolution(getCoinList().getCoinList());
            generateCompacteSolution();
            System.out.println("Solution is :" + Arrays.toString(getCompacteSolution()) + "\n");
        }
    }
}

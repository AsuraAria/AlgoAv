package A;

import java.util.Arrays;

import resources.CoinList2;

public class AlgoGen {
    CoinList2 coinList2;
    float[] bestSolution = new float[0];
    int[] compacteSolution;
    float objective;

    public AlgoGen(CoinList2 coinList2, float objective) {
        // create coinList object
        this.coinList2 = coinList2;
        // define objective
        this.objective = objective;
        // init solution on coinList valutList length
    }

    //GETTERS
    public CoinList2 getCoinList() {
        return coinList2;
    }

    public float getObjective() {
        return objective;
    }

    public int[] getCompactSolution() {
        return this.compacteSolution;
    }

    public float[] getBest() {
        return this.bestSolution;
    }

    //SETTERS
    public void setCompactSolution(int[] cs) {
        this.compacteSolution = cs;
    }

    public void setBest(float[] best) {
        this.bestSolution = best;
    }

    // UTILITY

    private float totalValue(float[] list) {
        float tv = 0;
        for (float i : list) {
            tv += i;
        }
        return tv;
    }

    private void generateCompactSolution() {
        int[] sol = new int[getCoinList().getValueList().length];
        for (int i = 0; i < getCoinList().getValueList().length; i++) {
            for (float val : getBest()) {
                if (val == getCoinList().getValueList()[i]) {
                    sol[i] += 1;
                }
            }
        }
        setCompactSolution(sol);
    }

    public void showRes() {
        generateCompactSolution();
        System.out.println("\nSuccess");
        System.out.println("Objective is : " + getObjective());
        System.out.println("Coins values are :" + Arrays.toString((getCoinList().getValueList())));
        System.out.println("Solution is :" + Arrays.toString(getBest()));
        System.out.println("Compact solution is :" + Arrays.toString(getCompactSolution()) + "\n");
    }

    private float[] addCoinToList(float j, float[] currentList) {
        // enlarge coinList by creating a new list
        float[] newCoinList = new float[currentList.length + 1];
        //copy old list
        System.arraycopy(currentList, 0, newCoinList, 0, currentList.length);
        //adding the new value
        newCoinList[newCoinList.length - 1] = j;

        return newCoinList;
    }

    //Composant de l'algorithme générique

    // adding a coin need not to to exceed the objective, and we need to have less coins that current best sol
    public boolean satisfaisant(float[] currentList) {
        boolean flag = false;
        // if adding a coin does not exceed objective
        if (totalValue(currentList) <= getObjective()) {
            if (getBest().length == 0 || currentList.length < getBest().length) {
                flag = true;
            }

        }
        return flag;
    }

    // set flag to true if total coins value equals objective
    public boolean solTrouve(float[] currentList) {
        boolean flag;
        flag = totalValue(currentList) == getObjective();
        return flag;
    }

    // return to previous state by copying state without last value
    public void defaire(CoinList2 coinList) {
        // enlarge coinList by creating a new list
        float[] newCoinList = new float[coinList.getCoinList().length - 1];
        //copy old list
        for (int i = 0; i < newCoinList.length; i++) {
            newCoinList[i] = coinList.getCoinList()[i];
        }
        coinList.setCoinList(newCoinList);
    }

    //save the new best solution
    public void enregistrer(float[] newBest) {
        // new list
        float[] newCoinList = new float[newBest.length];
        //copy old list
        System.arraycopy(newBest, 0, newCoinList, 0, newBest.length);
        setBest(newCoinList);
    }


    // WARNING : a solution MUST EXIST
    public void resolve2(CoinList2 coinList) {
        for (float j : getCoinList().getValueList()) {
            //adding the coin
            coinList.addCoin(j);

            //if adding the coin is good calling next step
            if (satisfaisant(coinList.getCoinList())) {
                //check if adding this coin reach the objective
                if (solTrouve(coinList.getCoinList())) {
                    //System.out.println("Sol : " + (Arrays.toString(coinList.getCoinList())));
                    //a solution is found, save if no solution is known
                    if (getBest().length == 0) {
                        enregistrer(coinList.getCoinList());
                    }
                    //a solution is found, save if current solution is better
                    if (coinList.getCoinList().length < getBest().length) {
                        enregistrer(coinList.getCoinList());
                    }
                }
                //else call anew resolve to pursue adding coin
                else {
                    //create new object with the current properties
                    resolve2(new CoinList2(coinList.getValueList(), coinList.getCoinList(), coinList.getTotalValue()));
                    //the new call to resolve2 will add a coin, thus removing it after use and before next loop is required
                    defaire(coinList);
                }

            } else {
                defaire(coinList);
            }
            // once all possibilities for current coin are tested, we will test with the next coin
            // for that we need to remove the current coin
        }
    }

    public void resolve() {
        //sort list before first call
        this.getCoinList().sortMaxMin();
        resolve2(getCoinList());
        showRes();
    }
}

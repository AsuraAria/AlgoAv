package C;

import java.util.Arrays;

import resources.CoinList;

public class AlgoGlouton {
    CoinList coinList;
    int[] compacteSolution;
    boolean[] unusableCoin;
    float objective;

    public AlgoGlouton(CoinList coinList, float objective) {
        // create coinList object
        this.coinList = coinList;
        // define objective
        this.objective = objective;
        // boolean array is initialised at false
        this.unusableCoin = new boolean[coinList.getValueList().length];
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

    //SETTERS

    public void setCompacteSolution(int[] cs) {
        this.compacteSolution = cs;
    }

    // FUNCTIONS

    private float totalValue() {
        float tv = 0;
        for (float i : getCoinList().getCoinList()) {
            tv += i;
        }
        return tv;
    }

    private void generateCompactSolution() {
        int[] sol = new int[getCoinList().getValueList().length];
        for (int i = 0; i < getCoinList().getValueList().length; i++) {
            for (float val : getCoinList().getCoinList()) {
                if (val == getCoinList().getValueList()[i]) {
                    sol[i] += 1;
                }
            }
        }
        setCompacteSolution(sol);
    }

    // return to previous state by removing last value in solution
    public void undo() {
        // recreating previous solution
        float[] preState = new float[]{};

        // if previous state was not null, copy it
        if (getCoinList().getCoinList().length > 1) {
            preState = new float[getCoinList().getCoinList().length - 1];
            for (int i = 0; i < preState.length; i++) {
                preState[i] = getCoinList().getCoinList()[i];
            }
        }

        // updating coinList object
        getCoinList().setCoinList(preState);
        getCoinList().updateTotalValue();

        // updating solution
        getCoinList().setCoinList(preState);
    }

    // WARNING : a solution MUST EXIST
    public void resolve() {
        //sort list from Max to Min
        this.getCoinList().sortMaxMin();
        //while objective is not reached loop
        while (getObjective() != totalValue()) {
            // loop on coin values
            for (float i : getCoinList().getValueList()) {
                // while we do not exceed, add a coin
                while (getCoinList().getTotalValue() < getObjective()) {
                    getCoinList().addCoin(i);
                }

                //after exiting while loop, if we exceed objective, remove last coin
                if (getCoinList().getTotalValue() > getObjective())
                {
                    undo();
                }

                //if we have reach objective no action is takken

                // at the end of the loop we continue with the next smaller coin
                // if there is none the loop if finished and we have a solution
            }

            // finished resolution message
            // in case of some error there is still a final check
            // mainly to prevent error if no solution exist
        }
        System.out.println("Objective is : " + getObjective());
        System.out.println("Coins values are :" + Arrays.toString((getCoinList().getValueList())));
        if (getObjective() == totalValue()) {
            generateCompactSolution();
            System.out.println("Success");
            System.out.println("Solution is :" + Arrays.toString(getCompacteSolution()) + "\n");
        } else {
            System.out.println("Fail\nNo solution found\n");
        }
    }
}

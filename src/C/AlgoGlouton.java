package C;

import java.util.Arrays;

import resources.CoinList;

public class AlgoGlouton {
    CoinList coinList;
    float[] solution;
    int[] compacteSolution;
    boolean[] unusableCoin;
    float objective;
    boolean finished = false;

    public AlgoGlouton(CoinList coinList, float objective) {
        // create coinList object
        this.coinList = coinList;
        // define objective
        this.objective = objective;
        // boolean array is initialised at false
        this.unusableCoin = new boolean[coinList.getValueList().length];
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

    public float[] getSolution() {
        return this.solution;
    }

    public int[] getCompacteSolution() {
        return this.compacteSolution;
    }

    //SETTERS
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setSolution(float[] solution) {
        this.solution = solution;
    }

    public void setCompacteSolution(int[] cs) {
        this.compacteSolution = cs;
    }

    // FUNCTIONS

    public void addUnusableCoin(float coinValue) {
        // search in valueList
        for (int i = 0; i < getCoinList().getValueList().length; i++) {
            // when i match values from coinValue and valueList
            if (coinValue == getCoinList().getValueList()[i]) {
                // set unusableCoin value of index i to true
                this.unusableCoin[i] = true;
            }
        }
    }

    private float totalValue() {
        float tv = 0;
        for (float i : getSolution()) {
            tv += i;
        }
        return tv;
    }

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

    // adding a coin need not to to exceed the objective
    public boolean valid() {
        // return false if coin exceed the objective
        // else return true
        return !(getCoinList().getTotalValue() > getObjective());
    }

    // set finished to true if total coins value equals objective
    public void success() {
        if (getCoinList().getTotalValue() == getObjective()) {
            setFinished(true);
        }
    }

    // return to previous state by removing last value in solution
    public void undo() {
        // recreating previous solution
        float[] preState = new float[getCoinList().getCoinList().length - 1];
        for (int i = 0; i < preState.length; i++) {
            preState[i] = getSolution()[i];
        }
        // setting removed value to unusable
        addUnusableCoin(getCoinList().getCoinList()[getCoinList().getCoinList().length - 1]);

        // updating coinList object
        getCoinList().setCoinList(preState);
        getCoinList().updateTotalValue();

        // updating solution
        setSolution(preState);
    }

    //sort valuelist for Glouton
    private void sortMaxMin() {
        //order min to max
        Arrays.sort(this.getCoinList().getValueList());
        //reverse to have max to min
        int listSize = this.getCoinList().getValueList().length;
        float[] tmp = new float[listSize];
        for (int i = 0; i < listSize; i++) {
            tmp[i] = this.getCoinList().getValueList()[listSize - 1 - i];
        }
        // affect sorted list to object
        this.getCoinList().setValueList(tmp);
    }

    // WARNING : a solution MUST EXIST
    public void resolve() {
        this.getCoinList().sortMaxMin();
        while (!finished) {
            //iterate over coins value
            for (float i : getCoinList().getValueList()) {
                // while objective is not exceed add coin
                while (valid()) {
                    getCoinList().addCoin(i);

                    // save state if still valid
                    if (valid()) {
                        setSolution(getCoinList().getCoinList());
                    }
                }

                // when exceed remove last coin
                undo();
                //then continue over next coin value

            }

            // check if a solution is found
            success();
        }

        // finished resolution message
        if (getObjective() == totalValue()) {
            generateCompacteSolution();
            System.out.println("Success");
            //getCoinList().show();
            System.out.println("Objective is : " + getObjective());
            System.out.println("Coins values are :" + Arrays.toString((getCoinList().getValueList())));
            System.out.println("Solution is :" + Arrays.toString(getCompacteSolution()) + "\n");
        } else {
            System.out.println("Fail\nNo solution found");
        }
    }
}

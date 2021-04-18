package C;

import java.util.Arrays;

import resources.CoinList2;

public class AlgoGlouton
{
    CoinList2 coinList2;
    float[] solution;
    int[] compacteSolution;
    boolean[] unusableCoin;
    float objective;
    boolean finished = false;

    public AlgoGlouton(CoinList2 coinList2, float objective)
    {
        // create coinList object
        this.coinList2 = coinList2;
        // define objective
        this.objective = objective;
        // boolean array is initialised at false
        this.unusableCoin = new boolean[coinList2.getValueList().length];
        // init solution on coinList valutList length
        this.solution = new float[] {};
    }

    //GETTERS
    public CoinList2 getCoinList() {
        return coinList2;
    }
    public float getObjective() {
        return objective;
    }
    public float[] getSolution()
    {
        return this.solution;
    }
    public int[] getCompacteSolution()
    {
        return this.compacteSolution;
    }
    //SETTERS
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    public void setSolution(float[] solution)
    {
        this.solution=solution;
    }
    public void setCompacteSolution(int [] cs)
    {
        this.compacteSolution = cs;
    }

    // UTILITY

    public void addUnusableCoin(float coinValue)
    {
        // search in valueList
        for (int i=0; i<getCoinList().getValueList().length;i++)
        {
            // when i match values from coinValue and valueList
            if (coinValue==getCoinList().getValueList()[i])
            {
                // set unusableCoin value of index i to true
                this.unusableCoin[i] = true;
            }
        }
    }

    private float totalValue()
    {
        float tv = 0;
        for(float i : getSolution())
        {
            tv+=i;
        }
        return tv;
    }

    private void generateCompacteSolution()
    {
        int[] sol = new int[getCoinList().getValueList().length];
        for (int i =0; i< getCoinList().getValueList().length;i++)
        {
            for(float val:getSolution())
            {
                if (val==getCoinList().getValueList()[i])
                {
                    sol[i]+=1;
                }
            }
        }
        setCompacteSolution(sol);
    }

    // adding a coin need not to to exceed the objective
    public boolean valid()
    {
        if (getCoinList().getTotalValue()>getObjective())
        {
            // return false if coin exceed the objective
            return false;
        }
        else
        {
            // else return true
            return true;
        }
    }

    // set finished to true if total coins value equals objective
    public void success()
    {
        if (getCoinList().getTotalValue()==getObjective())
        {
            setFinished(true);
        }
    }

    // return to previous state by removing last value in solution
    public void undo()
    {
        // recreating previous solution
        float[] preState = new float[getCoinList().getCoinList().length-1];
        for (int i = 0; i< preState.length; i++)
        {
            preState[i] = getSolution()[i];
        }
        // setting removed value to unusable
        addUnusableCoin(getCoinList().getCoinList()[getCoinList().getCoinList().length-1]);

        // updating coinList object
        getCoinList().setCoinList(preState);
        getCoinList().updateTotalValue();

        // updating solution
        setSolution(preState);
    }


    // WARNING : a solution MUST EXIST
    public void resolve()
    {
        while (!finished)
        {
            //iterate over coins value
            for (float i : getCoinList().getValueList())
            {
                // while objective is not exceed add coin
                while(valid())
                {
                    getCoinList().addCoin(i);

                    // save state if still valid
                    if(valid())
                    {
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
        if(getObjective()==totalValue())
        {
            generateCompacteSolution();
            System.out.println("Success");
            //getCoinList().show();
            System.out.println("Objective is : " + getObjective());
            System.out.println("Coins values are :" + Arrays.toString((getCoinList().getValueList())));
            System.out.println("Solution is :"+Arrays.toString(getCompacteSolution())+"\n");
        }
        else{System.out.println("Fail\nNo solution found");}
    }
}

package A;

import java.util.Arrays;

public class AlgoGen
{
    CoinListA coinListA;
    int[] solution;
    boolean[] unusableCoin;
    int objective;
    boolean finished = false;

    public AlgoGen(CoinListA coinListA, int objective)
    {
        // create coinList object
        this.coinListA = coinListA;
        // define objective
        this.objective = objective;
        // boolean array is initialised at false
        this.unusableCoin = new boolean[coinListA.getValueList().length];
        // init solution on coinList valutList length
        this.solution = new int[] {};
    }

    //GETTERS
    public CoinListA getCoinList() {
        return coinListA;
    }
    public int getObjective() {
        return objective;
    }
    public boolean getFinished() {
        return finished;
    }
    public int[] getSolution()
    {
        return this.solution;
    }

    //SETTERS
    public void setCoinList(CoinListA coinListA) {
        this.coinListA = coinListA;
    }
    public void setObjective(int objective) {
        this.objective = objective;
    }
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    public void setSolution(int[] solution)
    {
        this.solution=solution;
    }

    // UTILITY

    public void addUnusableCoin(int coinValue)
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

    private int totalValue()
    {
        int tv = 0;
        for(int i : getSolution())
        {
            tv+=i;
        }
        return tv;
    }

    // CONSTITUANT DE L'ALGORITHME GENERIQUE

    // Satisfaisant
    // adding a coin need not to to exceed the objective
    public boolean satisfaisant()
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

    // Enregistrer
    // save modification
    public void enregistrer()
    {
        setSolution(getCoinList().getCoinList());
    }

    // Soltrouvée
    // set finished to true if total coins value equals objective
    public void solTrouvee()
    {
        if (getCoinList().getTotalValue()==getObjective())
        {
            setFinished(true);
        }
    }

    // Défaire
    // return to previous state by removing last value in solution
    public void defaire()
    {
        // recreating previous solution
        int[] preState = new int[getCoinList().getCoinList().length-1];
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

    public void resolve()
    {
        while (!finished)
        {
            //iterate over coins value
            for (int i : getCoinList().getValueList())
            {
                // while objective is not exceed add coin
                while(satisfaisant())
                {
                    getCoinList().addCoin(i);

                    // save state if valid
                    if(satisfaisant())
                    {
                        enregistrer();
                    }
                }

                // when exceed remove last coin
                defaire();
                //then continue over next coin value

            }

            // check if a solution is found
            solTrouvee();
            // force kill
            //setFinished(true);
        }

        // finished resolution message
        if(getObjective()==totalValue())
        {
            System.out.println("Sucess");
            //getCoinList().show();
            System.out.println("Objective is : " + getObjective());
            System.out.println("Coins values are :" + Arrays.toString((getCoinList().getValueList())));
            System.out.println("Solution is :"+Arrays.toString(getSolution())+"\n");
        }
        else{System.out.println("Fail\nNo solution found");}
    }
}

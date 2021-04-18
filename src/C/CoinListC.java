package C;

import java.util.Arrays;

public class CoinListC {

    private int[] valueList; // list of coins value
    private int[] coinList; // array for coins taken
    private int totalValue; // value of all coins


    //CONSTRUCTORS

    public CoinListC(int[] valueList) {
        this.valueList = valueList;
        this.coinList = new int[] {};
        this.totalValue = 0;
    }

    //GETTERS
    public int[] getCoinList() {
        return coinList;
    }

    public int[] getValueList() {
        return valueList;
    }

    public int getTotalValue()
    {
        return this.totalValue;
    }

    //SETTERS

    public void setTotalValue(int totalValue)
    {
        this.totalValue=totalValue;
    }

    public void setCoinList(int[] coinList)
    {
        this.coinList= coinList;
    }

    //FUNCTIONS

    // Increment coin number tracker

    public void addCoinOnList(int value)
    {
        // enlarge coinList by creating a new list
        int[] newCoinList = new int[getCoinList().length+1];
        for (int i = 0; i < getCoinList().length; i++)
            newCoinList[i] = getCoinList()[i];
        newCoinList[newCoinList.length-1] = value;
        setCoinList(newCoinList);
    }

    // Show how coins values, coins list, and coins total

    public void show() {
        System.out.println("State :");
        System.out.println("Coins value are:");
        System.out.println(Arrays.toString(this.getValueList()));
        System.out.println("\nThere is " + getCoinList().length + " coin(s) :");
        System.out.println(Arrays.toString(this.getCoinList()));
    }

    public void addCoin(int value) {
        boolean flag = false;
        for (int i = 0; i < valueList.length; i++)
        {
            int curentValue = this.valueList[i];
            if (curentValue == value)
            {
                this.addCoinOnList(value);
                //System.out.println("Coin \"" + value + "\" added");
                flag = true;
                //update total value after coin is added
                updateTotalValue();
            }
        }

        if (!flag)
        {
            System.out.println("Coin value\"" + value + "\" is incorrect");
        }
    }

    public void updateTotalValue()
    {
        int temp = 0;
        for (int i = 0; i<getCoinList().length;i++)
        {
            temp+=coinList[i];
        }
        setTotalValue(temp);
    }
}

//ceci est un vestige

package resources;

import java.util.Arrays;

public class CoinList {

    private double[] valueList; // list of coins value
    private int nbCoin; // number of coins taken
    private int[] coinList; // array for coins taken


    //CONSTRUCTORS

    public CoinList(double[] valueList) {
        this.valueList = valueList;
        this.nbCoin = 0;
        this.coinList = new int[valueList.length];
    }

    //GETTERS
    public int getNbCoin() {
        return nbCoin;
    }

    public int[] getCoinList() {
        return coinList;
    }

    public double[] getValueList() {
        return valueList;
    }


    //FUNCTIONS

    // Increment coin number tracker

    public void incNbCoin(int value) {
        this.coinList[value] += 1;
        this.nbCoin += 1;
    }

    // Show how coins values, coins list, and coins total

    public void show() {
        System.out.println("Current coins value is:");
        System.out.println(Arrays.toString(this.getValueList()));
        System.out.println("There is " + this.getNbCoin() + " coin(s) currently :");
        System.out.println(Arrays.toString(this.getCoinList()));
    }

    public void addCoin(double value) {
        boolean flag = false;
        for (int i = 0; i < valueList.length; i++)
        {
            double curentValue = this.valueList[i];
            if (curentValue == value)
            {
                this.incNbCoin(i);
                System.out.println("Coin \"" + value + "\" added");
                flag = true;
            }
        }

        if (!flag)
        {
            System.out.println("Coin value is incorrect");
        }
    }
}
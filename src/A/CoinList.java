package A;

import java.util.Arrays;

public class CoinList
{
    private String name;
    private int nbCoin;
    private double[] CoinList;

    //CONSTRUCTORS

    public CoinList(String name, int nbCoin)
    {
        this.name = name;
        this.nbCoin = 0;
        this.CoinList = new double[nbCoin];
    }

    public CoinList(String name, double[] CoinList)
    {
        this.name = name;
        this.CoinList = CoinList;
    }

    // GETTERS

    public int getNbCoin()
    {
        return nbCoin;
    }

    public String getName() {
        return name;
    }

    public double[] getCoinList()
    {
        return CoinList;
    }

    public void incNbCoin(int nbCoin)
    {
        this.nbCoin += 1;
    }



    public void showCoinList()
    {
        System.out.println("\"" + this.getName() + "\"" + " content is:");
        System.out.println(Arrays.toString(getCoinList()));
    }
}

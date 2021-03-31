package A;

public class CoinList
{
    private int nbCoin;
    private double[] listCoin;

    public CoinList(int nbCoin)
    {
        this.nbCoin = 0;
        this.listCoin = new double[nbCoin];
    }

    public CoinList(double[] listCoin)
    {
        this.listCoin = listCoin;
    }

    public int getNbCoin()
    {
        return nbCoin;
    }

    public void incNbCoin(int nbCoin)
    {
        this.nbCoin += 1;
    }

    public double[] getListCoin()
    {
        return listCoin;
    }
}

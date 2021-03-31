package A;

public class CoinList
{
    private int nbCoin;
    private int[] listCoin;

    public CoinList(int nbCoin, int[] listCoin)
    {
        this.nbCoin = nbCoin;
        this.listCoin = listCoin;
    }

    public CoinList(int[] listCoin)
    {
        this.nbCoin = nbCoin;
        this.listCoin = listCoin;
    }

    public int getNbCoin()
    {
        return nbCoin;
    }

    public void setNbCoin(int nbCoin)
    {
        this.nbCoin = nbCoin;
    }

    public int[] getListCoin()
    {
        return listCoin;
    }

    public void setListCoin(int[] listCoin)
    {
        this.listCoin = listCoin;
    }
}

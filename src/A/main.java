package A;

import Resources.CoinList;

public class main
{
    public static void main (String[] args)
    {
        CoinList A = new CoinList(new double[]{2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01});
        //A.show();
        A.addCoin(2);
        A.addCoin(20);
        A.addCoin(.2000);
        A.show();

    }
}
package A;

import java.util.Arrays;

public class main
{
    public static void main (String[] args)
    {
        double test[] = {2,1,0.5,0.2,0.1,0.05,0.02,0.01};
        CoinList coinList = new CoinList("Coins values",test);
        coinList.showCoinList();
    }
}
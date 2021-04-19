package A;

import resources.CoinList;

public class mainA {
    public static void main(String[] args) {
        AlgoGen AG1 = new AlgoGen(new CoinList(new float[]{.01f, 1, 0.50f, .20f, .10f, .05f, .02f, 2}), 0);
        AlgoGen AG2 = new AlgoGen(new CoinList(new float[]{13, 5, 0.50f, .22f, .1f, .05f, .02f, 2}), 22.86f);
        AlgoGen AG3 = new AlgoGen(new CoinList(new float[]{2, 1, 0.50f, .20f, .10f, .05f, .02f, .01f}), 4.54f);

        AG1.resolve();
        AG2.resolve();
        AG3.resolve();
    }
}
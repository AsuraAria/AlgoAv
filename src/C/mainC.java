package C;

import resources.CoinList;

public class mainC {
    public static void main(String[] args) {
        AlgoGlouton AG1 = new AlgoGlouton(new CoinList(new float[]{.01f, 1, 0.50f, .20f, .10f, .05f, .02f, 2}), 0);
        AlgoGlouton AG2 = new AlgoGlouton(new CoinList(new float[]{.13f, 5, 0.50f, .22f, .1f, .05f, .01f, 2}), 5.86f);
        AlgoGlouton AG3 = new AlgoGlouton(new CoinList(new float[]{2, 1, 0.50f, .20f, .10f, .05f, .02f, .01f}), 54.54f);

        AG1.resolve();
        AG2.resolve();
        AG3.resolve();
    }
}
package C;

import resources.CoinList;

public class mainC {
    public static void main(String[] args) {
        AlgoGlouton AG1 = new AlgoGlouton(new CoinList(new float[]{2, 1, 0.50f, .20f, .10f, .05f, .02f, .01f}), 0);
        AlgoGlouton AG2 = new AlgoGlouton(new CoinList(new float[]{2, 1, 0.50f, .20f, .10f, .05f, .02f, .01f}), 45);
        AlgoGlouton AG3 = new AlgoGlouton(new CoinList(new float[]{2, 1, 0.50f, .20f, .10f, .05f, .02f, .01f}), 54.54f);

        AG1.resolve();
        AG2.resolve();
        AG3.resolve();
    }
}
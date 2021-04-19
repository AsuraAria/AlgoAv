package B;

import A.AlgoGen;
import resources.CoinList2;

public class mainB {
    public static void main(String[] args) {
        AlgoDynamique AD1 = new AlgoDynamique(new CoinList2(new float[]{2, 1, 0.50f, .20f, .10f, .05f, .02f, .01f}), 0);
        AlgoDynamique AD2 = new AlgoDynamique(new CoinList2(new float[]{2, 1, 0.50f, .20f, .10f, .05f, .02f, .01f}), 45);
        AlgoDynamique AD3 = new AlgoDynamique(new CoinList2(new float[]{2, 1, 0.50f, .20f, .10f, .05f, .02f, .01f}), 54.54f);

        AD1.resolve();
        AD2.resolve();
        AD3.resolve();
    }
}
package A;

import resources.CoinList2;

public class mainA
{
    public static void main (String[] args)
    {
        AlgoGen AG1 = new AlgoGen(new CoinList2(new float[]{6f, 1f, 0.30f, .10f, .06f, .04f, .01f}), 0.08f);
        AlgoGen AG2 = new AlgoGen(new CoinList2(new float[]{6f, 4f, 1f, .10f, .06f, .04f, .01f}), 8);
        AlgoGen AG3 = new AlgoGen(new CoinList2(new float[]{2f, 1f, 0.50f, .20f, .10f, .05f, .02f, .01f}), 54.54f);

        AG1.resolve();
        AG2.resolve();
        AG3.resolve();

        // élagage : quand on dépasse l'objectif on tronque la recherche en enlevant immédiatement la piece et en passant à la suivante
    }
}
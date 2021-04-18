package A;

public class mainA
{
    public static void main (String[] args)
    {
        CoinListA A = new CoinListA(new int[]{200, 100, 50, 20, 10, 5, 2, 1});
        AlgoGen AG1 = new AlgoGen(A, 0);
        AlgoGen AG2 = new AlgoGen(A, 189);
        AlgoGen AG3 = new AlgoGen(A, 7869);
        AG1.resolve();
        AG2.resolve();
        AG3.resolve();
    }
}
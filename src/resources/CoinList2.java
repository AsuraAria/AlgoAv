package resources;

public class CoinList2 {

    private final float[] valueList; // list of coins value
    private float[] coinList; // array for coins taken
    private float totalValue; // value of all coins


    //CONSTRUCTORS

    public CoinList2(float[] valueList) {
        this.valueList = valueList;
        this.coinList = new float[] {};
        this.totalValue = 0;
    }

    public CoinList2(float[] valueList, float[] coinList, float totalValue)
    {
        this.valueList = valueList;
        this.coinList = coinList;
        this.totalValue = totalValue;
    }

    //GETTERS
    public float[] getCoinList() {
        return coinList;
    }

    public float[] getValueList() {
        return valueList;
    }

    public float getTotalValue()
    {
        return this.totalValue;
    }

    //SETTERS

    public void setTotalValue(float totalValue)
    {
        this.totalValue=totalValue;
    }

    public void setCoinList(float[] coinList)
    {
        this.coinList= coinList;
    }

    //FUNCTIONS

    // Increment coin number tracker

    public void addCoinOnList(float value)
    {
        // enlarge coinList by creating a new list
        float[] newCoinList = new float[getCoinList().length+1];
        for (int i = 0; i < getCoinList().length; i++)
            newCoinList[i] = getCoinList()[i];
        newCoinList[newCoinList.length-1] = value;
        setCoinList(newCoinList);
    }

    public void addCoin(float value) {
        boolean flag = false;
        for (int i = 0; i < valueList.length; i++)
        {
            float curentValue = this.valueList[i];
            if (curentValue == value)
            {
                this.addCoinOnList(value);
                //System.out.println("Coin \"" + value + "\" added");
                flag = true;
                //update total value after coin is added
                updateTotalValue();
            }
        }

        if (!flag)
        {
            System.out.println("Coin value\"" + value + "\" is incorrect");
        }
    }

    public void updateTotalValue()
    {
        float temp = 0;
        for (int i = 0; i<getCoinList().length;i++)
        {
            temp+=coinList[i];
        }
        setTotalValue(temp);
    }
}

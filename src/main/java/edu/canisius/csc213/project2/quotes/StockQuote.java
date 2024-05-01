package edu.canisius.csc213.project2.quotes;

public class StockQuote {
    //defining variables
    private String symbol;
    double closePrice;
    double highestPrice;
    double lowestPrice;
    int numberOfTransactions;
    double openPrice;
    long timeStamp;
    double tradingVolume;

    //constructor
    public StockQuote(String symbol, double closePrice, 
                double highestPrice, double lowestPrice,
                int numberOfTransactions, double openPrice, 
                long timeStamp, double tradingVolume) {
        
        this.symbol = symbol;
        this.closePrice = closePrice;
        this.highestPrice = highestPrice;
        this.lowestPrice = lowestPrice;
        this.numberOfTransactions = numberOfTransactions;
        this.openPrice = openPrice;
        this.timeStamp = timeStamp;
        this.tradingVolume = tradingVolume;
    }

    public String prettyPrint() {
        return "Symbol: " + symbol +
               "\nClose Price: " + closePrice +
               "\nHighest Price: " + highestPrice + 
               "\nLowest Price: " + lowestPrice +
               "\nNumber of Transactions: " + numberOfTransactions +
               "\nOpen Price: " + openPrice +
               "\nTrading Volume: " + tradingVolume + "\n";
    }

    public double getClosePrice() {
        return closePrice;
    }

    public Object getSymbol() {
        return symbol;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public Object getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public Object getTimestamp() {
        return timeStamp;
    }

    public double getTradingVolume() {
        return tradingVolume;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

}

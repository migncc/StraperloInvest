package evaluador.model;

public class Stock {
    private String name;
    private String ticker;
    private String isin;

    private double currentPrice;
    private double historicalMaxPrice5Y;

    private double marketCap;
    private double enterpriseValue;

    private double netDebt;
    private double ebitda;
    private double per;

    private AnalystRating analystRating;

    // Constructor
    public Stock(String name, String ticker, String isin,
                 double currentPrice, double historicalMaxPrice5Y,
                 double marketCap, double enterpriseValue,
                 double netDebt, double ebitda, double per,
                 AnalystRating analystRating) {
        this.name = name;
        this.ticker = ticker;
        this.isin = isin;
        this.currentPrice = currentPrice;
        this.historicalMaxPrice5Y = historicalMaxPrice5Y;
        this.marketCap = marketCap;
        this.enterpriseValue = enterpriseValue;
        this.netDebt = netDebt;
        this.ebitda = ebitda;
        this.per = per;
        this.analystRating = analystRating;
    }

    // Getters
    public String getName() { return name; }
    public String getTicker() { return ticker; }
    public String getIsin() { return isin; }
    public double getCurrentPrice() { return currentPrice; }
    public double getHistoricalMaxPrice5Y() { return historicalMaxPrice5Y; }
    public double getMarketCap() { return marketCap; }
    public double getEnterpriseValue() { return enterpriseValue; }
    public double getNetDebt() { return netDebt; }
    public double getEbitda() { return ebitda; }
    public double getPer() { return per; }
    public AnalystRating getAnalystRating() { return analystRating; }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setHistoricalMaxPrice5Y(double historicalMaxPrice5Y) {
        this.historicalMaxPrice5Y = historicalMaxPrice5Y;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    public void setEnterpriseValue(double enterpriseValue) {
        this.enterpriseValue = enterpriseValue;
    }

    public void setNetDebt(double netDebt) {
        this.netDebt = netDebt;
    }

    public void setEbitda(double ebitda) {
        this.ebitda = ebitda;
    }

    public void setPer(double per) {
        this.per = per;
    }

    public void setAnalystRating(AnalystRating analystRating) {
        this.analystRating = analystRating;
    }
    @Override
    public String toString() {
        return "Stock: " + name + " (" + ticker + ")" +
                "\nISIN: " + isin +
                "\nPrecio actual: " + currentPrice +
                "\nMáximos 5 años: " + historicalMaxPrice5Y +
                "\nMarket Cap: " + marketCap +
                "\nEnterprise Value: " + enterpriseValue +
                "\nNet Debt: " + netDebt +
                "\nEBITDA: " + ebitda +
                "\nPER: " + per +
                "\nRating analistas: " + analystRating;
    }
}

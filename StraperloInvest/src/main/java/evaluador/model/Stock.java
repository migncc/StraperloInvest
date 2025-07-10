package evaluador.model;

import java.util.List;

public class Stock extends Asset {
    private double currentPrice;
    private double historicalMaxPrice5Y;
    private double marketCap;
    private double enterpriseValue;
    private double netDebt;
    private double ebitda;
    private double per;
    private String analystRating;
    private List<Double> historicalPrices;

    public Stock(String name, String ticker, String isin,
                 double amount, String sector, String country, RiskLevel riskLevel,
                 double currentPrice, double historicalMaxPrice5Y,
                 double marketCap, double enterpriseValue,
                 double netDebt, double ebitda, double per,
                 String analystRating, List<Double> historicalPrices) {

        super(name, ticker, isin, amount, sector, country, riskLevel);
        this.currentPrice = currentPrice;
        this.historicalMaxPrice5Y = historicalMaxPrice5Y;
        this.marketCap = marketCap;
        this.enterpriseValue = enterpriseValue;
        this.netDebt = netDebt;
        this.ebitda = ebitda;
        this.per = per;
        this.analystRating = analystRating;
        this.historicalPrices = historicalPrices;
    }

    public double getCurrentPrice() { return currentPrice; }
    public double getHistoricalMaxPrice5Y() { return historicalMaxPrice5Y; }
    public double getMarketCap() { return marketCap; }
    public double getEnterpriseValue() { return enterpriseValue; }
    public double getNetDebt() { return netDebt; }
    public double getEbitda() { return ebitda; }
    public double getPer() { return per; }
    public String getAnalystRatingRaw() { return analystRating; }
    public List<Double> getHistoricalPrices() { return historicalPrices; }

    public void setAnalystRating(String analystRating) { this.analystRating = analystRating; }
    public void setHistoricalPrices(List<Double> historicalPrices) { this.historicalPrices = historicalPrices; }

    public void setCurrentPrice(double currentPrice) { this.currentPrice = currentPrice; }
    public void setHistoricalMaxPrice5Y(double historicalMaxPrice5Y) { this.historicalMaxPrice5Y = historicalMaxPrice5Y; }
    public void setMarketCap(double marketCap) { this.marketCap = marketCap; }
    public void setEnterpriseValue(double enterpriseValue) { this.enterpriseValue = enterpriseValue; }
    public void setNetDebt(double netDebt) { this.netDebt = netDebt; }
    public void setEbitda(double ebitda) { this.ebitda = ebitda; }
    public void setPer(double per) { this.per = per; }
}

package evaluador.model;

public class Fund extends Asset {
    public Fund(String name, String ticker, String isin,
                double amount, String sector, String country, RiskLevel riskLevel) {
        super(name, ticker, isin, AssetType.FUND, amount, sector, country, riskLevel);
    }
}

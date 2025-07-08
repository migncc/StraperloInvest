package evaluador.model;

public class Etf extends Asset{
        public Etf(String name, String ticker, String isin,
                   double amount, String sector, String country, RiskLevel riskLevel) {
            super(name, ticker, isin, AssetType.ETF, amount, sector, country, riskLevel);
        }
    }



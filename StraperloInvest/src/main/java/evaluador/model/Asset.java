package evaluador.model;

public abstract class Asset {
    protected String name;
    protected String ticker;
    protected String isin;
    protected double amount; // € invertidos
    protected String sector;
    protected String country;
    protected RiskLevel riskLevel;

    public Asset(String name, String ticker, String isin, double amount,
                 String sector, String country,
                 RiskLevel riskLevel) {
        this.name = name;
        this.ticker = ticker;
        this.isin = (isin == null || isin.trim().isEmpty() || isin.equalsIgnoreCase("N/A"))
                ? null : isin;
        this.amount = amount;
        this.sector = sector;
        this.country = country;
        this.riskLevel = riskLevel;
    }

    // Getters comunes
    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public String getIsin() {
        return isin;
    }


    public double getAmount() {
        return amount;
    }

    public String getSector() {
        return sector;
    }

    public String getCountry() {
        return country;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    //Setters comunes
    public void setName(String name) {
        this.name = name;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }

    // toString común
    @Override
    public String toString() {
        return "Activo: " + name + " (" + ticker + ")" +
                "\nISIN: " + (isin != null ? isin : "No disponible") +
                "\nImporte: " + String.format("€%,.2f", amount) +
                "\nSector: " + sector +
                "\nPaís: " + country +
                "\nRiesgo estimado: " + riskLevel + "\n";
    }

}

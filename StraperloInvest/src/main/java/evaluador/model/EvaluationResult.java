package evaluador.model;

public class EvaluationResult {
    private double scorePriceVsMax;
    private double scoreCapVsEV;
    private double scorePER;
    private double scoreAnalysts;
    private double scoreCAGR;
    private double rawPER;
    private double rawCAGR;
    private double rawDebtRatio;



    // Getters y setters
    public double getScorePriceVsMax() { return scorePriceVsMax; }
    public void setScorePriceVsMax(double scorePriceVsMax) { this.scorePriceVsMax = scorePriceVsMax; }

    public double getScoreCapVsEV() { return scoreCapVsEV; }
    public void setScoreCapVsEV(double scoreCapVsEV) { this.scoreCapVsEV = scoreCapVsEV; }

    public double getScorePER() { return scorePER; }
    public void setScorePER(double scorePER) { this.scorePER = scorePER; }

    public double getScoreAnalysts() { return scoreAnalysts; }
    public void setScoreAnalysts(double scoreAnalysts) { this.scoreAnalysts = scoreAnalysts; }
    public void setRawPER(double rawPER) { this.rawPER = rawPER; }
    public void setRawCAGR(double rawCAGR) { this.rawCAGR = rawCAGR; }
    public void setRawDebtRatio(double rawDebtRatio) { this.rawDebtRatio = rawDebtRatio; }


    // Nota final sobre 10
    public double getFinalScore() {
        return roundToOneDecimal((scorePriceVsMax + scoreCapVsEV + scorePER + scoreAnalysts + scoreCAGR) / 5.0 * 10.0);

    }


    private double roundToOneDecimal(double value) {
        return Math.round(value * 10.0) / 10.0;
    }

    public String getSummary() {
        return "📊 Nota final: " + getFinalScore() + " / 10.0";
    }
    public double getScoreCAGR() { return scoreCAGR; }
    public void setScoreCAGR(double scoreCAGR) { this.scoreCAGR = scoreCAGR; }


    @Override
    public String toString() {
        return "1️⃣ Gráfica 5 años: " + describeScore(scorePriceVsMax) + "\n" +
                "2️⃣ Cap vs EV: " + describeScore(scoreCapVsEV) +
                (scoreCapVsEV < 1.0 ? " — Ratio deuda/EBITDA: " + format(rawDebtRatio) : "") + "\n" +
                "3️⃣ PER sectorial: " + describeScore(scorePER) + " — PER: " + format(rawPER) + "\n" +
                "4️⃣ Consenso analistas: " + describeScore(scoreAnalysts) + "\n" +
                "6️⃣ Rentabilidad anual: " + describeScore(scoreCAGR) + " — CAGR: " + formatPercentage(rawCAGR) + "\n" +
                getSummary();
    }


    private String describeScore(double score) {
        if (score >= 0.8) return "✅ Excelente (" + score + ")";
        else if (score >= 0.6) return "🟢 Buena (" + score + ")";
        else if (score >= 0.4) return "🟡 Neutra (" + score + ")";
        else if (score >= 0.2) return "🟠 Riesgosa (" + score + ")";
        else return "❌ Mala (" + score + ")";
    }
    private String format(double value) {
        return String.format("%.2f", value);
    }

    private String formatPercentage(double value) {
        return String.format("%.2f%%", value * 100);
    }

}

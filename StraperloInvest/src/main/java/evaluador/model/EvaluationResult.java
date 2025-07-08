package evaluador.model;

public class EvaluationResult {
    private double scorePriceVsMax;
    private double scoreCapVsEV;
    private double scoreDebtVsEBITDA;
    private double scorePER;
    private double scoreAnalysts;

    // Getters y setters
    public double getScorePriceVsMax() { return scorePriceVsMax; }
    public void setScorePriceVsMax(double scorePriceVsMax) { this.scorePriceVsMax = scorePriceVsMax; }

    public double getScoreCapVsEV() { return scoreCapVsEV; }
    public void setScoreCapVsEV(double scoreCapVsEV) { this.scoreCapVsEV = scoreCapVsEV; }

    public double getScoreDebtVsEBITDA() { return scoreDebtVsEBITDA; }
    public void setScoreDebtVsEBITDA(double scoreDebtVsEBITDA) { this.scoreDebtVsEBITDA = scoreDebtVsEBITDA; }

    public double getScorePER() { return scorePER; }
    public void setScorePER(double scorePER) { this.scorePER = scorePER; }

    public double getScoreAnalysts() { return scoreAnalysts; }
    public void setScoreAnalysts(double scoreAnalysts) { this.scoreAnalysts = scoreAnalysts; }

    // Nota final sobre 10
    public double getFinalScore() {
        return roundToOneDecimal((scorePriceVsMax + scoreCapVsEV + scoreDebtVsEBITDA + scorePER + scoreAnalysts) / 5.0 * 10.0);
    }

    // Helper para redondeo a 1 decimal
    private double roundToOneDecimal(double value) {
        return Math.round(value * 10.0) / 10.0;
    }

    // Resumen en formato texto
    public String getSummary() {
        return "📊 Nota final: " + getFinalScore() + " / 10.0";
    }

    // toString explicativo
    @Override
    public String toString() {
        return "1️⃣ Gráfica 5 años: " + describeScore(scorePriceVsMax) + "\n" +
                "2️⃣ Cap vs EV: " + describeScore(scoreCapVsEV) + "\n" +
                "3️⃣ Deuda/EBITDA: " + describeScore(scoreDebtVsEBITDA) + "\n" +
                "4️⃣ PER sectorial: " + describeScore(scorePER) + "\n" +
                "5️⃣ Consenso analistas: " + describeScore(scoreAnalysts) + "\n" +
                getSummary();
    }

    // Método auxiliar para expresar los scores
    private String describeScore(double score) {
        if (score >= 0.8) return "✅ Excelente (" + score + ")";
        else if (score >= 0.6) return "🟢 Buena (" + score + ")";
        else if (score >= 0.4) return "🟡 Neutra (" + score + ")";
        else if (score >= 0.2) return "🟠 Riesgosa (" + score + ")";
        else return "❌ Mala (" + score + ")";
    }
}

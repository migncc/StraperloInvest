package evaluador.model;

public class EvaluationResult {
    public boolean check1PriceVsMax;
    public boolean check2CapVsEV;
    public boolean check3DebtVsEBITDA;
    public Check4PERLevel perLevel;
    public boolean check5Analysts;

    public int getScore() {
        int score = 0;
        if (check1PriceVsMax) score++;
        if (check2CapVsEV) score++;
        if (check3DebtVsEBITDA) score++;
        if (perLevel == Check4PERLevel.LOW) score++;
        if (check5Analysts) score++;
        return score;
    }

    public String getSummary() {
        return "Checks positivos: " + getScore() + "/5";
    }

    @Override
    public String toString() {
        return "1️⃣ Gráfica 5 años: " + (check1PriceVsMax ? "✅ No está en máximos" : "❌ En máximos") + "\n" +
                "2️⃣ Cap vs EV: " + (check2CapVsEV ? "✅ Bien" : "❌ EV mayor que capitalización") + "\n" +
                "3️⃣ Deuda / EBITDA: " + (check3DebtVsEBITDA ? "✅ Sano" : "❌ Riesgoso") + "\n" +
                "4️⃣ PER: " + perLevel + "\n" +
                "5️⃣ Análisis: " + (check5Analysts ? "✅ Buy por consenso" : "❌ Señales negativas") + "\n" +
                getSummary();
    }
}

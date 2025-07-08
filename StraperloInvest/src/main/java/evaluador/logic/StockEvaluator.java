package evaluador.logic;

import evaluador.model.*;

public class StockEvaluator {

    public EvaluationResult evaluate(Stock stock) {
        EvaluationResult result = new EvaluationResult();

        // 1️⃣ Price vs Max
        double current = stock.getCurrentPrice();
        double max5Y = stock.getHistoricalMaxPrice5Y();
        double scorePriceVsMax = (max5Y > 0) ? Math.max(0.0, Math.min(1.0, 1.0 - (current / max5Y))) : 0.0;
        result.setScorePriceVsMax(scorePriceVsMax);

        // 2️⃣ Cap vs EV
        double cap = stock.getMarketCap();
        double ev = stock.getEnterpriseValue();
        double scoreCapVsEV = (cap > ev) ? 1.0 : 0.0;
        result.setScoreCapVsEV(scoreCapVsEV);

        // 3️⃣ Debt / EBITDA
        double ebitda = stock.getEbitda();
        double netDebt = stock.getNetDebt();
        double debtRatio = (ebitda > 0) ? netDebt / ebitda : Double.MAX_VALUE;
        double scoreDebtVsEBITDA = ScoreTable.getScore("DEBT_RATIO", debtRatio);
        result.setScoreDebtVsEBITDA(scoreDebtVsEBITDA);

        // 4️⃣ PER por sector
        String sector = stock.getSector();
        String perKey = sector.toUpperCase().replace(" ", "_") + "_PER"; // Ej: "Technology" -> "TECHNOLOGY_PER"
        double per = stock.getPer();
        double scorePER = ScoreTable.getScore(perKey, per);
        result.setScorePER(scorePER);
        result.setScorePER(scorePER);

        // 5️⃣ Analyst rating
        AnalystRating rating = stock.getAnalystRating();
        double scoreAnalyst = switch (rating) {
            case BUY -> 1.0;
            case HOLD -> 0.5;
            case SELL -> 0.0;
            default -> 0.0; // fallback para evitar errores en caso de futuros valores
        };
        result.setScoreAnalysts(scoreAnalyst);

        return result;
    }
}

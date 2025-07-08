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

        // 2️⃣ Cap vs EV + deuda
        double scoreCapVsEV;
        if (stock.getMarketCap() > stock.getEnterpriseValue()) {
            scoreCapVsEV = 1.0;
        } else if (stock.getEbitda() > 0) {
            double debtRatio = stock.getNetDebt() / stock.getEbitda();
            scoreCapVsEV = ScoreTable.getScore("DEBT_RATIO", debtRatio);
        } else {
            scoreCapVsEV = 0.0;
        }
        result.setScoreCapVsEV(scoreCapVsEV);

        // 4️⃣ PER por sector
        String sector = stock.getSector();
        String perKey = SectorNormalizer.getScoreKey(sector);
        double scorePER = ScoreTable.getScore(perKey, stock.getPer());
        result.setScorePER(scorePER);

        // 5️⃣ Analyst rating
        String analystRating = stock.getAnalystRatingRaw(); // suponiendo que ahora usamos un String
        double scoreAnalyst = switch (analystRating != null ? analystRating.toUpperCase() : "NONE") {
            case "STRONG_BUY" -> 1.0;
            case "BUY"        -> 0.85;
            case "HOLD"       -> 0.5;
            case "SELL"       -> 0.2;
            case "STRONG_SELL", "NONE", "NULL" -> 0.0;
            default           -> 0.0;
        };
        result.setScoreAnalysts(scoreAnalyst);


        return result;
    }
}

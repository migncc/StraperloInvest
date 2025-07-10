package evaluador.logic;

import evaluador.model.*;
import java.util.List;

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

        // 6️⃣ Rentabilidad anual media (CAGR)
        List<Double> historical = stock.getHistoricalPrices();
        double scoreCagr = 0.0;
        System.out.println("Histórico para " + stock.getTicker() + ": " + historical);

        if (historical != null && historical.size() >= 1) {
            double startPrice = historical.get(0);  // Precio más antiguo (hace 5 años)
            double endPrice = stock.getCurrentPrice();
            double cagr = calculateCAGR(startPrice, endPrice, 5);
            scoreCagr = scoreFromCAGR(cagr);
            result.setRawPER(stock.getPer());
            result.setRawCAGR(cagr);
            if (stock.getEbitda() > 0) {
                result.setRawDebtRatio(stock.getNetDebt() / stock.getEbitda());
            }

        }
        result.setScoreCAGR(scoreCagr);




        return result;
    }
    private double calculateCAGR(double startPrice, double endPrice, int years) {
        if (startPrice <= 0 || endPrice <= 0 || years <= 0) return 0.0;
        return Math.pow(endPrice / startPrice, 1.0 / years) - 1.0;
    }
    private double scoreFromCAGR(double cagr) {
        if (cagr <= 0.0) return 0.0;
        if (cagr >= 0.10) return 1.0; // Capamos a máximo 10%

        // Escalado progresivo: lineal entre 0% y 10%
        return Math.round((cagr / 0.10) * 100.0) / 100.0;
    }

}

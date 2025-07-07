package evaluador.logic;

import evaluador.model.AnalystRating;
import evaluador.model.Check4PERLevel;
import evaluador.model.EvaluationResult;
import evaluador.model.Stock;

public class StockEvaluator {

    public EvaluationResult evaluate(Stock stock) {
        EvaluationResult result = new EvaluationResult();

        result.check1PriceVsMax = stock.getCurrentPrice() < stock.getHistoricalMaxPrice5Y();
        result.check2CapVsEV = stock.getMarketCap() > stock.getEnterpriseValue();

        if (stock.getEbitda() > 0) {
            double ratio = stock.getNetDebt() / stock.getEbitda();
            result.check3DebtVsEBITDA = ratio < 2;
        } else {
            result.check3DebtVsEBITDA = false;
        }

        double per = stock.getPer();
        if (per <= 17) {
            result.perLevel = Check4PERLevel.LOW;
        } else if (per <= 25) {
            result.perLevel = Check4PERLevel.MEDIUM;
        } else {
            result.perLevel = Check4PERLevel.HIGH;
        }

        result.check5Analysts = stock.getAnalystRating() == AnalystRating.BUY;

        return result;
    }
}

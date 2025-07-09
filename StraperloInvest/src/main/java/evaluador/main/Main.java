package evaluador.main;

import evaluador.api.ApiClient;
import evaluador.api.StockEvaluationService;
import evaluador.logic.StockEvaluator;
import evaluador.logic.StockFactory;
import evaluador.model.EvaluationResult;
import evaluador.model.Stock;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        StockEvaluationService.evaluarTicker("MSFT");
        StockEvaluationService.evaluarTicker("AAPL");
        StockEvaluationService.evaluarTicker("VXUS"); // ETF de prueba
    }
}

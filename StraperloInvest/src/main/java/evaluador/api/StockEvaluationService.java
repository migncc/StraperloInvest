package evaluador.api;
import evaluador.logic.StockEvaluator;
import evaluador.model.EvaluationResult;
import evaluador.model.Stock;
import evaluador.logic.StockFactory;
import evaluador.api.ApiClient;
import org.json.JSONObject;

public class StockEvaluationService {

    public static void evaluarTicker(String ticker) {
        try {
            JSONObject json = ApiClient.getStockData(ticker);
            Stock stock = StockFactory.fromJson(json);

            StockEvaluator evaluator = new StockEvaluator();
            EvaluationResult result = evaluator.evaluate(stock);

            System.out.println(stock);
            System.out.println("📊 Evaluación:\n" + result);
        } catch (Exception e) {
            System.out.println("❌ Error al evaluar el ticker: " + ticker);
            e.printStackTrace();
        }
    }
}

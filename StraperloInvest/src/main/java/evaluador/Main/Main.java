package evaluador.Main;

import evaluador.model.AnalystRating;
import evaluador.model.EvaluationResult;
import evaluador.model.Stock;
import evaluador.logic.StockEvaluator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Stock ideal = new Stock(
                "Ideal Corp", "IDL", "US0000000001",
                150.0, 180.0,                   // current < max → ✅
                500_000_000.0, 450_000_000.0,   // cap > EV → ✅
                50_000_000.0, 80_000_000.0,     // deuda/ebitda = 0.625 → ✅
                17.0,                           // PER bajo → ✅
                AnalystRating.BUY              // ✅
        );
        Stock sobrevalorada = new Stock(
                "Riesgolandia S.A.", "RGL", "US0000000002",
                75.0, 70.0,                    // current > max → ❌
                300_000_000.0, 450_000_000.0,  // EV > cap → ❌
                120_000_000.0, 30_000_000.0,   // deuda/ebitda = 4.0 → ❌
                42.0,                          // PER alto → ❌
                AnalystRating.SELL            // ❌
        );
        Stock mixta = new Stock(
                "Equilibrada Ltd", "EQB", "US0000000003",
                120.0, 130.0,                   // ✅
                200_000_000.0, 200_000_000.0,   // cap == EV → ❌ (según regla)
                40_000_000.0, 40_000_000.0,     // deuda/ebitda = 1.0 → ✅
                24.0,                           // PER medio → ⚠️
                AnalystRating.HOLD             // ❌
        );
        Stock sinEbitda = new Stock(
                "StartupX", "STX", "US0000000004",
                10.0, 20.0,
                100_000_000.0, 90_000_000.0,
                20_000_000.0, 0.0,             // ⚠️ EBITDA 0 → ❌
                19.5,
                AnalystRating.BUY
        );
        List<Stock> stocks = Arrays.asList(ideal, sobrevalorada, mixta, sinEbitda);
        StockEvaluator evaluator = new StockEvaluator();

        for (Stock stock : stocks) {
            System.out.println("─────────────────────────────");
            System.out.println(stock);
            EvaluationResult result = evaluator.evaluate(stock);
            System.out.println("📊 Evaluación:\n" + result + "\n");
        }

    }
}

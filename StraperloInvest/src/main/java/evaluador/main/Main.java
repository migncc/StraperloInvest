package evaluador.main;

import evaluador.model.*;
import evaluador.logic.StockEvaluator;
import evaluador.logic.PortfolioEvaluator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Stock ideal = new Stock(
                "Ideal Corp", "IDL", "US0000000001",
                10_000.0, "TECHNOLOGY", "EE.UU", RiskLevel.LOW,
                150.0, 180.0,   // ✅ debajo del máximo
                500_000_000.0, 450_000_000.0,  // ✅ cap > EV
                50_000_000.0, 80_000_000.0,     // ✅ ratio deuda/ebitda = 0.625
                17.0,   // ✅ PER aceptable para tech
                AnalystRating.BUY   // ✅ señal positiva
        );

        Stock sobrevalorada = new Stock(
                "Riesgolandia S.A.", "RGL", "US0000000002",
                8_000.0, "FINANCIAL", "Alemania", RiskLevel.HIGH,
                75.0, 70.0,   // ❌ en máximos
                300_000_000.0, 450_000_000.0,  // ❌ cap < EV
                120_000_000.0, 30_000_000.0,   // ❌ deuda/ebitda = 4.0
                42.0,   // ❌ PER altísimo
                AnalystRating.SELL   // ❌
        );

        Stock mixta = new Stock(
                "Equilibrada Ltd", "EQB", "US0000000003",
                12_500.0, "HEALTHCARE", "Francia", RiskLevel.MEDIUM,
                120.0, 130.0,
                200_000_000.0, 200_000_000.0,
                40_000_000.0, 40_000_000.0,
                24.0,
                AnalystRating.HOLD
        );

        Stock sinEbitda = new Stock(
                "StartupX", "STX", "US0000000004",
                6_000.0, "TECHNOLOGY", "China", RiskLevel.HIGH,
                10.0, 20.0,
                100_000_000.0, 90_000_000.0,
                20_000_000.0, 0.0,
                19.5,
                AnalystRating.BUY
        );

        List<Stock> stocks = List.of(ideal, sobrevalorada, mixta, sinEbitda);
        StockEvaluator evaluator = new StockEvaluator();

        System.out.println("📈 ANÁLISIS DE ACCIONES INDIVIDUALES\n");

        for (Stock stock : stocks) {
            System.out.println("─────────────────────────────");
            System.out.println(stock);
            EvaluationResult result = evaluator.evaluate(stock);
            System.out.println("📊 Evaluación:\n" + result);
            System.out.printf("📈 Nota final: %.2f / 10.00%n%n", result.getFinalScore());
        }

        System.out.println("\n📁 RESUMEN DE CARTERA\n");

        Portfolio portfolio = new Portfolio();
        stocks.forEach(portfolio::addAsset);

        System.out.println(portfolio);
        System.out.println();

        PortfolioEvaluator peval = new PortfolioEvaluator();
        peval.printPortfolioSummary(portfolio);
    }
}

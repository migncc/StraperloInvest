package evaluador.logic;

import evaluador.model.Asset;
import evaluador.model.Portfolio;

import java.util.*;
import java.util.stream.Collectors;

public class PortfolioEvaluator {

    public void printBreakdownByCountry(Portfolio portfolio) {
        System.out.println("🌍 Distribución por país:");
        printGroupedBy(portfolio, asset -> {
            String country = asset.getCountry();
            return (country != null && !country.isBlank()) ? country : "Desconocido";
        });
    }

    public void printBreakdownBySector(Portfolio portfolio) {
        System.out.println("🏭 Distribución por sector:");
        printGroupedBy(portfolio, asset -> {
            String sector = asset.getSector();
            return (sector != null && !sector.isBlank()) ? sector : "Desconocido";
        });
    }

    public void printBreakdownByType(Portfolio portfolio) {
        System.out.println("📦 Distribución por tipo de activo:");
        printGroupedBy(portfolio, asset -> asset.getType().name());
    }

    public void printBreakdownByRisk(Portfolio portfolio) {
        System.out.println("🚦 Distribución por nivel de riesgo:");
        printGroupedBy(portfolio, asset -> {
            return (asset.getRiskLevel() != null) ? asset.getRiskLevel().name() : "Desconocido";
        });
    }

    private void printGroupedBy(Portfolio portfolio, java.util.function.Function<Asset, String> classifier) {
        List<Asset> filteredAssets = portfolio.getAssets().stream()
                .filter(asset -> asset.getAmount() > 0)
                .toList();

        double total = filteredAssets.stream()
                .mapToDouble(Asset::getAmount)
                .sum();

        Map<String, Double> grouped = filteredAssets.stream()
                .collect(Collectors.groupingBy(
                        classifier,
                        Collectors.summingDouble(Asset::getAmount)
                ));

        grouped.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {
                    String key = entry.getKey();
                    double value = entry.getValue();
                    double percent = (value / total) * 100;
                    System.out.printf(" - %-15s → €%,.2f (%.2f%%)%n", key, value, percent);
                });

        System.out.println("─────────────────────────────");
        System.out.printf("💰 Total: €%,.2f%n%n", total);
    }

    public void printPortfolioSummary(Portfolio portfolio) {
        printBreakdownByType(portfolio);
        printBreakdownByCountry(portfolio);
        printBreakdownBySector(portfolio);
        printBreakdownByRisk(portfolio);
    }
}

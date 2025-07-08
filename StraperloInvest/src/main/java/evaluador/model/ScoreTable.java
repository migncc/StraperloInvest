package evaluador.model;

import java.util.*;

public class ScoreTable {
    private static final Map<String, List<ScoreRange>> table = new HashMap<>();

    static {
        table.put("GENERIC_PER", List.of(
                new ScoreRange(0, 15, 1.0),
                new ScoreRange(15, 20, 0.75),
                new ScoreRange(20, 25, 0.5),
                new ScoreRange(25, 30, 0.25),
                new ScoreRange(30, Double.MAX_VALUE, 0.0)
        ));
        // PER por sector
        table.put("TECHNOLOGY_PER", List.of(
                new ScoreRange(0, 20, 1.0),
                new ScoreRange(20, 30, 0.75),
                new ScoreRange(30, 40, 0.5),
                new ScoreRange(40, 50, 0.25),
                new ScoreRange(50, Double.MAX_VALUE, 0.0)
        ));

        table.put("ENERGY_PER", List.of(
                new ScoreRange(0, 10, 1.0),
                new ScoreRange(10, 15, 0.75),
                new ScoreRange(15, 20, 0.5),
                new ScoreRange(20, 30, 0.25),
                new ScoreRange(30, Double.MAX_VALUE, 0.0)
        ));

        // FINANCIAL
        table.put("FINANCIAL_PER", List.of(
                new ScoreRange(0, 13, 1.0),
                new ScoreRange(13, 18, 0.75),
                new ScoreRange(18, 22, 0.5),
                new ScoreRange(22, 30, 0.25),
                new ScoreRange(30, Double.MAX_VALUE, 0.0)
        ));

        // HEALTHCARE
        table.put("HEALTHCARE_PER", List.of(
                new ScoreRange(0, 18, 1.0),
                new ScoreRange(18, 24, 0.75),
                new ScoreRange(24, 30, 0.5),
                new ScoreRange(30, 40, 0.25),
                new ScoreRange(40, Double.MAX_VALUE, 0.0)
        ));

        // CONSUMER CYCLICAL
        table.put("CONSUMER_CYCLICAL_PER", List.of(
                new ScoreRange(0, 20, 1.0),
                new ScoreRange(20, 30, 0.75),
                new ScoreRange(30, 40, 0.5),
                new ScoreRange(40, 50, 0.25),
                new ScoreRange(50, Double.MAX_VALUE, 0.0)
        ));

        // INDUSTRIALS
        table.put("INDUSTRIALS_PER", List.of(
                new ScoreRange(0, 17, 1.0),
                new ScoreRange(17, 23, 0.75),
                new ScoreRange(23, 30, 0.5),
                new ScoreRange(30, 40, 0.25),
                new ScoreRange(40, Double.MAX_VALUE, 0.0)
        ));

        // UTILITIES
        table.put("UTILITIES_PER", List.of(
                new ScoreRange(0, 14, 1.0),
                new ScoreRange(14, 18, 0.75),
                new ScoreRange(18, 24, 0.5),
                new ScoreRange(24, 30, 0.25),
                new ScoreRange(30, Double.MAX_VALUE, 0.0)
        ));

        // REAL ESTATE
        table.put("REAL_ESTATE_PER", List.of(
                new ScoreRange(0, 18, 1.0),
                new ScoreRange(18, 25, 0.75),
                new ScoreRange(25, 32, 0.5),
                new ScoreRange(32, 40, 0.25),
                new ScoreRange(40, Double.MAX_VALUE, 0.0)
        ));

        // MATERIALS
        table.put("MATERIALS_PER", List.of(
                new ScoreRange(0, 16, 1.0),
                new ScoreRange(16, 22, 0.75),
                new ScoreRange(22, 28, 0.5),
                new ScoreRange(28, 35, 0.25),
                new ScoreRange(35, Double.MAX_VALUE, 0.0)
        ));

        // COMMUNICATION SERVICES
        table.put("COMMUNICATION_SERVICES_PER", List.of(
                new ScoreRange(0, 20, 1.0),
                new ScoreRange(20, 28, 0.75),
                new ScoreRange(28, 36, 0.5),
                new ScoreRange(36, 45, 0.25),
                new ScoreRange(45, Double.MAX_VALUE, 0.0)
        ));

        // NetDebt/EBITDA (general)
        table.put("DEBT_RATIO", List.of(
                new ScoreRange(0, 1, 1.0),
                new ScoreRange(1, 2, 0.75),
                new ScoreRange(2, 3, 0.5),
                new ScoreRange(3, 4, 0.25),
                new ScoreRange(4, Double.MAX_VALUE, 0.0)
        ));
    }

    public static double getScore(String key, double value) {
        List<ScoreRange> ranges = table.getOrDefault(key, Collections.emptyList());
        return ranges.stream()
                .filter(r -> r.isInRange(value))
                .findFirst()
                .map(ScoreRange::getScore)
                .orElse(0.0);
    }
}

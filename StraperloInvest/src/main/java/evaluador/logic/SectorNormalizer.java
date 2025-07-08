package evaluador.logic;

import java.util.HashMap;
import java.util.Map;

public class SectorNormalizer {

    private static final Map<String, String> sectorToScoreKey = new HashMap<>();

    static {
        sectorToScoreKey.put("Technology", "TECHNOLOGY_PER");
        sectorToScoreKey.put("Financial Services", "FINANCIAL_PER");
        sectorToScoreKey.put("Energy", "ENERGY_PER");
        sectorToScoreKey.put("Consumer Cyclical", "CONSUMER_CYCLICAL_PER");
        sectorToScoreKey.put("Healthcare", "HEALTHCARE_PER");
        sectorToScoreKey.put("Industrials", "INDUSTRIALS_PER");
        sectorToScoreKey.put("Utilities", "UTILITIES_PER");
        sectorToScoreKey.put("Real Estate", "REAL_ESTATE_PER");
        sectorToScoreKey.put("Materials", "MATERIALS_PER");
        sectorToScoreKey.put("Communication Services", "COMMUNICATION_SERVICES_PER");
        // Puedes seguir añadiendo más...
    }

    public static String getScoreKey(String sector) {
        if (sector == null || !sectorToScoreKey.containsKey(sector)) {
            System.out.println("⚠️ Sector no mapeado o desconocido: \"" + sector + "\". Usando tabla genérica.");
            return "GENERIC_PER";
        }
        return sectorToScoreKey.get(sector);
    }
}


package evaluador.logic;

import evaluador.model.*;
import org.json.JSONObject;

public class StockFactory {

    public static Stock fromJson(JSONObject json) {
        // Extraemos los campos con validación básica
        String name = json.optString("name", "Unknown");
        String ticker = json.optString("ticker", "N/A");
        String isin = json.optString("isin", "N/A");

        String sector = json.optString("sector", "GENERIC");
        String country = json.optString("country", "Desconocido");

        double currentPrice = json.optDouble("currentPrice", 0.0);
        double maxPrice5Y = json.optDouble("historicalMaxPrice5Y", 0.0);
        double marketCap = json.optDouble("marketCap", 0.0);
        double enterpriseValue = json.optDouble("enterpriseValue", 0.0);
        double netDebt = json.optDouble("netDebt", 0.0);
        double ebitda = json.optDouble("ebitda", 0.0);
        double per = json.optDouble("per", 0.0);

        String ratingStr = json.optString("analystRating", "NONE");

        // Carga neutra (no se está comprando todavía)
        double amount = 0.0;

        return new Stock(
                name, ticker, isin,
                amount, sector, country, RiskLevel.MEDIUM, // riesgo neutro
                currentPrice, maxPrice5Y,
                marketCap, enterpriseValue,
                netDebt, ebitda, per,
                ratingStr
        );
    }
}

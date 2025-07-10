package evaluador.logic;

import evaluador.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StockFactory {

    public static Stock fromJson(JSONObject json) {
        // Campos básicos
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
        System.out.println("PER crudo recibido: " + per);


        String ratingStr = json.optString("analystRating", "NONE");

        // Preparamos la lista de históricos
        List<Double> historicalPrices = new ArrayList<>();
        JSONArray historicalArray = json.optJSONArray("historicalPrices");
        if (historicalArray != null) {
            for (int i = 0; i < historicalArray.length(); i++) {
                historicalPrices.add(historicalArray.optDouble(i, 0.0));
            }
        }

        // Carga neutra (no se está comprando todavía)
        double amount = 0.0;

        return new Stock(
                name, ticker, isin,
                amount, sector, country, RiskLevel.MEDIUM,
                currentPrice, maxPrice5Y,
                marketCap, enterpriseValue,
                netDebt, ebitda, per,
                ratingStr, historicalPrices
        );
    }
}

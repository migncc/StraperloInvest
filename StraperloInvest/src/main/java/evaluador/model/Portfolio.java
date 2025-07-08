package evaluador.model;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Asset> assets = new ArrayList<>();


    public Portfolio() {
        this.assets = new ArrayList<>();
    }

    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public double getTotalAmount() {
        return assets.stream().mapToDouble(Asset::getAmount).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("📊 Cartera actual:\n");
        for (Asset asset : assets) {
            sb.append("─────────────────────────────\n");
            sb.append(asset.toString()).append("\n");
        }
        sb.append("💰 Total invertido: ").append(String.format("€%,.2f", getTotalAmount()));
        return sb.toString();
    }
}

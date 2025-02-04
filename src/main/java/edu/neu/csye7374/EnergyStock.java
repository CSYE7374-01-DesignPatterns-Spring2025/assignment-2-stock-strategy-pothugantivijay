package edu.neu.csye7374;

public class EnergyStock extends Stock {
    public EnergyStock(String ID, String name, double price, String description, PricingStrategy pricingStrategy) {
        super(ID, name, price, description, pricingStrategy);
    }

    @Override
    public int getMetric() {
        if (bidHistory.isEmpty()) return 0;

        double mean = bidHistory.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double variance = bidHistory.stream()
                .mapToDouble(bid -> Math.pow(bid - mean, 2))
                .sum() / bidHistory.size();

        return (int) -variance; // Negative variance indicating better stability
    }
}
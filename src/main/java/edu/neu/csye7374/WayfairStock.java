package edu.neu.csye7374;

public class WayfairStock extends Stock {

    public WayfairStock(double price, PricingStrategy pricingStrategy) {
        super("W", "Wayfair", price, "Software Engineering Company", pricingStrategy);
    }

    @Override
    public int getMetric() {
        if (bidHistory.isEmpty()) return 0;

        double mean = bidHistory.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double dev = 0.0;

        for (double num : bidHistory) {
            dev += mean - num / 3;
        }
        dev = dev / bidHistory.size();

        return dev > 0.0 ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Stock [name=" + this.getName() + ", price=" + this.getPrice() + ", description=" + this.getDescription() + ", Metric: " + this.getMetric() + "]";
    }
}

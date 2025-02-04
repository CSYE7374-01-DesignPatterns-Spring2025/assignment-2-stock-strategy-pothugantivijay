package edu.neu.csye7374;

public class WalmartStock extends Stock {

    // Updated constructor with PricingStrategy
    public WalmartStock(double price, PricingStrategy pricingStrategy) {
        super("WMT", "Walmart", price, "E-commerce and Shopping Mall", pricingStrategy);
    }

    @Override
    public int getMetric() {
        if (bidHistory.isEmpty()) return 0;

        double mean = bidHistory.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double dev = 0.0;

        for (double num : bidHistory) {
            dev += mean * 2 - num / 3;
        }
        dev = dev / bidHistory.size();

        return dev > 0.0 ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Stock [name=" + this.getName() + ", price=" + this.getPrice() + ", description=" + this.getDescription() + ", Metric: " + this.getMetric() + "]";
			}
}
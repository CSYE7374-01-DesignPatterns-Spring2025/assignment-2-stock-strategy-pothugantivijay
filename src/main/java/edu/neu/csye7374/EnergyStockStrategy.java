package edu.neu.csye7374;
public class EnergyStockStrategy implements PricingStrategy {
    @Override
    public double computeNewPrice(double currentPrice) {
        // Energy-specific algorithm (e.g., stable growth)
        return currentPrice * 1.03;
    }
}
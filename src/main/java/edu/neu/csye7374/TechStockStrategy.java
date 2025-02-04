package edu.neu.csye7374;
public class TechStockStrategy implements PricingStrategy {
    @Override
    public double computeNewPrice(double currentPrice) {
        // Tech-specific algorithm (e.g., high volatility)
        return currentPrice * (1 + (Math.random() * 0.1 - 0.05));
    }
}
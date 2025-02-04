package edu.neu.csye7374;

public class WalmartStockFactory extends AbstractFactory {
    private PricingStrategy strategy; // Add strategy field

    public WalmartStockFactory(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Stock getObject(double price) {
        return new WalmartStock(price, strategy); // Pass strategy to constructor
    }
}
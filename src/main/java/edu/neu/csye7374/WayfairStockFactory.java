package edu.neu.csye7374;

public class WayfairStockFactory extends AbstractFactory {
	private PricingStrategy strategy;

	public WayfairStockFactory(PricingStrategy strategy) {
        this.strategy = strategy;
    }

	@Override
	public Stock getObject(double price) {
		return new WayfairStock(price, strategy);
	}
}

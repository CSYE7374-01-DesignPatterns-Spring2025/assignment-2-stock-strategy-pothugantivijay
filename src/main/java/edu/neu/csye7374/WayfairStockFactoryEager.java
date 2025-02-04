package edu.neu.csye7374;

public class WayfairStockFactoryEager extends AbstractFactory {

	private WayfairStockFactoryEager() {

	}

	private static final AbstractFactory instance = new WayfairStockFactoryEager();

	public static AbstractFactory getInstance() {
		return instance;
	}

	public Stock getObject(double price) {
		return new WayfairStock(price, null);
	}
}

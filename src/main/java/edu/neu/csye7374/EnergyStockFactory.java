package edu.neu.csye7374;

public class EnergyStockFactory extends AbstractFactory {
    @Override
    public Stock getObject(double price) {
        return new EnergyStock("ENERGY_ID", "Energy Stock", price, "Energy sector", new BearMarketStrategy());
    }
}
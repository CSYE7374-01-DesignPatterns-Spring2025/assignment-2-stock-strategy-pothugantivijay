package edu.neu.csye7374;

public class BullMarketStrategy implements PricingStrategy {
    @Override
    public double computeNewPrice(double currentPrice){
        return currentPrice*1.05;
    }
}

package edu.neu.csye7374;

public abstract class BaseStock {
    private String symbol;
    private double price;
    private PricingStrategy PricingStrategy;
    public BaseStock(String symbol, double price, PricingStrategy strategy){
        this.symbol = symbol;
        this.price = price;
        this.PricingStrategy = strategy;
    }
    
    public void updatePrice(){
        this.price = PricingStrategy.computeNewPrice(price);
    }
    public void setPricingStrategy(PricingStrategy strategy){
        this.PricingStrategy = strategy;
    }
    public double getPrice(){
        return price;
    }
    public String getSymbol(){
        return symbol;
    }
}

package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public abstract class Stock implements Tradable {
    protected String ID;
    protected String name;
    protected double price;
    protected String description;
    protected List<Double> bidHistory = new ArrayList<>();
    protected PricingStrategy pricingStrategy; // Strategy pattern

    public Stock(String ID, String name, double price, String description, PricingStrategy pricingStrategy) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.pricingStrategy = pricingStrategy;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }


    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void updatePrice() {
        if (pricingStrategy != null) {
            this.price = pricingStrategy.computeNewPrice(this.price);
            System.out.println("Updated price for " + name + ": " + this.price);
        } else {
            System.out.println("No pricing strategy set for " + name);
        }
    }
    

    @Override
    public void setBid(String bid) {
        try {
            double bidValue = Double.parseDouble(bid);
            bidHistory.add(bidValue);
            price = bidValue; // Update price based on the latest bid
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format: " + bid);
        }
    }

    @Override
    public abstract int getMetric();

    @Override
    public String toString() {
        return String.format(
            "[Stock ID:%s name=%s, price:%.2f, description:%s, metric:%d]",
            ID, name, price, description, getMetric()
        );
    }
}
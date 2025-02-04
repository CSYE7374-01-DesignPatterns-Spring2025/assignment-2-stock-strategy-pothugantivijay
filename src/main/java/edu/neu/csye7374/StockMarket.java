package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance; // Lazy Singleton instance
    private List<Stock> stocks = new ArrayList<>();

    private StockMarket() {
        instance = null;
    }

    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void tradeStock(String stockName, String bid) {
        boolean found = false;
        for (Stock stock : stocks) {
            if (stock.ID.equals(stockName)) {
                stock.setBid(bid);
                System.out.println("Traded " + stockName + " with bid: " + bid);
                System.out.println(stockName + " New " + stock.getMetric());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Stock " + stockName + " not found in the market.");
        }
    }
    

    public void removeStock(String stockName) {
        stocks.removeIf(stock -> stock.ID.equals(stockName));
    }

    public void showAllStocks() {
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }

    public static void demo() {
        StockMarket stockExchange = StockMarket.getInstance();

        // Create strategies
        PricingStrategy bullMarketStrategy = new BullMarketStrategy();
        PricingStrategy bearMarketStrategy = new BearMarketStrategy();

        // Create stocks with initial strategies
        TechStock techStock = new TechStock("AAPL", "Apple Inc.", 200.0, "Innovative consumer electronics company", bullMarketStrategy);
        EnergyStock energyStock = new EnergyStock("PFE", "Pfizer Inc.", 75.0, "Global pharmaceutical leader", bearMarketStrategy);
        EnergyStock energyStock2 = new EnergyStock("BP", "BP Plc", 50.0, "Multinational oil and gas company", bullMarketStrategy);

        stockExchange.addStock(techStock);
        stockExchange.addStock(energyStock);
        stockExchange.addStock(energyStock2);

        // Simulate trading and price updates
        System.out.println("Simulating bids for Apple Inc. (AAPL):");
        stockExchange.tradeStock("AAPL", "210");
        stockExchange.tradeStock("AAPL", "220");
        stockExchange.tradeStock("AAPL", "230");
        stockExchange.tradeStock("AAPL", "225");
        stockExchange.tradeStock("AAPL", "240");
        stockExchange.tradeStock("AAPL", "250");

        System.out.println("\nSimulating bids for Pfizer Inc. (PFE):");
        stockExchange.tradeStock("PFE", "76");
        stockExchange.tradeStock("PFE", "78");
        stockExchange.tradeStock("PFE", "80");
        stockExchange.tradeStock("PFE", "79");
        stockExchange.tradeStock("PFE", "81");
        stockExchange.tradeStock("PFE", "82");

        System.out.println("\nSimulating bids for BP Plc (BP):");
        stockExchange.tradeStock("BP", "52");
        stockExchange.tradeStock("BP", "54");
        stockExchange.tradeStock("BP", "53");

        // Update prices based on the current strategy
        techStock.updatePrice(); // AAPL stock price increases by 5%
        energyStock.updatePrice(); // PFE stock price decreases by 5%
        energyStock2.updatePrice(); // BP stock price increases by 5%

        // Show all stocks
        stockExchange.showAllStocks();

        // Remove a stock
        stockExchange.removeStock("BP");
        System.out.println("Showing stocks after remove call:");
        stockExchange.showAllStocks();
    }
}
import java.util.*;

public class StockTradingPlatform {

    static Scanner sc = new Scanner(System.in);
    static double balance = 10000.0; // Starting balance
    static Map<String, Double> market = new LinkedHashMap<>();
    static Map<String, Integer> portfolio = new LinkedHashMap<>();

    public static void main(String[] args) {
        // Initialize market stocks
        market.put("APPLE", 182.50);
        market.put("GOOGLE", 140.30);
        market.put("AMAZON", 195.00);
        market.put("TESLA", 250.75);
        market.put("INFOSYS", 18.40);

        int choice;
        do {
            System.out.println("\n===== Stock Trading Platform =====");
            System.out.printf("💰 Balance: $%.2f%n", balance);
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewMarket();
                case 2 -> buyStock();
                case 3 -> sellStock();
                case 4 -> viewPortfolio();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void viewMarket() {
        System.out.println("\n--- Market Data ---");
        System.out.printf("%-15s %s%n", "Stock", "Price (USD)");
        System.out.println("----------------------------");
        for (Map.Entry<String, Double> entry : market.entrySet()) {
            System.out.printf("%-15s $%.2f%n", entry.getKey(), entry.getValue());
        }
    }

    static void buyStock() {
        viewMarket();
        System.out.print("\nEnter stock name to buy: ");
        String stock = sc.nextLine().toUpperCase();
        if (!market.containsKey(stock)) {
            System.out.println("Stock not found!");
            return;
        }
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt(); sc.nextLine();
        double cost = market.get(stock) * qty;
        if (cost > balance) {
            System.out.printf("Insufficient balance! Need $%.2f but have $%.2f%n", cost, balance);
            return;
        }
        balance -= cost;
        portfolio.merge(stock, qty, Integer::sum);
        System.out.printf("✅ Bought %d shares of %s for $%.2f%n", qty, stock, cost);
    }

    static void sellStock() {
        if (portfolio.isEmpty()) {
            System.out.println("No stocks in portfolio!");
            return;
        }
        viewPortfolio();
        System.out.print("\nEnter stock name to sell: ");
        String stock = sc.nextLine().toUpperCase();
        if (!portfolio.containsKey(stock)) {
            System.out.println("You don't own this stock!");
            return;
        }
        System.out.print("Enter quantity to sell: ");
        int qty = sc.nextInt(); sc.nextLine();
        if (qty > portfolio.get(stock)) {
            System.out.println("Not enough shares!");
            return;
        }
        double earnings = market.get(stock) * qty;
        balance += earnings;
        portfolio.merge(stock, -qty, Integer::sum);
        if (portfolio.get(stock) == 0) portfolio.remove(stock);
        System.out.printf("✅ Sold %d shares of %s for $%.2f%n", qty, stock, earnings);
    }

    static void viewPortfolio() {
        if (portfolio.isEmpty()) {
            System.out.println("Portfolio is empty.");
            return;
        }
        System.out.println("\n--- Your Portfolio ---");
        System.out.printf("%-15s %-10s %-15s%n", "Stock", "Shares", "Current Value");
        System.out.println("--------------------------------------");
        double total = 0;
        for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
            String stock = entry.getKey();
            int qty = entry.getValue();
            double val = market.get(stock) * qty;
            total += val;
            System.out.printf("%-15s %-10d $%-14.2f%n", stock, qty, val);
        }
        System.out.printf("%nTotal Portfolio Value: $%.2f%n", total);
        System.out.printf("Cash Balance         : $%.2f%n", balance);
        System.out.printf("Net Worth            : $%.2f%n", (total + balance));
    }
}
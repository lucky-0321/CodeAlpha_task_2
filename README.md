# CodeAlpha_task_2
Stock Trading PlatformA console-based simulated trading application built in Java. It allows users to view live stock market data, buy and sell shares using a simulated virtual balance, track their investment portfolio, and monitor their real-time net worth.  🚀 FeaturesReal-time Market Data: View available stocks (like Apple, Google, Amazon, Tesla, and Infosys) along with their current prices.  Simulated Buying: Purchase shares instantly if you have an adequate cash balance ($10,000.00 starting balance).  Simulated Selling: Sell owned shares from your portfolio back into the market at current rates to liquidate cash.  Portfolio & Net Worth Tracking: View a comprehensive breakdown of your owned shares, total portfolio asset value, cash balance, and overall net worth.  🛠️ Technical Details & Data StructuresLanguage: Java  LinkedHashMap (market): Used to store pre-defined stock tickers and their matching prices while preserving a predictable insertion order.  LinkedHashMap (portfolio): Tracks the quantities of shares owned by the user, dynamically updating when buying, selling, or completely liquidating a stock position.  Console Interface: Uses an interactive menu loop driven by java.util.Scanner for seamless user choices.  📋 How It Works (Sample Execution)When run, the application presents a menu to manage your finances:  Plaintext===== Stock Trading Platform =====
💰 Balance: $10000.00
1. View Market
2. Buy Stock
3. Sell Stock
4. View Portfolio
5. Exit
Enter choice: 
Buying a Stock Example:PlaintextEnter stock name to buy: APPLE
Enter quantity: 10
✅ Bought 10 shares of APPLE for $1825.00
⚙️ How to Run LocallyPrerequisitesEnsure you have the Java Development Kit (JDK) installed on your system.Execution StepsClone the repository:Bashgit clone https://github.com/YOUR_USERNAME/StockTradingPlatform.git
Navigate to the directory:Bashcd StockTradingPlatform
Compile the Java file:Bashjavac StockTradingPlatform.java
Run the application:Bashjava StockTradingPlatform

import java.util.ArrayList; // Import scanner for input
import java.util.Scanner; // Import arrayList




public class Main { //Creating class
	static ArrayList<Account> accounts = new ArrayList<Account>(); // Account list
	static ArrayList<Stock> stocks = new ArrayList<Stock>(); // Stocks list


	public static void main (String [] args) { //main method
		mainMenu(); // Call our main menu method
	}//close main method




	public static void mainMenu() { //method to display main method
		//Variable Declaration and Initialization
		int input = 0;
		boolean inputAssured = false; // Assuring input
		Scanner userInput = new Scanner(System.in); // Creating the canner for user Input


		//Menu output
		System.out.printf("Program Execution Main Menu:\n"); //welcoming the user to the submenu
		System.out.printf("1.\tCustomer Account Management\n");
		System.out.printf("2.\tStock Management & Transactions\n");
		System.out.printf("3.\tGenerate Reports\n");
		System.out.printf("4.\tRandom Market Movement\n");
		System.out.printf("5.\tCookie Random Catastrophe\n");
		System.out.printf("6.\tQuit\n");




		// Using a try catch to assure input
		while (inputAssured == false) {
			try {
				System.out.print("Selection(1-6): "); // Set up line for selection input
				input = userInput.nextInt(); // Asking for int
				inputAssured = true; // Say the userInput was assured
			} catch (Exception e) {
				System.out.println("Error. Please select a number from 1-6");
			} // Close catch
		} // Close while loop


		// Switch to select the menues
		switch(input) {
		case 1: // If you select 1
			System.out.println(""); // For spaceing
			accountManagementSubMenu(); // Call account management submenue
			mainMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 2: // If you select 2
			System.out.println(""); // For spaceing
			stockManagementSubMenu(); // Call stock management submenue
			mainMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 3: // If you select 3
			System.out.println(""); // For spaceing
			generateReportsSubMenu(); // Call report submenue
			mainMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 4: // If you select 4
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spaceing
			mainMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 5: // If you select 5
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spaceing
			mainMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 6: // If you select 6
			// Just break, it'll leave it
			System.out.println(""); // For spaceing
			break;


		default:
			System.out.println(""); // For spaceing
			System.out.printf("Selection made is out of range.");
			mainMenu();


		} // close Switch
	} // Close main menu method


	public static void accountManagementSubMenu() { // Method for our account mangement sub menue
		//Variable Declaration and Intialization
		int input = 0; //variable to hold user's input
		boolean inputAssured = false; // Assuring input
		Scanner userInput = new Scanner(System.in); // Creating the canner for user Input

		// Menu output
		System.out.println(""); // For spaceing
		System.out.printf("Customer Account Management Submenu:\n"); //welcoming the user to the submenu
		System.out.printf("1.\tAdd Account Holder\n");
		System.out.printf("2.\tRemove Account Holder\n");
		System.out.printf("3.\tFund Account\n");
		System.out.printf("4.\tWithdraw Funds\n");
		System.out.printf("5.\tDisplay Account Current Stock Positions\n");
		System.out.printf("6.\tReturn to Main Menu\n");




		// Using a try catch to assure input
		while (inputAssured == false) {
			try {
				System.out.print("Selection(1-6): "); // Set up line for selection input
				input = userInput.nextInt(); // Asking for int
				inputAssured = true; // Say the userInput was assured
			} catch (Exception e) {
				System.out.println("Error. Please select a number from 1-6");
			} // Close catch
		} // Close while loop


		//System.out.println(""); // For spaceing
		// Switch to select the menues
		switch(input) {
		case 1: // If you select 1 (Add Account Holder)
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spaceing
			Account account = new Account(); //creating a new account
			if(account.accountMade) { //if the user accepts the changes
				accounts.add(account);//add the new account to the system wide array list of accounts
			} //if the user does not accept the changes
			//do not add the new account to the system wide array list of accounts
			//close if else statement


			accountManagementSubMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 2: // If you select 2
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spaceing

			removeAccount(); // This is our remove account call

			accountManagementSubMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 3: // If you select 3
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spaceing
			withdrawOrDepositACcount("deposit");
			accountManagementSubMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 4: // If you select 4
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spaceing
			withdrawOrDepositACcount("withdraw");
			accountManagementSubMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 5: // If you select 5
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spaceing
			displayAccount(); // Call display account method
			accountManagementSubMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 6: // If you select 6
			// Just break, it'll leave it
			System.out.println(""); // For spaceing
			break;


		default:
			System.out.printf("Selection made is out of range.");
			System.out.println(""); // For spaceing
			accountManagementSubMenu();


		} // close Switch
	} // close accountManagementSubMenu method




	public static void stockManagementSubMenu() { // Method to display our stock management menue
		//Variable Declaration and Initialization
		int input = 0; //variable to hold user's input
		boolean inputAssured = false; // Assuring input
		Scanner userInput = new Scanner(System.in); // Creating the canner for user Input


		//Menu output
		System.out.printf("Stock Management & Transactions Submenu:\n");//welcoming the user to the submenu
		System.out.printf("1.\tAdd New Stock to Available Stocks\n");
		System.out.printf("2.\tCustomer Purchase of Stock\n");
		System.out.printf("3.\tCustomer Sale of Stock\n");
		System.out.printf("4.\tStock Split 2 for 1\n");
		System.out.printf("5.\tReverse Stock Split 1 for 2\n");
		System.out.printf("6.\tReturn to Main Menu\n");




		// Using a try catch to assure input
		while (inputAssured == false) {
			try {
				System.out.print("Selection(1-6): "); // Set up line for selection input
				input = userInput.nextInt(); // Asking for int
				inputAssured = true; // Say the userInput was assured
			} catch (Exception e) {
				System.out.println("Error. Please select a number from 1-6");
			} // Close catch
		} // Close while loop


		// Switch to select the menues
		switch(input) {
		case 1: // If you select 1 (Add New Stock to Available Stocks)
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spacing
			Stock stock = new Stock(); //creating stock
			if(stock.stockMade) { //if the user accepts the changes
				stocks.add(stock); //add the stock to the system wide arraylist of stocks
			} else { //if the user does not accept the changes
				//do not add the stock to the system wide arraylist of stocks
			}//close else if statement
			stockManagementSubMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 2: // If you select 2 (Customer Purchase of Stock)
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spacing
			//I can add to the outstanding shares of the stock that has been purchased
			customerPurchaseOfStock(); // Call purchase of Stock method
			stockManagementSubMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 3: // If you select 3 (Customer Sale of Stock)
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spacing
			//check account ID
			//display
			//ask what stock they want to buy using ticker
			//make sure they own that stock
			//ask how many shares they want to sell
			//(error handling) no negative number no 0 (if zero is inputted return to calling menu) and no number greater than the shares they already have (if this is inputted allow them to re enter)
			//remove outstanding shares from stock, if user inputs the amount of shares they own then remove them as an owner as well
			//book value and market value must be be for portfolio must be re calculated


			//
			//I can remove the outstanding shares of the stock that has been sold
			customerSaleOfStock();
			stockManagementSubMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 4: // If you select 4 (Stocks Split 2 for 1)
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spacing
			//I will call stockSplitTwoForOne
			stockManagementSubMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 5: // If you select 5 (Reverse Stock Split 1 for 2)
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spacing
			//I will call reverseStockSplitOneForTwo
			stockManagementSubMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 6: // If you select 6 (Return to Main Menu)
			// Just break, it'll leave it
			System.out.println(""); // For spacing
			break;


		default:
			System.out.printf("Selection made is out of range.");
			System.out.println(""); // For spaceing
			stockManagementSubMenu();
		} // close Switch


	} // Close stockManagementSubMenu method



	public static void generateReportsSubMenu() { //Method to display the generate reports submenu
		//Variable Declaration and Intialization
		int input = 0;
		boolean inputAssured = false; // Assuring input
		Scanner userInput = new Scanner(System.in); // Creating the canner for user Input

		//Menu output
		System.out.printf("Generate Reports Submenu:\n"); //welcoming the user to the submenu
		System.out.printf("1.\tView All Current Holders of a Particular Stock\n");
		System.out.printf("2.\tGenerate All Positions For All Accounts\n");
		System.out.printf("3.\tReturn to Main Menu\n");

		// Using a try catch to assure input
		while (inputAssured == false) {
			try {
				System.out.print("Selection(1-6): "); // Set up line for selection input
				input = userInput.nextInt(); // Asking for int
				inputAssured = true; // Say the userInput was assured
			} catch (Exception e) {
				System.out.println("Error. Please select a number from 1-3");
			} // Close catch
		} // Close while loop


		// Switch to select the menues
		switch(input) {
		case 1: // If you select 1
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spaceing
			generateReportsSubMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 2: // If you select 2
			// CALL SELECTION METHOD HERE //
			System.out.println(""); // For spaceing
			generateReportsSubMenu(); // Recall this submenue if you didnt select to leave it
			break;


		case 3: // If you select 6
			// Just break, it'll leave it
			System.out.println(""); // For spaceing
			break;


		default:
			System.out.printf("Selection made is out of range.");
			System.out.println(""); // For spaceing
			generateReportsSubMenu();

		} // close Switch
	}//Close generateReportsSubMenu


	public static void customerPurchaseOfStock() {
		// Variables //
		Scanner userInput = new Scanner(System.in); // For our user Input
		int providedID = 0; // To hold the account id that we're given
		int sharesBought = 0; // To hold the amount of shares we buy
		String providedTicker = ""; // To hold what ticker we have
		boolean inputAssured = false; // To assure our input
		///////////////


		// Get our account ID
		while (!inputAssured) {
			try {
				System.out.print("Please enter a valid account ID: ");
				providedID = userInput.nextInt();
				inputAssured = true; // Assure the input
			} catch (Exception e) {
				userInput.nextLine();
				System.out.println("Error. Please enter a valid number");
			} // Close Try...Catch
		} // Close while loop
		inputAssured = false;


		// If the ID exists move on with the rest
		if (checkAccountID(providedID)) {
			Account accountUsed = getAccount(providedID); // Mark down what account we want to use


			System.out.print("Please enter a stock ticker you wish to buy:"); // Get the ticker provided
			providedTicker = userInput.next();
			userInput.nextLine(); // Clear scanner



			if (checkDuplicateTicker(stocks, providedTicker)) { // Checking to see if the stock exists
				while (!inputAssured) {
					try {
						System.out.print("How many shares do you wish to buy: ");
						sharesBought = userInput.nextInt();


						if (sharesBought < 0) {
							System.out.println("Invalid Input. Returning to submenu");
							return;
						} // Close if

						inputAssured = true; // Assure the input
					} catch (Exception e) {
						userInput.nextLine();
						System.out.println("Invalid Input. Returning to submenu");
						return;
					} // Close Try...Catch
				} // Close while loop


				if (accountUsed.acceptChanges()) {
					Stock stockUsed = stocks.get(getStock(stocks, providedTicker));
					int stockIndex = stocks.indexOf(stockUsed);
					int accountIndex= accounts.indexOf(accountUsed);

					stockUsed.stockChangesWhenPurchasingStock( sharesBought, accountUsed.idNumber, providedTicker, stocks);


					accountUsed.buyShare(providedTicker, stockUsed.marketPrice, sharesBought);


					accounts.set(accountIndex, accountUsed);
					stocks.set(stockIndex, stockUsed);


				} // Close accept changes if
			} else {
				System.out.println("The provided Stock does not exist");
				return; // If the stock doesnt exist retrrn
			}
		} else {
			System.out.println("The provided account ID does not exist");
			return;
		}
	} // close customerPurchaseOfStock method


	public static boolean checkAccountID(int iD) { // Check to see if our account exists
		if (accounts.isEmpty()) {
			System.out.println("No accounts exists yet"); // Incase the
			return false;
		} else {
			return accounts.get(0).checkAccountID(iD);
		}
	} // Close account checkAccountID method


	public static Account getAccount(int iD) { // So we can actually get what account we're working with
		for (int i = 0; i < accounts.size(); i += 1) {
			if (accounts.get(i).idNumber == iD) {
				return accounts.get(i); // Return the account
			} // Close if
		} // Close for loop
		return accounts.get(0); // Return so it doesnt cause a crash as this is only going to be called if the account exists
	} // Close
	

	public static boolean checkDuplicateTicker(ArrayList<Stock> stocks, String tickerCheck) { //this method checks if there is a duplicate ticker, if there is a duplicate ticker the method returns true if there is NOT a duplicate ticker the method returns false


		for(int i = 0; i < stocks.size(); i++) { //for loop to iterate through arraylist of stock objects checking the attribute - ticker to see if the inputted ticker matches a ticker already in use
			if(stocks.get(i).ticker.equals(tickerCheck)) { //if the ticker of a stock object matches the inputted ticker
				return true; //the ticker is already in use
			}//close if statement
		}//close for loop

		return false; //if the ticker is NOT in use
	}//close checkDuplicateTicker


	public static int getStock(ArrayList<Stock> stocks, String ticker) { //this method returns the position of the stock the user is trying to access (an assumption is being made that the stock inputted is valid and actually exists)
		//Variable Declaration and Initialization
		int found = 0; //variable used for holding the location of the stock

		for(int i = 0; i < stocks.size(); i++) { //for loop to iterate through the stock objects and see where the ticker exists
			if(stocks.get(i).ticker.equalsIgnoreCase(ticker)) { //if the ticker equals the stock object's ticker than you have found where the stock exists
				found = i; //return the position
			}//close if statement
		}//close for loop


		return found; //returning the stock's position
	}//close getStock method


	public static void customerSaleOfStock() {
		// Variables //
		Scanner userInput = new Scanner(System.in); // For our user Input
		int providedID = 0; // To hold the account id that we're given
		int sharesSold = 0; // To hold the amount of shares we sell
		String providedTicker = ""; // To hold what ticker we have
		boolean inputAssured = false; // To assure our input
		///////////////


		while (!inputAssured) {
			try {
				System.out.print("Please enter a valid account ID: ");
				providedID = userInput.nextInt();
				inputAssured = true; // Assure the input
			} catch (Exception e) {
				System.out.println("Error. Please enter a valid number");
				userInput.nextLine(); // Clear scanner
			} // Close Try...Catch
		} // Close while loop
		inputAssured = false;

		///// UNFINISHED ///////
		if (checkAccountID(providedID)) {
			Account accountUsed = getAccount(providedID);
			accountUsed.display(); // Display account info

			System.out.print("Please enter a stock ticker you wish to buy:");
			providedTicker = userInput.next();
			userInput.nextLine(); // Clear scanner


			if (checkDuplicateTicker(stocks, providedTicker)) { // Checking to see if the stock exists

				if (accountUsed.bookValues.containsKey(providedTicker)) {


					while (!inputAssured) {
						try {
							System.out.print("How many stocks do you wish to sell: ");
							sharesSold = userInput.nextInt();


							if (sharesSold <= 0) {
								System.out.println("Invalid Input. Returning to calling menu"); // Divide by 0 to trigger catch
								return; // Return to calling menu
							} // Close if

							if (sharesSold > accountUsed.totalShares.get(providedTicker)) {
								System.out.println("Can not sell more shares than you own.");
								System.out.println(5/0); // Trigger catch
							}

							inputAssured = true; // Assure the input
						} catch (Exception e) {
							System.out.println("Please enter a valid number");
							userInput.nextLine(); // Clear scanner
						} // Close Try...Catch
					} // Close while loop
					inputAssured = false;


					if (!accountUsed.bookValues.containsKey(providedTicker)) {
						removeOwner(stocks.get(getStock(stocks, providedTicker)), sharesSold);
						//stockChangesWhenSellingStocks(sharesSold,providedTicker, stocks);

						// Remove account holder
					} // If to remove the account


				} else { // If the account does not own any shares in that stock
					System.out.println("You do not own the stock.");
				}
			} else {
				System.out.println("The provided Stock does not exist");
				return; // If the stock doesn't exist return
			}
		} else {
			System.out.println("The provided account ID does not exist");
			return;
		}

	} // Close sale of Stock


	public static Stock removeOwner(Stock obj, int removeOwner) {//method to remove an owner from a stock object

		for(int i = 0; i < obj.owners.size(); i++) { //for loop iterating through owners of the stock
			if(obj.owners.get(i) == removeOwner) { //if the owner of the stock's account ID matches the owner that needs to be removed remove that owner
				obj.owners.remove(i); //removing the owner
			}//close if statement
		}//close for loop

		return obj; //will return the stock object with the desired owner removed


	}//close removeOwner method


	public static void stockChangesWhenSellingStock(int shares, String ticker, ArrayList<Stock> stocks) { //this method is to change the stock when the user sells a stock (selling some shares NOT all of their shares)
		//Variable Declaration and Initialization
		Scanner userInput = new Scanner(System.in);//creating scanner object
		int locationOfStock = 0; //this variable holds the location of the stock the user is try to access


		//User input and Program processing
		locationOfStock = getStock(stocks, ticker); //finding the position of the stock object and assigning that to the locationOfStock variable
		removeShares(stocks.get(locationOfStock), shares);//this method removes the number of shares owned within a stock (being sold)

	} // Close stockChangesWhenSellingStock method
	

	public static Stock removeShares(Stock obj, int removeShares) { //this method removes the number of shares owned within a stock
		obj.outstandingShares -= removeShares; //the amount of shares decreases by the amount of shares removed
		return obj;//returning the stock object
	}//close removeShares


	public static void removeAccount(){
		Scanner userInput = new Scanner(System.in);
		int accountIndex = 0;
		int providedID = 0;
		boolean inputAssured = false;

		
		while (!inputAssured) {
			try {
				System.out.print("Please enter a valid account ID: ");
				providedID = userInput.nextInt();
				inputAssured = true; // Assure the input
			} catch (Exception e) {
				System.out.println("Error. Please enter a valid number");
				userInput.nextLine(); // Clear scanner
			} // Close Try...Catch
		} // Close while loop
		inputAssured = false;

		if (checkAccountID(providedID)){
			Account providedAccount = getAccount(providedID);
			accountIndex = accounts.indexOf(providedAccount); 
			
			if (providedAccount.acceptChanges()){
				accounts.remove(accountIndex); //Remove the account
			} // Only move the account if you accept the changes

		} else {
			System.out.println("The provided account does not exist. Aborting changes...");
			return; // Return if hte ID doesnt exist
		} // Close else


	} // Close remove account method

	public static void displayAccount(){
	Scanner userInput = new Scanner(System.in);
	int providedID = 0;
	boolean inputAssured = false;

	
	while (!inputAssured) {
		try {
			System.out.print("Please enter a valid account ID: ");
			providedID = userInput.nextInt();
			inputAssured = true; // Assure the input
		} catch (Exception e) {
			System.out.println("Error. Please enter a valid number");
			userInput.nextLine(); // Clear scanner
		} // Close Try...Catch
	} // Close while loop
	inputAssured = false;

	if (checkAccountID(providedID)){
		Account providedAccount = getAccount(providedID);
		providedAccount.display();

	} else {
		System.out.println("The provided account does not exist. Aborting changes...");
		return; // Return if hte ID doesnt exist
	} // Close else


} // Close remove account method


	public static void withdrawOrDepositACcount(String choice){
		Scanner userInput = new Scanner(System.in);
		int providedID = 0;
		boolean inputAssured = false;
		int cashAmmount = 0;

		
		while (!inputAssured) {
			try {
				System.out.print("Please enter a valid account ID: ");
				providedID = userInput.nextInt();
				inputAssured = true; // Assure the input
			} catch (Exception e) {
				System.out.println("Error. Please enter a valid number");
				userInput.nextLine(); // Clear scanner
			} // Close Try...Catch
		} // Close while loop
		inputAssured = false;

		if (checkAccountID(providedID)){
			Account providedAccount = getAccount(providedID);
			
			if (choice.equals("withdraw")){ // Withdraw

				while (!inputAssured) {
					try {
						System.out.print("How much cash would you like to withdraw: ");
						cashAmmount = userInput.nextInt();
						inputAssured = true; // Assure the input
					} catch (Exception e) {
						System.out.println("Error. Please enter a valid number");
						userInput.nextLine(); // Clear scanner
					} // Close Try...Catch
				} // Close while loop
				inputAssured = false;

				providedAccount.withdraw(cashAmmount);

			} else if (choice.equals("deposit")){

				while (!inputAssured) {
					try {
						System.out.print("How much cash would you like to deposit: ");
						cashAmmount = userInput.nextInt();
						inputAssured = true; // Assure the input
					} catch (Exception e) {
						System.out.println("Error. Please enter a valid number");
						userInput.nextLine(); // Clear scanner
					} // Close Try...Catch
				} // Close while loop
				inputAssured = false;

				providedAccount.deposit(cashAmmount);

			} // Deposit

		} else {
			System.out.println("The provided account does not exist. Aborting changes...");
			return; // Return if hte ID doesnt exist
		} // Close else


	} // Close remove account method
} // Close main class

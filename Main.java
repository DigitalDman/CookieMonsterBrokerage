import java.util.Scanner; // Import scanner for input
import java.util.ArrayList; // Import arrayList

public class Main{//Creating class
  static ArrayList<Account> accounts = new ArrayList<Account>(); // Account list
  static ArrayList<Stock> stocks = new ArrayList<Stock>(); // Stocks list

public static void main (String [] args){//main method 
  mainMenu(); // Call our main menu method
}//close main method 

public static void mainMenu(){ //method to display main method
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
        while (inputAssured == false){
            try {
                System.out.print("Selection(1-6): "); // Set up line for selection input
                input = userInput.nextInt(); // Asking for int
                inputAssured = true; // Say the userInput was assured
            } catch (Exception e) {
                System.out.println("Error. Please select a number from 1-6");
            } // Close catch
        } // Close while loop

        // Switch to select the menues
        switch(input){
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

public static void accountManagementSubMenu(){ // Method for our account mangement sub menue
  //Variable Declaration and Intialization 
  int input = 0; //variable to hold user's input 
  boolean inputAssured = false; // Assuring input
  Scanner userInput = new Scanner(System.in); // Creating the canner for user Input
    

// Menu output
System.out.printf("Customer Account Management Submenu:\n"); //welcoming the user to the submenu 
System.out.printf("1.\tAdd Account Holder\n");
System.out.printf("2.\tRemove Account Holder\n");
System.out.printf("3.\tFund Account\n");
System.out.printf("4.\tWithdraw Funds\n"); 
System.out.printf("5.\tDisplay Account Current Stock Positions\n");
System.out.printf("6.\tReturn to Main Menu\n"); 

// Using a try catch to assure input
        while (inputAssured == false){
            try {
                System.out.print("Selection(1-6): "); // Set up line for selection input
                input = userInput.nextInt(); // Asking for int
                inputAssured = true; // Say the userInput was assured
            } catch (Exception e) {
                System.out.println("Error. Please select a number from 1-6");
            } // Close catch
        } // Close while loop

        // Switch to select the menues
        switch(input){
            case 1: // If you select 1 (Add Account Holder)
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spaceing
                Account account = new Account(); //creating a new account 
                if(accountMade){ //if the user accepts the changes 
                accounts.add(account);//add the new account to the system wide array list of accounts
                }else{ //if the user does not accept the changes 
                //do not add the new account to the system wide array list of accounts 
                }//close if else statement 
                  
                accountManagementSubMenu(); // Recall this submenue if you didnt select to leave it
                break;
            
            case 2: // If you select 2
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spaceing
                accountManagementSubMenu(); // Recall this submenue if you didnt select to leave it
                break;
            
            case 3: // If you select 3
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spaceing
                accountManagementSubMenu(); // Recall this submenue if you didnt select to leave it
                break;
            
            case 4: // If you select 4
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spaceing
                accountManagementSubMenu(); // Recall this submenue if you didnt select to leave it
                break;
            
            case 5: // If you select 5
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spaceing
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

public static void stockManagementSubMenu(){ // Method to display our stock management menue
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
        while (inputAssured == false){
            try {
                System.out.print("Selection(1-6): "); // Set up line for selection input
                input = userInput.nextInt(); // Asking for int
                inputAssured = true; // Say the userInput was assured
            } catch (Exception e) {
                System.out.println("Error. Please select a number from 1-6");
            } // Close catch
        } // Close while loop

        // Switch to select the menues
        switch(input){
            case 1: // If you select 1 (Add New Stock to Available Stocks)
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spacing
                Stock stock = new stock(); //creating stock 
                if(stockMade){//if the user accepts the changes 
                  stocks.add(stock); //add the stock to the system wide arraylist of stocks 
                }else{//if the user does not accept the changes 
                  //do not add the stock to the system wide arraylist of stocks 
                }//close else if statement 
                stockManagementSubMenu(); // Recall this submenue if you didnt select to leave it
                break;
            
            case 2: // If you select 2 (Customer Purchase of Stock)
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spacing
                //I can add to the outstanding shares of the stock that has been purchased 
                stockManagementSubMenu(); // Recall this submenue if you didnt select to leave it
                break;
            
            case 3: // If you select 3 (Customer Sale of Stock)
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spacing
                //I can remove the outstanding shares of the stock that has been sold 
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


} // Close accountManagementSubMenu method

public static void generateReportsSubMenu(){//Method to display the generate reports submenu 
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
        while (inputAssured == false){
            try {
                System.out.print("Selection(1-6): "); // Set up line for selection input
                input = userInput.nextInt(); // Asking for int
                inputAssured = true; // Say the userInput was assured
            } catch (Exception e) {
                System.out.println("Error. Please select a number from 1-3");
            } // Close catch
        } // Close while loop

        // Switch to select the menues
        switch(input){
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

  
public static boolean checkAccountID(int iD){ // Check to see if our account exists
    if (accounts.isEmpty()){
        System.out.println("No accounts exists yet"); // Incase the
        return false;
    } else {
        return accounts.get(0).checkAccountID(iD);
    }
} // Close account checkAccountID method


public static Account getAccount(int iD){ // So we can actually get what account we're working with
    for (int i = 0; i < accounts.size(); i += 1) {
        if (accounts.get(i).idNumber == iD){
            return accounts.get(i); // Return the account
        } // Close if
    } // Close for loop
    return accounts.get(0); // Return so it doesnt cause a crash as this is only going to be called if the account exists
} // Close


public static boolean checkDuplicateTicker(ArrayList<String> stocks, String tickerCheck) { //this method checks if there is a duplicate ticker, if there is a duplicate ticker the method returns true if there is NOT a duplicate ticker the method returns false

        for(int i = 0; i < stocks.size(); i++) { //for loop to iterate through arraylist of stock objects checking the attribute - ticker to see if the inputted ticker matches a ticker already in use
            if(stocks.get(i).equalsIgnoreCase(tickerCheck)) { //if the ticker of a stock object matches the inputted ticker
                return true; //the ticker is already in use
            }//close if statement
        }//close for loop

        return false; //if the ticker is NOT in use
    }//close checkDuplicateTicker


 public static int getStock(ArrayList<Stock> stocks, String ticker){//this method returns the position of the stock the user is trying to access (an assumption is being made that the stock inputted is valid and actually exists)
        //Variable Declaration and Initialization
        int found = 0; //variable used for holding the location of the stock

        for(int i = 0; i < stocks.size(); i++){//for loop to iterate through the stock objects and see where the ticker exists
            if(stocks.get(i).ticker.equalsIgnoreCase(ticker)){//if the ticker equals the stock object's ticker than you have found where the stock exists
                found = i; //return the position
            }//close if statement
        }//close for loop


        return found; //returning the stock's position
    }//close getStock method

} // Close main class

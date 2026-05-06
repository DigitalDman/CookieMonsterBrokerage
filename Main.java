import java.util.Scanner; // Import scanner for input
import java.util.ArrayList; // Import arrayList

public class Main{//Creating class
  ArrayList<Account> accounts = new ArrayList<Account>(); // Account list
  ArrayList<Stock> stocks = new ArrayList<Stock>(); // Stocks list

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
            case 1: // If you select 1
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spaceing
                
                stockManagementSubMenu(); // Recall this submenue if you didnt select to leave it
                break;
            
            case 2: // If you select 2
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spaceing
                stockManagementSubMenu(); // Recall this submenue if you didnt select to leave it
                break;
            
            case 3: // If you select 3
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spaceing
                stockManagementSubMenu(); // Recall this submenue if you didnt select to leave it
                break;
            
            case 4: // If you select 4
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spaceing
                stockManagementSubMenu(); // Recall this submenue if you didnt select to leave it
                break;
            
            case 5: // If you select 5
                // CALL SELECTION METHOD HERE //
                System.out.println(""); // For spaceing
                stockManagementSubMenu(); // Recall this submenue if you didnt select to leave it
                break;
            
            case 6: // If you select 6
                // Just break, it'll leave it
                System.out.println(""); // For spaceing
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

} // Close main class

import java.time.LocalDateTime; // Importing Scanner for name & balance inputing
import java.time.format.DateTimeFormatter; // For date & time
import java.util.ArrayList; // To format the date & time
import java.util.HashMap; // A Hashmap to be used for our book value & stocks owned things
import java.util.Scanner; // For out hashmaps

public class Account { // Open account Class
    int idNumber; // Hold our account number
    String name; // Hold our account name
    int balance; // Hold our balance

    HashMap<String, ArrayList<Integer>> bookValues = new HashMap<>(); // Save our bookValues
    HashMap<String, ArrayList<Integer>> stocksOwned = new HashMap<>(); // Save our stocks owned

    static ArrayList<Integer> totalIdNumbers = new ArrayList<>(); // Save the all the ID numbers here

    // BLANK CONSTRUCTOR // (Make additional constructors for file reading, just w/ Name & balance input)
    public Account() { // Open Constructor
        /// VARIABLES ///
        int balanceInput = 0;
        String firstName = "";
        String lastName = "";
        Scanner userInput = new Scanner(System.in);
        boolean inputAssured = false; // For assuring input

        /// Date Time Variables for the IDNumber ///
        LocalDateTime dateTime = LocalDateTime.now(); // Save the current date & time
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // To format the Date & Time for the ID number
        String formattedDate = dateTime.format(dateFormatter); // Save it as Day-Month-Year Hour:Miniute:Second
        ///////////////////

        // Ask for 1st name (Future D - Mabye make sure its not a number using Pattern like I did in skills)
        System.out.printf("Please enter the users first name: ");
        firstName = userInput.nextLine(); // Might change to next later on

        System.out.println(""); // Blank println for spacing
        // If changed to next run nextLine to clear scanner
        
        // Ask for last name (Same way)
        System.out.printf("Please enter the users last name: ");
        lastName = userInput.nextLine(); // Might change to next later on

        System.out.println(""); // Blank println for spaceing

        // Ask for balance input, make sure its only an int & that is posotive
        while (inputAssured){
            try{
                System.out.printf("Please enter the users balance: ");
                balanceInput = userInput.nextInt(); // Ask for the input, trigger catch if inputs not an int

                if (balanceInput > 0){
                    System.out.println(5/0); // Devide by 0 to trigger catch since it needs to be a positive number
                } // Close if

                inputAssured = true; // If everything goes smoothly, input assured is true
            } catch (Exception e){
                System.out.println("Invalid input. Please enter a valid number (positive)");
                userInput.nextLine(); // Clear the scanner
            } // Close catch
        } // Close while loop

        System.out.println(""); // Blank println for spaceing

        // Ask if you accept the changes
        // Can call accept changes method to see if you accept them or not, idk

        
        balance = balanceInput; // Save balance
        name = firstName + " " + lastName; // Save the users name

        // Save the ID Number
        formattedDate = formattedDate.replace("-", ""); // Remove all -
        formattedDate = formattedDate.replace(" ", ""); // Remove all spaces
        formattedDate = formattedDate.replace(":", ""); // Remove all :
        
        idNumber = Integer.parseInt(formattedDate); // Assign our idNumber to the date & time, down to the second
        totalIdNumbers.add(idNumber);
        

    } // Close Constructor


    public boolean acceptChanges(){ // Open assure input method
        String input = "";
        Scanner userInput = new Scanner(System.in);

        System.out.printf("Do you accept these changes (y/n): "); // Ask if you accept these changes
        input = userInput.next();

        // Should I make it so it automatically converts the input to lower case (So it also accepts Y/N and not just y/n)

        // If/Else chain for the inputs
        if (input.equals("y")) {
            System.out.println("Changes Made");
            return true; // Return true if inputs y
        } else if (input.equals("n")) {
            System.out.println("Aborting Changes...");
            return false; // Return false if inputs n
        } else{
            System.out.println("Invalid Input");
            return acceptChanges(); // Recursion loop if the inputs invalid
        }

    } // Close assureInput method


    public void buyStock(String ticker, int cost, int stocksBought){ // Open buyStock method
        // To save to HashMap

        // This is gonna be a weird one
        ArrayList<Integer> newBookValues = new ArrayList<Integer>( bookValues.get(ticker) ); // Clones the original list if I did this right
        ArrayList<Integer> newStocksOwned = new ArrayList<Integer>( stocksOwned.get(ticker) ); // Clones the original list if I did this right
        
        newBookValues.add(cost); // Add our cost to the bookValues
        newStocksOwned.add(stocksBought); // Add our Stocks owned to this list
        // With the way this is arranged, the Book Value & Stocks owned all belong to the same index in their respective arrays

        //*
        if ( bookValues.containsKey(ticker) ){ // If the stock already exist
            bookValues.replace(ticker, newBookValues); // Save our new book value
            stocksOwned.replace(ticker, newStocksOwned); // Save our new stocks owned
        } else {
            bookValues.put(ticker, newBookValues); // Save our new book value
            stocksOwned.put(ticker, newStocksOwned); // Save our new stocks owned

        } // If the ticker isnt already bought, just make a new one
    } // Close buyStock method

    public void deposit(int cash){ // Open Deposit method
        // Check to see if your depositing a negative number or not
        if (cash < 0){
            System.out.println("Error. Can not deposit a negative ammount of money"); // Print Error Message

        } else {
            if ( acceptChanges() ){
                balance -= cash;
            } // Close accept changes if
        } // Close else
    } // Close deposit method

     public void withdraw(int cash) { // Open withdraw method
        
        // Check to see if your depositing a negative number or not
        if (cash < 0){
            System.out.println("Error. Can not withdraw a negative ammount of money"); // Print Error Message

        } else if (balance < cash){
            System.out.println("Error. Can not withdraw more than you have");
        } else {
            if ( acceptChanges() ){
                balance -= cash;
            } // Close accept changes if
        } // Close else

    } // Close withdraw method

} // Close account Class

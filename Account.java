import java.time.LocalDateTime; // Importing Scanner for name & balance inputing
import java.time.format.DateTimeFormatter; // For date & time
import java.util.ArrayList; // To format the date & time
import java.util.HashMap; // A Hashmap to be used for our book value & shares owned things
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern; // For out hashmaps


public class Account { // Open account Class
    int idNumber; // Hold our account number
    String name; // Hold our account name
    int balance; // Hold our balance
    boolean accountMade;


    HashMap<String, ArrayList<Integer>> bookValues = new HashMap<>(); // Save our bookValues
    HashMap<String, ArrayList<Integer>> sharesOwned = new HashMap<>(); // Save our shares owned
    HashMap<String, Integer> averageCost = new HashMap<>(); // Save our average cost

    static ArrayList<Integer> totalIdNumbers = new ArrayList<>(); // Save the all the ID numbers here


    // BLANK CONSTRUCTOR // (Make additional constructors for file reading, just w/ Name & balance input)
    public Account() { // Open Constructor
        makeAccount();
    } // Close Constructor


   public void makeAccount(){
      /// VARIABLES ///
        int balanceInput = 0;
        String firstName = "";
        String lastName = "";
        Scanner userInput = new Scanner(System.in);
        boolean inputAssured = false; // For assureing input
        Pattern pattern = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);

        /// Date Time Variables for the IDNumber ///
        LocalDateTime dateTime = LocalDateTime.now(); // Save the current date & time
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-ss"); // To format the Date & Time for the ID number
        String formattedDate = dateTime.format(dateFormatter); // Save it as Day-Month-Year Hour:Miniute:Second
        ///////////////////


        // Ask for 1st name (Future D - Mabye make sure its not a number using Pattern like I did in skills)
        while (!inputAssured){
           System.out.printf("Please enter the users first name: ");
           firstName = userInput.nextLine(); // Might change to next later on
           
           for (int index = 0; index < firstName.length(); index += 1){
                String temp = "" + firstName.charAt(index);
                Matcher matcher = pattern.matcher(temp); // Make matcher
               
                inputAssured = matcher.find(); // Lets see if we got special characters or numbers
               
                if (!inputAssured){ // If we find a number or character, break
                    break;
                } // Close if
            } // Close for loop

           if (!inputAssured){
            System.out.println("Error. Can not have Numbers or Special Characters in a name");
           } // close if statement
           
        } // close while loop
        inputAssured = false;


        System.out.println(""); // Blank println for spaceing
        // If changed to next run nextLine to clear scanner
       
        // Ask for last name (Same way)
        while (!inputAssured){
           System.out.printf("Please enter the users last name: ");
           lastName = userInput.nextLine(); // Might change to next later on
           
           for (int index = 0; index < lastName.length(); index += 1){
                String temp = "" + lastName.charAt(index);
                Matcher matcher = pattern.matcher(temp); // Make matcher
               
                inputAssured = matcher.find(); // Lets see if we got special characters or numbers
               
                if (!inputAssured){ // If we find a number or character, break
                    break;
                } // Close if
            } // Close for loop
           
           if (!inputAssured){
            System.out.println("Error. Can not have Numbers or Special Characters in a name");
           } // close if statement
           
        } // close while loop
        inputAssured = false;

        System.out.println(""); // Blank println for spaceing


        // Ask for balance input, make sure its only an int & that is posotive
        while (!inputAssured){
            try{
                System.out.printf("Please enter the users balance: ");
                balanceInput = userInput.nextInt(); // Ask for the input, trigger catch if inputs not an int

                if (balanceInput < 0){
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
        if (acceptChanges()){
            balance = balanceInput; // Save balance
            name = firstName + " " + lastName; // Save the users name


            // Save the ID Number
            formattedDate = formattedDate.replace("-", ""); // Remove all -
            formattedDate = formattedDate.replace(" ", ""); // Remove all spaces
            formattedDate = formattedDate.replace(":", ""); // Remove all :
           
            idNumber = Integer.parseInt(formattedDate); // Assign our idNumber to the date & time, down to the second
            totalIdNumbers.add(idNumber);
            System.out.printf("Your Account ID is: %d \n\n", idNumber);
            accountMade = true;
        } else {
            accountMade = false;
        } // Close the change acception     
   } // Close make account method


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


    public static boolean checkAccountID(int iD){ // Check to see if our account exists
       if ( totalIdNumbers.contains(iD) ){
          return true;
       } else {
          return false;
       }
    } // Close account checkAccountID method


    public void buyShare(String ticker, int cost, int sharesBought){ // Open buyShare method
        // To save to HashMap

        //*
        if (balance > cost * sharesBought){ // Only buy the shares if you can afford them
            System.out.printf("Buying %d shares for $%d \n", sharesBought, cost * sharesBought);
            balance -= cost * sharesBought; // Check our new balance
            System.out.printf("New Balance: %d \n", balance); // Display our new balance

            if ( bookValues.containsKey(ticker) ){ // If the share already exist
                // This is gonna be a weird one
                ArrayList<Integer> newBookValues = new ArrayList<Integer>( bookValues.get(ticker) ); // Clones the original list if I did this right
                ArrayList<Integer> newSharesOwned = new ArrayList<Integer>( sharesOwned.get(ticker) ); // Clones the original list if I did this right
            
                newBookValues.add(cost); // Add our cost to the bookValues
                newSharesOwned.add(sharesBought); // Add our Shares owned to this list
                // With the way this is arranged, the Book Value & Shares owned all belong to the same index in their respective arrays

                bookValues.replace(ticker, newBookValues); // Save our new book value
                sharesOwned.replace(ticker, newSharesOwned); // Save our new shares owned
            } else {
                // This is gonna be a weird one
                ArrayList<Integer> newBookValues = new ArrayList<Integer>(); // Makes the array list blank instead of a clone
                ArrayList<Integer> newSharesOwned = new ArrayList<Integer>(); //Makes the array list blank instead of a clone
            
                newBookValues.add(cost); // Add our cost to the bookValues
                newSharesOwned.add(sharesBought); // Add our Shares owned to this list
                // With the way this is arranged, the Book Value & Shares owned all belong to the same index in their respective arrays

                bookValues.put(ticker, newBookValues); // Save our new book value
                sharesOwned.put(ticker, newSharesOwned); // Save our new shares owned
            } // If the ticker isnt already bought, just make a new one
                
        } else {
            System.out.printf("With $%d you can not afford to buy %d shares for $%d \n", balance, sharesBought, cost * sharesBought);
        }
        
    } // Close buyShare method


    public void deposit(int cash){ // Open Deposit method
        // Check to see if your depositing a negative number or not
        if (cash < 0){
            System.out.println("Error. Can not deposit a negative ammount of money"); // Print Error Message
        } else {
            if ( acceptChanges() ){
                balance += cash;
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


    public double getAverage(){ // Average method for overall
        int totalSharesBought = 0;
        double average = 0;
        int index = 0;

        // Loop through & calculate the average cost
        for (String key : bookValues.keySet() ){
            index = 0; // Reset index
            for (double bookValue : bookValues.get(key)){
                int shares = sharesOwned.get(key).get(index); // Get our shares

                totalSharesBought += shares; // Keep track of the total shares we bought
                average += bookValue * shares; // Start keeping track of our average
                index += 1;

                System.out.printf("Key: %s      Book_Value: %d        Shares: %d         Index: %d", key, bookValue, shares, index);
            } // Close book value loop
        } // Close for-each
       
        average /= totalSharesBought; // Divide our average by the total shares
        return average;
       
    } // Close getAverage method


    public double getAverage(String key){
        int totalSharesBought = 0;
        double average = 0;
        int index = 0;

        // Loop through & calculate the average cost
        for (double bookValue : bookValues.get(key)){
            int shares = sharesOwned.get(key).get(index); // Get our shares

            totalSharesBought += shares; // Keep track of the total shares we bought
            average += bookValue * shares; // Start keeping track of our average
            index += 1;

            //System.out.printf("Key: %s      Book_Value: %d        Shares: %d         Index: %d", key, bookValue, shares, index);
        } // Close book value loop
       
        average /= totalSharesBought; // Divide our average by the total shares
        return average;
       
    } // Close getAverage method


    public void display(){ // Open display method
        System.out.println("\n \n"); // Create 3 new lines

        System.out.printf("Account ID: %d \n", idNumber); // Display the accounts ID
        // Print out our headder
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s  \n", "Ticker", "Number of Shares", "Average Cost", "Market Price", "Book Value", "Market Value");
        
        for (String ticker : bookValues.keySet()){ // Loop through all our keys
            System.out.printf("%-10s %-20s %-20.2f %-20.2f %-20s %-20.2f  \n", ticker, sharesOwned.get(ticker), getAverage(ticker), 15.0, bookValues.get(ticker), 15.0  );
        } // Close for-each

    } // Close dispaly method

} // Close account Class

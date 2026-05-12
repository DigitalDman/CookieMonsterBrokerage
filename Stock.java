import java.util.ArrayList; //importing arraylists
import java.util.regex.Pattern; //importing Pattern class
import java.util.regex.Matcher; //importing Matcher Class
import java.util.Scanner; //importing the Scanner Class


class Stock { //creating stock class

	//Instance variables, the attributes of the stock object (class variables)
	String ticker; //3-letters that represent the stock unique to each stock
	String name; //the name of the stock
	double marketPrice; //current trading price
	ArrayList<Integer> owners = new ArrayList<>(); //arraylist that holds the account ID's of the owners of the stock
	int outstandingShares = 0;//the total number of shares owned in the stock
	static ArrayList<String> tickersSystemWide = new ArrayList<>(); //arraylist that holds the tickers of all stock objects made
    boolean stockMade = false;//for applying changes


	public Stock() { //constructor
		makeStock(); //calling makeStock() method
	}//close constructor

	public void makeStock() { //this method is used to assign the attributes of a stock while error handling

		//Variable Declaration and Initialization
		String ticker = "";//Variable that will hold ticker name
		String name = ""; //Variable that will hold the name of the stock
		double marketPrice = 0.0; //Variable that will hold the market price of the stock
		Scanner userInput = new Scanner(System.in);//creating scanner object
		boolean inputAssured = false;//for assuring the input of the user
		boolean dupTicker = false;//for checking duplicate tickers
		Pattern pattern = Pattern.compile("[a-z]",Pattern.CASE_INSENSITIVE); //what the pattern will look for

		//User Input and Program Processing
		//This while loop is focused on error handling for the stock's ticker
		while(!inputAssured) { //open while

			System.out.printf("Please enter a stock ticker: ");//prompting user to enter a stock ticker
			ticker = userInput.next(); //assigning the variable ticker to the user's input

			//checking for special characters or numbers
			for(int i = 0; i < ticker.length(); i++) { //for loop to iterate through ticker
				String temp = "" + ticker.charAt(i); //creating temp variable that holds the characters of the ticker
				Matcher matcher = pattern.matcher(temp); //makes the matcher object and is going to use temp to search for the pattern
				inputAssured = matcher.find();  //setting inputAssured to false or true depending on what the matcher finds

				if(!inputAssured) { //If a number or special character is found
					break; //breaking out of loop
				}//close if statement

			}//close for loop

			if(!inputAssured) { //open if the input is not valid
				System.out.println("Error. Can not have numbers or special characters in a stock ticker"); //if the user tries to put a number or special character in the stock ticker than an error will occur
				userInput.nextLine(); //clearing scanner
			}//close if statement

			//checking length of ticker
			if(inputAssured) { //open if the input is valid to check if the length is valid

				if(ticker.length() > 3) { //if the ticker length is greater than three the ticker is too long
					System.out.println("Error. The entered ticker is too long. Must be three letters."); //if the user enters a ticker longer than three letters
					userInput.nextLine();//clearing scanner
					inputAssured = false; //the input is not assured
				}//close nested if

			}

			//checking for duplicate ticker
			if(inputAssured) { //open if the input is valid to check if the ticker will exist
				dupTicker = checkDuplicateTicker(tickersSystemWide, ticker); //setting dupTicker to the method that check duplicates (true if duplicate found and false if duplicate is NOT found)
				if(dupTicker) { //if dupTicker is true there is a duplicate
					System.out.println("Error. The entered ticker is already in use. ");//telling user there is a duplicate
					userInput.nextLine();//clearing scanner
					inputAssured = false; //input is not assured
				} else { //if dupTicker is false
					tickersSystemWide.add(ticker); //adding the ticker name to an arraylist that holds system wide
					this.ticker = ticker.toUpperCase(); //setting ticker of stock object
				}//close if statement

			}//close if statement

		}//close while

		inputAssured = false; //setting input assured to false
		userInput.nextLine(); //clearing scanner

		//The following code block is focused on setting the stock's name
		System.out.printf("Please enter the name of the stock: ");//prompting user to input the name of the ticker
		name = userInput.nextLine();//setting name to the user's input
		this.name = name;//setting name of stock object

		while(!inputAssured) { //open while

			try { //opening try catch
				System.out.printf("Please enter the starting market price: ");//prompting the user to input the starting market price
				marketPrice = userInput.nextDouble();//setting market price to the user's input
				this.marketPrice = marketPrice; //setting the stock's market price
				inputAssured = true;//input is assured

                if(marketPrice < 0){//has entered a negative number 
                    System.out.print(marketPrice/0);//triggering catch 
                }//close if statement 

			} catch(Exception e) {
				System.out.println("Error. Enter a number and positive value."); //telling the user to input a number for the market price
				inputAssured = false;//input is not assured
				userInput.nextLine(); //clearing scanner
			}//close try catch
		}//close while

		if(acceptChanges()) { //if the changes are accepted
			stockMade = true; //you can add the stock object to arraylist of stock objectss
		} else { //if the changes are not accepted
			stockMade = false; //do NOT add the stock object to arraylist of stock objects
		}//close if else statement

	}//close makeStock method

	public String displayStockInfo(Stock obj) { //This method will display ticker, the name of the stock, the market price, and outstanding shares in tabular format
		return String.format("%-10s %-20s %-20.2f %-20d \n" , obj.ticker, obj.name, obj.marketPrice, obj.outstandingShares) ; //returning the info of the stock as a sting
	}//close displayStockInfo

	public Stock addOwner(Stock obj, int newOwner) { //method to add a new owner to the stock object

		obj.owners.add(newOwner); //adding the new owner to the stock objects arraylist of owners
		return obj; //returning the object with a new owner

	}//close addOwner method

	public Stock removeOwner(Stock obj, int removeOwner) {//method to remove an owner from a stock object

		for(int i = 0; i < obj.owners.size(); i++) { //for loop iterating through owners of the stock
			if(obj.owners.get(i) == removeOwner) { //if the owner of the stock's account ID matches the owner that needs to be removed remove that owner
				obj.owners.remove(i); //removing the owner
			}//close if statment
		}//close for loop

		return obj; //will return the stock object with the desired owner removed

	}//close removeOwner method

	public boolean checkDuplicateTicker(ArrayList<String> stocks, String tickerCheck) { //this method checks if there is a duplicate ticker, if there is a duplicate ticker the method returns true if there is NOT a duplicate ticker the method returns false

		for(int i = 0; i < stocks.size(); i++) { //for loop to iterate through arraylist of stock objects checking the attribute - ticker to see if the inputted ticker matches a ticker already in use
			if(stocks.get(i).equalsIgnoreCase(tickerCheck)) { //if the ticker of a stock object matches the inputted ticker
				return true; //the ticker is already in use
			}//close if statement
		}//close for loop

		return false; //if the ticker is NOT in use
	}//close checkDuplicateTicker

	public boolean checkStockExists(ArrayList<Stock> stocks, String ticker) { //this method checks if a stock exists if the stock exists it will return true and if the stock does NOT exist it will return false

		for(int i = 0; i < stocks.size(); i++) { //for loop to iterate through arraylist of stock objects to check if a stock exists
			if(stocks.get(i).ticker.equalsIgnoreCase(ticker)) { //if the ticker of the stock object matches the inputted ticker the stock exists
				return true; //the stock exists
			}//close if statement
		}//close for loop
		return false; //the stock does not exist
	}//close checkStockExists

    public boolean checkOwnerExists(Stock obj, int account){//this method checks if an owner already owns shares in the stock object 

        for(int i = 0; i < obj.owners.size(); i++){//for loop to iterate through owners of the stock object 
            if(owners.get(i) == account){//if the owners matches the account ID then the owner 
                return true; //the owner exists 
            }//close if statement
        }//close for loop 
        return false; //the owner does not exist 
    }//close checkOwnerExists method 


	public Stock addShares(Stock obj, int newShares) { //this method adds to the number of shares owned within a stock

		obj.outstandingShares += newShares;  //the amount of shares is accumulative and therefore increases
		return obj; //returning the stock object

	}//close addShares

	public Stock removeShares(Stock obj, int removeShares) { //this method removes the number of shares owned within a stock

		obj.outstandingShares -= removeShares; //the amount of shares decreases by the amount of shares removed
		return obj;//returning the stock object

	}//close removeShares

	public Stock stockSplitTwoForOne(Stock obj) { //this method returns a stock after a stock split 2-1, the market price is divided by two, and the outstanding shares is doubled

		obj.marketPrice = obj.marketPrice/2; //the market price of the stock gets divided by two
		obj.outstandingShares = obj.outstandingShares*2; //the outstanding shares of the stock is doubled
		return obj;//return the stock object

	}//close stockSplitTwoForOne

	public Stock reverseStockSplitOneForTwo(Stock obj) { //this method returns a stock after a reverse stock split 1-2, the market price is doubled, and the oustanding shares is divided by two

		obj.marketPrice = obj.marketPrice*2; //the market price of the stock gets doubled
		obj.outstandingShares = obj.outstandingShares/2; //the outstanding shares of the stock gets divided by two
		return obj; //return the stock object

	}//close reverseStockSplitOneForTwo

    public void stockChangesWhenPurchasingStock(int shares,int account, ArrayList<Stock> stocks){//this method is to change the stock when the user purchases a stock 

        //Variable Declaration and Initialization 
        String ticker = "";//this variable is for holding the ticker the user inputs 
        Scanner userInput = new Scanner(System.in);//creating scanner object 
        boolean tickerExists = false; //variable to check if the ticker exists and therefore the stock 
        int locationOfStock = 0; //this variable holds the location of the stock the user is try to access 
        boolean addOwner = false; //this variable helps to differentiate if an owner should be added or not 
        

        //User input and Program processing 
        System.out.printf("Enter the ticker of the stock you wish to purchase: ");//prompting the user to input the ticker for the stock they wish to purchase 
        ticker = userInput.next(); //assigning ticker to user's input 

        tickerExists = checkDuplicateTicker(tickersSystemWide, ticker);//assigning ticker to true or false

        if(tickerExists){//if the ticker exists 
        
        locationOfStock = getStock(stocks, ticker); //finding the position of the stock object and assigning that to the locationOfStock variable 

        addShares(stocks.get(locationOfStock), shares);//this method adds to the number of shares owned within a stock

        addOwner = checkOwnerExists(stocks.get(locationOfStock), account);//this method checks if the account already owns shares in stock 
      
        if(!addOwner){//if the account is NOT already an owner 
            addOwner(stocks.get(locationOfStock),account); //add the account to the owners of the share 
        }//close if statement 

        }else{//if the ticker does not exist 
            System.out.print("The stock does not exist.");//telling the user the stock does not exist 
            return; //returning method 
        }//close if else statement 

    }//close stockChangesForPurchasingStock method 

    public int getStock(ArrayList<Stock> stocks, String ticker){//this method returns the position of the stock the user is trying to access (an assumption is being made that the stock inputted is valid and actually exists)
        //Variable Declaration and Initialization 
        int found = 0; //variable used for holding the location of the stock 

        for(int i = 0; i < stocks.size(); i++){//for loop to iterate through the stock objects and see where the ticker exists 
            if(stocks.get(i).ticker.equalsIgnoreCase(ticker)){//if the ticker equals the stock object's ticker than you have found where the stock exists 
                found = i; //return the position 
            }//close if statement 
        }//close for loop 

        return found; //returning the stock's position 
    }//close getStock method 

    
	public boolean acceptChanges() { // Open assure input method
		String input = "";
		Scanner userInput = new Scanner(System.in);

		System.out.printf("Do you accept these changes (y/n): "); // Ask if you accept these changes
		input = userInput.next();
    
		// If/Else chain for the inputs
		if (input.equalsIgnoreCase("y")) {
			System.out.println("Changes Made");
			return true; // Return true if inputs y
		} else if (input.equalsIgnoreCase("n")) {
			System.out.println("Aborting Changes...");
			return false; // Return false if inputs n
		} else {
			System.out.println("Invalid Input");
			return acceptChanges(); // Recursion loop if the inputs invalid
		}

	} // Close assureInput method



}//close class

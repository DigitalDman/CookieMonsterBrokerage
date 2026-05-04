import java.util.ArrayList; //importing arraylists 
class Stock{//creating stock class 

    //Instance variables, the attributes of the stock object (class variables)
    String ticker; //3-letters that represent the stock unique to each stock  
    String name; //the name of the stock 
    double marketPrice; //current trading price 
    ArrayList<Integer> owners = new ArrayList<>(); //arraylist that holds the account ID's of the owners of the stock
    int outstandingShares;//the total number of shares owned in the stock

    Stock(String t, String n, double m, ArrayList<Integer> o, int oShare){ //constructor 

        this.ticker = t; //setting the stock's ticker 
        this.name = n; //setting the name of the stock 
        this.marketPrice = m; //setting the market price of the stock 
        for(int i = 0; i < o.size();i++){
        this.owners.add(o.get(i)); //setting the number of owners of the stock 
        }
       this.outstandingShares = oShare; //setting the number of shares owned in the stock 
    }//close constructor

    public String displayStockInfo(Stock obj){//This method will display ticker, the name of the stock, the market price, and outstanding shares in tabular format 
        return String.format("%-20s %-40s %-20.2f %-20d", obj.ticker, obj.name, obj.marketPrice, obj.outstandingShares) ; //returning the info of the stock as a sting 
    }//close displayStockInfo

    public Stock addOwner(Stock obj, int newOwner){ //method to add a new owner to the stock object 

        obj.owners.add(newOwner); //adding the new owner to the stock objects arraylist of owners 
        return obj; //returning the object with a new owner 

    }//close addOwner method 

    public Stock removeOwner(Stock obj, int removeOwner) {//method to remove an owner from a stock object

        for(int i = 0; i < obj.owners.size(); i++){//for loop iterating through owners of the stock 
            if(obj.owners.get(i) == removeOwner){//if the owner of the stock's account ID matches the owner that needs to be removed remove that owner 
                obj.owners.remove(i); //removing the owner 
            }//close if statment 
        }//close for loop 

        return obj; //will return the stock object with the desired owner removed 

    }//close removeOwner method 

    public boolean checkDuplicateTicker(ArrayList<Stock> stocks, String tickerCheck){//this method checks if there is a duplicate ticker, if there is a duplicate ticker the method returns true if there is NOT a duplicate ticker the method returns false 

        for(int i = 0; i < stocks.size(); i++){//for loop to iterate through arraylist of stock objects checking the attribute - ticker to see if the inputted ticker matches a ticker already in use 
            if(stocks.get(i).ticker.equalsIgnoreCase(tickerCheck)){//if the ticker of a stock object matches the inputted ticker 
                return true; //the ticker is already in use 
            }//close if statement 
        }//close for loop 

        return false; //if the ticker is NOT in use 
    }//close checkDuplicateTicker 

    public boolean checkStockExists(ArrayList<Stock> stocks, String ticker){//this method checks if a stock exists 

for(int i = 0; i < stocks.size(); i++){//for loop to iterate through arraylist of stock objects to check if a stock exists
if(stocks.get(i).ticker.equalsIgnoreCase(ticker)){//if the ticker of the stock object matches the inputted ticker the stock exists 
    return true; //the stock exists 
}//close if statement 
}//close for loop 
return false; //the stock does not exist 
    }//close checkStockExists 


}//close class 
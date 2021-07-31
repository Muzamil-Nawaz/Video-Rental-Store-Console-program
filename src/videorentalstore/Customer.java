/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videorentalstore;

import java.util.*;
public class Customer {
    static String result;
    static double totalAmount = 0;
    static int frequentRentalPoints = 0;
    private static String _name;
    private Vector _rentals = new Vector();
    public Customer(String name){
        _name = name;
    }
    public void addRental(Rental arg){
        _rentals.addElement(arg);
    }
    public static String getName(){
        return _name;
    }
    public String statement(){   
        Enumeration rentals = _rentals.elements();
        printRentals(rentals);
    //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You Earned " + String.valueOf(frequentRentalPoints)+ " frequentRenterPoints" + "\n";
        return result;
    }
    public static void printRentals(Enumeration rentals){
        result = "Rental Record for " + getName() + "\n";
        while(rentals.hasMoreElements()){
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            switch(each.getMovie().getPriceCode()){
                case Movie.REGULAR:
                    thisAmount+=50;
                    if(each.getDaysRental()>2)
                    thisAmount+=(each.getDaysRental()-2)*10;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount+=each.getDaysRental()*100;
                    break;
                case Movie.CHILDRENS:
                    thisAmount+=30;
                    if(each.getDaysRental()>3)
                    thisAmount += (each.getDaysRental()-3)*5;
                    break;
            }
    //add frequentRenterPoints
            
    //add a bonus for a two day new release rental;
            incrementFrequent(each);
    //show the figure for this rental
            result+= "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount+=thisAmount;
        }
    }
    public static void incrementFrequent(Rental each){
        frequentRentalPoints++;
        if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRental()>1)
                frequentRentalPoints++;
    }
    
}

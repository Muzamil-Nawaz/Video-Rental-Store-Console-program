/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videorentalstore;

import java.util.*;

public class Test {
    public static void main(String[] args){
        Movie m1 = new Movie("GullyBoy", 0);
	Movie m2 = new Movie("3 idiots", 0);
	Movie m3 = new Movie("Baahu bali", 1);
	Movie m4 = new Movie("Avalanche", 2);
	
        Rental r1 = new Rental(m1, 5);
	Rental r2 = new Rental(m2, 3);
	Rental r3 = new Rental(m3, 7);
	Rental r4 = new Rental(m4, 1);
	
        Customer c1 = new Customer("Asif");
	Customer c2 = new Customer("Rajesh");
	Customer c3 = new Customer("Ibrahim");
	Customer c4 = new Customer("Salman");
        c1.addRental(r1);
	c2.addRental(r2);
	c3.addRental(r3);
	c4.addRental(r4);
        String stmt = c1.statement();
        printStatement(stmt);
	stmt = c2.statement();
        printStatement(stmt);
	stmt = c3.statement();
        printStatement(stmt);
	stmt = c4.statement();
        printStatement(stmt);

	}
         
        public static void printStatement(String s){
            System.out.println("\n" +s);
        }
}

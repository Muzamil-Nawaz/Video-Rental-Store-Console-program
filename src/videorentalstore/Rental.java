/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videorentalstore;
public class Rental {
    private Movie _movie;
    private int _daysRental;
    public Rental(Movie movie, int daysRental){
        _movie = movie;
        _daysRental = daysRental;
    }
    public int getDaysRental(){
    return _daysRental;
    }
    public Movie getMovie(){
    return _movie;
    }
}

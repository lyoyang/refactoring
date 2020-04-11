package com.lyoyang.chapter1.after;

public class Rental {

    private Movie movie;
    private int rentDays;

    public Rental(Movie movie, int rentDays) {
        this.movie = movie;
        this.rentDays = rentDays;
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getRentDays() {
        return rentDays;
    }

    public void setRentDays(int rentDays) {
        this.rentDays = rentDays;
    }



}

package com.lyoyang.chapter1.after;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentalList = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental record for " + getName() + "\n";
        if (CollectionUtils.isNotEmpty(rentalList)) {
            for (Rental rental : rentalList ) {
                result += "\t" + rental.getMovie().getTitle() + "\t"
                        + String.valueOf(rental.getMovie().getCharge(rental.getRentDays())) + "\n";
            }
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalPoints()) +
                " frequent renter points";
        return result;
    }



    private double getTotalCharge() {
        double result = 0;
        if (CollectionUtils.isNotEmpty(rentalList)) {
            for (Rental rental : rentalList) {
                result += rental.getMovie().getCharge(rental.getRentDays());
            }
        }
        return result;
    }

    private double getTotalPoints() {
        double totalPoints = 0;
        if (CollectionUtils.isNotEmpty(rentalList)) {
            for (Rental rental : rentalList) {
                totalPoints += rental.getMovie().getPoints(rental.getRentDays());
            }
        }
        return totalPoints;
    }


}

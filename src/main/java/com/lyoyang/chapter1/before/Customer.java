package com.lyoyang.chapter1.before;

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
        double totalAmount = 0;
        int points = 0;

        String result = "Rental record for " + getName() + "\n";
        if (CollectionUtils.isNotEmpty(rentalList)) {
            for (Rental rental : rentalList ) {
                double thisAmount = 0;
                switch (rental.getMovie().getPriceCode()) {
                    case Movie.REGULAR:
                        thisAmount += 2;
                        if (rental.getRentDays() > 2) {
                            thisAmount += (rental.getRentDays() - 2) * 1.5;
                        }
                        break;

                    case Movie.CHILDRENS:
                            thisAmount += 1.5;
                            if (rental.getRentDays() > 3) {
                                thisAmount += (rental.getRentDays() - 3) * 1.5;
                            }
                            break;
                    case Movie.NEW_RELEASE:
                        thisAmount += rental.getRentDays() * 3;
                        break;

                }
                points++;
                if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
                        && rental.getRentDays() > 1)
                    points++;
                result += "\t" + rental.getMovie().getTitle() + "\t"
                        + String.valueOf(thisAmount) + "\n";
                totalAmount += totalAmount;
            }

        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(points) +
                " frequent renter points";
        return result;
    }


}

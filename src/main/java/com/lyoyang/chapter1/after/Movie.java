package com.lyoyang.chapter1.after;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private Price price;

    private String title;


    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }


    public double getCharge(int rentDay) {
       return price.getCharge(rentDay);
    }


    public int getPoints(int rentDay) {
       return price.getPoints(rentDay);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Illegal price code");

        }
    }
}

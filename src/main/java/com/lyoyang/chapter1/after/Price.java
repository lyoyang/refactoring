package com.lyoyang.chapter1.after;

public abstract class Price {
    abstract int getPriceCode();
    abstract double getCharge(int rentDay);

    public int getPoints(int rentDay) {
        return 1;
    }
}


class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    double getCharge(int rentDay) {
        double result = 1.5;
        if (rentDay > 3) {
            result += (rentDay - 3) * 1.5;
        }
        return result;
    }

    @Override
    public int getPoints(int rentDay) {
        return 1;
    }
}

class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int rentDay) {
        return rentDay * 3;
    }

    @Override
    public int getPoints(int rentDay) {
        return rentDay > 1 ? 2 : 1;
    }
}

class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int rentDay) {
        double result = 2;
        if (rentDay > 2) {
            result += (rentDay - 2) * 1.5;
        }
        return result;
    }

    @Override
    public int getPoints(int rentDay) {
        return 1;
    }
}
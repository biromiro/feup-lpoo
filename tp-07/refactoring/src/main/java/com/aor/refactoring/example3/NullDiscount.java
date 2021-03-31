package com.aor.refactoring.example3;

public class NullDiscount implements Discount{

    NullDiscount(){}

    @Override
    public double applyDiscount(double price) {
        return price;
    }
}

package com.aor.refactoring.example1;

public class OrderLine {

    private final Product product;
    private final int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getTotal() { return product.getPrice() * quantity; }

    @Override
    public String toString() {
        return  product.getName() +
                "(x" + quantity + ")" + ": " +
                quantity*product.getPrice() + "\n";
    }
}

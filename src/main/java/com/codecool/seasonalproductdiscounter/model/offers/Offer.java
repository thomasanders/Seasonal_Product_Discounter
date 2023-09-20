package com.codecool.seasonalproductdiscounter.model.offers;

import com.codecool.seasonalproductdiscounter.model.discounts.Discount;

public record Offer(java.util.List<com.codecool.seasonalproductdiscounter.model.discounts.Discount> product, double price) {

    public String toString(String discounts, String date) {
        return "Offer{" +
                "product=" + product +
                ", date=" + date +
                ", discounts=" + discounts +
                ", price=" + price +
                '}';
    }

    public CharSequence discounts() {
        return discounts();
    }
}


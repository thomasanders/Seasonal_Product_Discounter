package com.codecool.seasonalproductdiscounter.service.discounts;

import com.codecool.seasonalproductdiscounter.model.discounts.Discount;
import com.codecool.seasonalproductdiscounter.model.offers.Offer;
import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public record MontlyDiscount(double discountPercentage, Month targetMonth) implements Discount {
    public Offer getOffer(Product product, LocalDate date) {
        if (date.getMonth() == targetMonth) {
            long daysUntilEndOfMonth = date.until(date.withDayOfMonth(date.lengthOfMonth()), ChronoUnit.DAYS);
            double discountFactor = (double) daysUntilEndOfMonth / date.lengthOfMonth();
            double discountedPrice = product.price() - (product.price() * discountPercentage * discountFactor);
            List<Discount> discounts = new ArrayList<>();
            discounts.add(this);
            return new Offer(discounts, discountedPrice);
        }
        return new Offer(new ArrayList<>(), product.price());
    }
    @Override
    public String toString() {
        return "MonthlyDiscount{" +
                "discountPercentage=" + discountPercentage +
                ", targetMonth=" + targetMonth +
                '}';
    }

    @Override
    public boolean accepts(Product product, LocalDate date) {
        return false;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public int rate() {
        return 0;
    }
}

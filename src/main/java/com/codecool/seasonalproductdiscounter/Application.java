package com.codecool.seasonalproductdiscounter;

import com.codecool.seasonalproductdiscounter.service.discounts.DiscountProvider;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountService;
import com.codecool.seasonalproductdiscounter.service.logger.ConsoleLogger;
import com.codecool.seasonalproductdiscounter.service.logger.Logger;
import com.codecool.seasonalproductdiscounter.service.products.ProductProviderImpl;
import com.codecool.seasonalproductdiscounter.ui.SeasonalProductDiscounterUi;

public class Application {
    public static void main(String[] args){


        Logger logger = new ConsoleLogger();

        logger.info("Starting Seasonal Application...");

        var productProvider = new ProductProviderImpl();
        DiscountProvider discountProvider = null;
        DiscountService discounterService = null;
        var ui = new SeasonalProductDiscounterUi(productProvider, discountProvider, discounterService);

        ui.run();
    }
}

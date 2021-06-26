package com.swufe.javaee.beerV1.model;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    public List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();
        if (color.equals("amber")) {
            brands.add("Black");
            brands.add("Pink");
        } else {
            brands.add("White");
            brands.add("Green");
        }
        return brands;
    }

    public List<Beer> getBeers(String color) {
        List<Beer> beers = new ArrayList<>();
        beers.add(new Beer("A", 100.0,2001));
        beers.add(new Beer("B", 200.0,1999));
        return beers;
    }
}

package com.swufe.javaee.beerV1.model;

public class Beer {
    private String band;
    private double price;
    private int year_of_birth;

    public Beer(String band, double price,int year_of_birth) {
        this.band = band;
        this.price = price;
        this.year_of_birth=year_of_birth;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) { this.price = price; }

    public int getYear_of_birth() {return year_of_birth; }

    public void setYear_of_birth(int year_of_birth) { this.year_of_birth = year_of_birth; }

    @Override
    public String toString() {
        return "Beer{" +
                "band='" + band + '\'' +
                ", price=" + price +
                '}';
    }
}

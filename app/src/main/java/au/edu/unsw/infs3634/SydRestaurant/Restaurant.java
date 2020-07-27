package au.edu.unsw.infs3634.SydRestaurant;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private double rating;
    private String location;
    private String cost;
    private String type;
    private int image;

    public Restaurant() {
    }

    public Restaurant(String name, double rating, String location, String cost, String type, int image) {
        this.name = name;
        this.rating = rating;
        this.location = location;
        this.cost = cost;
        this.type = type;
        this.image = image;
    }
    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getImage(){return image;}

    public void setImage(int image) {this.image = image;}

    public static Restaurant getRes(String name) {
        for(Restaurant restaurant : getRes()) {
            if(restaurant.getName().equals(name)) {
                return restaurant;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
    //add elements into restaurants array
    public static ArrayList<Restaurant> getRes() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Mia & CO.", 3.6, "CBD" , "$20 for two","Café food",R.drawable.mia));
        restaurants.add(new Restaurant("Don Peppino’s", 3.7, "Paddington" , "$50 for two","Italian",R.drawable.don));
        restaurants.add(new Restaurant("GoodTime Burgers", 4.1, "Bondi Junction" , "$60 for two","Bar-burger",R.drawable.goodtime));
        restaurants.add(new Restaurant("Annata", 4.0, "Crows Nest" , "$120 for two","Bar",R.drawable.annata));
        restaurants.add(new Restaurant("The Rook", 4.0, "CBD" , "$80 for two","Burger & Seafood",R.drawable.the));
        restaurants.add(new Restaurant("Mad Pizza e Bar", 4.5, "Surry Hills" , "$80 for two","Italian",R.drawable.mad));
        restaurants.add(new Restaurant("Gami Chicken & Beer", 3.8, "Castle Hill" , "$60 for two","Korean",R.drawable.gami));
        restaurants.add(new Restaurant("Café Kensington", 3.8, "Kogarah" , "$40 for two","Café food",R.drawable.cafe));
        restaurants.add(new Restaurant("Bambino Torino", 3.7, "Newtown" , "$70 for two","European",R.drawable.bambino));
        restaurants.add(new Restaurant("Gyradiko Bexley", 4.3, "Bexley" , "$35 for two","Greek",R.drawable.gyradiko));
        return restaurants;
    }
}

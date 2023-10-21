package com.driver;

public class Director {
    private String name;
    private int numOfMovies;
    private double imdbRating;

    public Director() {
    }

    public Director(String name, int numOfMovies, double imdbRating) {
        this.name = name;
        this.numOfMovies = numOfMovies;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfMovies() {
        return numOfMovies;
    }

    public void setNumOfMovies(int numOfMovies) {
        this.numOfMovies = numOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}

package ru.grischenko.servlets;

public class Product {

    private static int idInc = 0;

    private int id;
    private String title;
    private float cost;

    {
        idInc++;
    }
    public Product(String title, float cost) {
        this.id = idInc;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }


}

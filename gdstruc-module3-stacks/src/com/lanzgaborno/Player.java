package com.lanzgaborno;

public class Player {
    private static int idCounter = 1;
    private int id;
    private String name;

    public Player(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player #" + id + " (" + name + ")";
    }
}
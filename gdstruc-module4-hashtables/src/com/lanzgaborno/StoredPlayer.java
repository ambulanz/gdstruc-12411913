package com.lanzgaborno;

public class StoredPlayer {
    private String key;
    private Player value;

    public StoredPlayer(String key, Player value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Player getValue() {
        return value;
    }
}
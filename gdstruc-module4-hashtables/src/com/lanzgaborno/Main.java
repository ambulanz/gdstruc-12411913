package com.lanzgaborno;

public class Main {
    public static void main(String[] args) {

        Player ploo = new Player(134, "Plooful", 135);
        Player wardell = new Player(536, "TSM Wardell", 640);
        Player deadlyJimmy = new Player(32, "DeadlyJimmy",34);
        Player subroza = new Player(4931, "subroza", 684);
        Player annieDro = new Player(6919, "C9 Annie", 593);

        System.out.println("=== ADDING PLAYERS ===\n");
        SimpleHashtable hashtable = new SimpleHashtable();

        hashtable.put(ploo.getUsername(), ploo);
        hashtable.put(wardell.getUsername(), wardell);
        hashtable.put(deadlyJimmy.getUsername(), deadlyJimmy);
        hashtable.put(subroza.getUsername(), subroza);
        hashtable.put(annieDro.getUsername(), annieDro);

        System.out.println("\n=TEST ON REMOVE FUNCTION=\n");

        Player removed = hashtable.remove("Plooful");
        System.out.println("Removed player: " + removed);

        hashtable.printHashtable();

        System.out.println("\n=TEST ON INVALID USERNAME=");
        hashtable.remove("FakePlayer");
    }
}
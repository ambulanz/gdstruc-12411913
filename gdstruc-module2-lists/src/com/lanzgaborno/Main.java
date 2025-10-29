package com.lanzgaborno;

import java.util.List;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        /*
        List<Player> playerList = new ArrayList<Player>();

        //NOTES TO SELF! To avoid confusion, you should not manually type "id", "name:", etc. since adding the string or no alone already adds that.)
        playerList.add(new Player(1,"Guillotine", 100));
        playerList.add(new Player( 2, "Trebuchet",  64));
        playerList.add(new Player( 3, "Arbalest", 33));

        // -For getting a certain element in the list-
        // System.out.println(playerList.get(1));

        //How to add or remove the player (so call the index to add/delete, then for add you make a new player like normal)
        //playerList.add(2, new Player(553, "Ballista", 36));
        //playerList.remove (2);

        System.out.println(playerList.indexOf(new Player(1,"Guillotine", 100)));

        // -For loop to print out the list of players-
        for (Player p : playerList) {
           System.out.println(p);
        }
        */
        Player guillotine = (new Player(1,"Guillotine", 100));
        Player trebuchet = (new Player( 2, "Trebuchet",  64));
        Player arbalest = (new Player( 3, "Arbalest", 33));

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        //guillotine would be the last element since it would be added first with how Linked Lists work
        //thus arbalest would be the first in line since its the most recently added
        playerLinkedList.addToFront(guillotine);
        playerLinkedList.addToFront(trebuchet);
        playerLinkedList.addToFront(arbalest);

        playerLinkedList.removeFromFront();
        playerLinkedList.printList();
        System.out.println(playerLinkedList.contain(trebuchet));
        System.out.println(playerLinkedList.contain(arbalest));
        System.out.println(playerLinkedList.indexOf(arbalest));
        System.out.println(playerLinkedList.indexOf(guillotine));
    }

}
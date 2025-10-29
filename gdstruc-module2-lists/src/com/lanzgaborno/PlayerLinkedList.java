package com.lanzgaborno;

public class PlayerLinkedList {
    private PlayerNode head;
    int linkedListSize = 0;

    public void addToFront (Player player){
        PlayerNode playerNode = new PlayerNode(player); //Creates a new PlayerNode, accepting the player object we filled in addToFront
        playerNode.setNextPlayer(head); // set the player nodes next to the current head before switching to the new head
        head = playerNode;
        linkedListSize++;
    }

    public void printList(){
        PlayerNode current = head; //current playerNode pointing initially to the head of the linked list
        System.out.print("HEAD -> ");
        while (current != null){ //while it is not null, it keeps going until it the current node is Null (signifying the end of the linked list)
            System.out.print(current.getPlayer());
            System.out.print(" -> ");
            current = current.getNextPlayer();

        }
        System.out.println("null");
        System.out.println(linkedListSize);
    }

    //Function that removes first element (so what sir referred to on the video where you give the head to the prior player and the element exists in somewhere just not in the list)
    public Player removeFromFront(){
        if (head == null){
            return null;
        }

        Player deletedPlayer = head.getPlayer();
        head = head.getNextPlayer();
        linkedListSize--;
        return deletedPlayer;
    }

    //Size variable that determines how many elements so could be in printList that just adds size++ everytime the loop resets
    // refer to int LinkedListSize = 0;

    //contains() [thing to check if the element in the list exists] and indexOf() [checks the specified element's current index] similar to ArrayList.
    public boolean contain(Player player){
        PlayerNode current = head;

        while (current != null){
            if (current.getPlayer().equals(player)){
                return true;
            }
            current = current.getNextPlayer();
        }
        return false;
    }

    public int indexOf(Player player) {
        PlayerNode current = head;
        int index = 0;

        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return index;
            }
            current = current.getNextPlayer();
            index++;
        }

        return -1;
    }
}

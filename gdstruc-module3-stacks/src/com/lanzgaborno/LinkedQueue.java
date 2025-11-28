package com.lanzgaborno;

import java.util.LinkedList;

//NOTE TO SELF USE FIFO INSTEAD OF LIFO
public class LinkedQueue {
    private LinkedList<Player> queue;

    public LinkedQueue() {
        queue = new LinkedList<Player>();
    }

    // add player to the back
    public void enqueue(Player player) {
        queue.addLast(player);
    }

    // removes frontmost player in line(queue)
    public Player dequeue() {
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void printQueue() {
        System.out.println("\n=== Current Queue in Summoners Rift... ===");
        System.out.println("Players waiting: " + queue.size());
        for (int i = 0; i < queue.size(); i++) {
            System.out.println((i + 1) + ". " + queue.get(i));
        }
        System.out.println("====================\n");
    }
}
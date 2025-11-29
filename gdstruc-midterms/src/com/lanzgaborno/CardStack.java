package com.lanzgaborno;

import java.util.LinkedList;

public class CardStack {
    private LinkedList<Card> stack; // holds t Card objects
    private String stackName; //names of discard and draw piles

    public CardStack(String stackName) {
        this.stack = new LinkedList<Card>();
        this.stackName = stackName;
    }

    public void push(Card card) {
        stack.push(card);
    }

    public Card pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.pop();
    }

    public Card peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println(stackName + " is empty.");
            return;
        }

        System.out.println(stackName + ":");
        for (int i = 0; i < stack.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + stack.get(i));
        }
    }

    public String getStackName() {
        return stackName;
    }
}
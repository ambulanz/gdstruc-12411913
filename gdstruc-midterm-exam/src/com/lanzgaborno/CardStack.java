package com.lanzgaborno;

import java.util.NoSuchElementException;

public class CardStack {
    private Card[] stack;
    private int top;
    private String stackName;

    public CardStack(String stackName) {
        this.stack = new Card[10];
        this.top = 0;
        this.stackName = stackName;
    }

    // Push card to top of stack
    public void push(Card card) {
        if (top == stack.length) {
            resize();
        }

        stack[top] = card;
        top++;
    }

    public Card pop() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        top--;
        Card card = stack[top];
        stack[top] = null;
        return card;
    }

    public Card peek() {

        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }

        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    private void resize() {
        Card[] newStack = new Card[stack.length * 2];

        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println(stackName + " is empty.");
            return;
        }

        System.out.println(stackName + ":");
        for (int i = top - 1; i >= 0; i--) {
            System.out.println("  " + (top - i) + ". " + stack[i]);
        }
    }

    public String getStackName() {
        return stackName;
    }
}
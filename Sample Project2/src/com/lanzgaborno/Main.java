package com.lanzgaborno;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // equivalent to writing "cout << "Hello World"
        // System.out.println("Hello World");

        // gets user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name");
        String name = scanner.nextLine();

        System.out.println("Hello " + name + "! Welcome to GDSTRUC!");

        // This is here to test the change feature of Git Bash!
    }
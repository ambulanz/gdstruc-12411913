package com.lanzgaborno;

public class Main {

    public static void main(String[] args) {
	    Tree tree = new Tree();

	    tree.insert(25);
	    tree.insert(17);
        tree.insert(29);
        tree.insert(10);
        tree.insert(16);
        tree.insert(-5);
        tree.insert(60);
        tree.insert(55);

        System.out.println("===== TRAVERSE IN ORDER DESCENDING =====");
        tree.traverseInOrderDescending();
        System.out.println();

        System.out.println("===== GET MIN & MAX =====");
        System.out.println("Minimum value: " + tree.getMin());
        System.out.println("Maximum value: " + tree.getMax());
    }
}

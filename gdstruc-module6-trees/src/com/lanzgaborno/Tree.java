package com.lanzgaborno;

public class Tree {

    private Node root;
    public void insert(int value)
    {
        if (root == null)
        {
            root = new Node(value);
        }
        else
        {
            root.insert(value);
        }
    }

    public void traverseInOrder()
    {
        if (root != null)
        {
            root.traverseInOrder();
        }
    }

    public Node get(int value)
    {
        if (root != null)
        {
            return root.get(value);
        }
        return null;
    }

    public void traverseInOrderDescending() {
        if (root != null) {
            root.traverseInOrderDescending();
        }
    }

    public Node getMin() {
        if (root != null) {
            return root.getMin();
        }
        return null;
    }

    public Node getMax() {
        if (root != null) {
            return root.getMax();
        }
        return null;
    }
}

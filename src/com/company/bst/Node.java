package com.company.bst;

import com.company.util.CompareObject;

/**
 * Created by Igor on 4/5/16.
 */

public class Node<T extends CompareObject<T>> {

    private T value;
    private Node left;
    private Node right;
    private Node parent;

    public Node(T value, Node right, Node left, Node parentNode) {

        this.value = value;
        this.right = right;
        this.left = left;
        parent = parentNode;
    }

    public int getHeight() {

        return Math.max(this.left.getHeight(), this.right.getHeight()) + 1;
    }

    public T getValue() {

        return value;
    }

    public Node getLeft() {

        return left;
    }

    public void setLeft(Node left) {

        this.left = left;
    }

    public Node getRight() {

        return right;
    }

    public void setRight(Node right) {

        this.right = right;
    }

    public Node getParent() {

        return parent;
    }
}

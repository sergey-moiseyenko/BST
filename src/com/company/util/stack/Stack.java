package com.company.util.stack;

/**
 * Created by Igor on 5/1/16.
 */
public class Stack<E> {

    private StackNode<E> top;

    public void push(E value) {

        StackNode<E> stackNode = new StackNode<>(value);

        if (top == null) top = stackNode;
        else {

            stackNode.setNext(top);
            top = stackNode;
        }
    }

    public E pop() {

        if (top == null) return null;
        E value = top.getValue();
        top = top.getNext();
        return value;
    }

    public boolean isEmpty() {

        return (top == null);
    }
}


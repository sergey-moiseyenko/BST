package com.company.util.stack;

/**
 * Created by Igor on 5/1/16.
 */
public class StackNode<T> {

    private T value;
    private StackNode<T> next;

    public StackNode(T value) {

        this.value = value;
        next = null;
    }

    public void setNext(StackNode<T> next) {

        this.next = next;
    }

    public StackNode<T> getNext() {

        return next;
    }

    public T getValue() {

        return value;
    }
}

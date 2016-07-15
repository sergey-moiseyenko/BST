package com.company;

import com.company.bst.BST;
import com.company.bst.NodeHandler;
import com.company.util.CompareObject;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;

/**
 * Created by Igor on 4/10/16.
 */
public class ConsoleWriter<T extends CompareObject<T>> implements NodeHandler<T> {

    @Override
    public void handle(T object) {

        System.out.println(object);
    }
}

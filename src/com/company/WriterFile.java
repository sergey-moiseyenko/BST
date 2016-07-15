package com.company;

import com.company.bst.NodeHandler;

import java.io.*;

import com.company.util.CompareObject;

/**
 * Created by Igor on 4/17/16.
 */
public class WriterFile<T> implements NodeHandler<T> {

    @Override
    public void handle(T object) {

        File file = new File("tree.txt");

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(object.toString());
            writer.write("\n");
            writer.close();

        } catch (IOException exeption) {

            exeption.printStackTrace();
        }
    }
}

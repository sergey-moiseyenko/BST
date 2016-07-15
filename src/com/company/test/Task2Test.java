package com.company.test;

import com.company.bst.BST;
import com.company.Car;

/**
 * Created by Igor on 3/23/16.
 */
public class Task2Test {

    public static void runTest() {

        BST<Car> tree = new BST<>();
        Car car1 = new Car(10);
        Car car2 = new Car(5);
        Car car3 = new Car(12);

        tree.insert(car1);
        tree.insert(car2);
        tree.insert(car3);

        System.out.println(tree.getHeight());
    }
}

package com.company.test;

import com.company.bst.BST;
import com.company.Car;

/**
 * Created by Igor on 3/22/16.
 */
public class Task1Test {

    public static void runTest() {

        BST<Car> tree = new BST<>();
        Car car1 = new Car(31);
        Car car2 = new Car(0);
        Car car3 = new Car(2);

        tree.insert(car1);
        tree.insert(car2);
        tree.insert(car3);

        System.out.println(tree.getSize());
        System.out.println(tree.isEmpty());
        Car searchNode =  tree.search(car1);
        System.out.println(searchNode);
    }
}

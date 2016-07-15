package com.company;

import com.company.bst.BST;
import com.company.util.Iterator;
import com.company.util.stack.*;

public class Main {

    public static void main(String[] args) {

        Car car = new Car(20);
        Car car1 = new Car(10);
        Car car2 = new Car(7);
        Car car3 = new Car(4);
        Car car4 = new Car(1);
        Car car5 = new Car(5);
        Car car6 = new Car(6);
        Car car7 = new Car(21);
        Car car8 = new Car(25);
        Car car9 = new Car(28);
        Car car10 = new Car(29);
        Car car11 = new Car(31);
        Car car12 = new Car(33);

        BST<Car> tree = new BST<>();
        tree.insert(car);
        tree.insert(car1);
        tree.insert(car2);
        tree.insert(car3);
        tree.insert(car4);
        tree.insert(car5);
        tree.insert(car6);
        tree.insert(car7);
        tree.insert(car8);
        tree.insert(car9);
        tree.insert(car10);
        tree.insert(car11);
        tree.insert(car12);

        //Iterator iterator = tree.getIterator();

        //while (iterator.hasNext()) {

        //System.out.println(iterator.next());
        //}

        Iterator iterator = tree.getOtherIterator();

        //while (iterator.hasNext() == false) {

        while(iterator.hasNext()) {

        System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());

        }
        //}
    }
}
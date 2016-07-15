package com.company;

import com.company.util.CompareObject;

/**
 * Created by Igor on 3/16/16.
 * TODO: delete
 */
public class Car implements CompareObject<Car> {

    private int coast;

    public Car(int coast) {

        this.coast = coast;
    }

    @Override
    public int compare(Car car) {

        if (car == null) throw new IllegalArgumentException();

        int result = 0;
        if (car.getCoast() > coast) result = 1;
        if (car.getCoast() < coast) result = -1;

        return result;
    }

    @Override
    public String toString() {

        return Integer.toString(coast);
    }

    public int getCoast() {

        return coast;
    }
}

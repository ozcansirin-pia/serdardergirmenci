package com.serdardegirmenci.vodafonegarage.entities.impl;

import com.serdardegirmenci.vodafonegarage.entities.Car;

public class CarImpl implements Car {
    @Override
    public String getType() {
        return "Car";
    }

    @Override
    public int getSlots() {
        return 1;
    }
}

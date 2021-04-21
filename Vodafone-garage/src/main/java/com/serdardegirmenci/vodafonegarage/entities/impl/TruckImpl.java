package com.serdardegirmenci.vodafonegarage.entities.impl;

import com.serdardegirmenci.vodafonegarage.entities.Car;

public class TruckImpl implements Car {
    @Override
    public String getType() {
        return "Truck";
    }

    @Override
    public int getSlots() {
        return 4;
    }
}

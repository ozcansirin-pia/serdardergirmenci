package com.serdardegirmenci.vodafonegarage.entities.impl;

import com.serdardegirmenci.vodafonegarage.entities.Car;

public class JeepImpl implements Car {
    @Override
    public String getType() {
        return "Jeep";
    }

    @Override
    public int getSlots() {
        return 2;
    }
}

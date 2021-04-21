package com.serdardegirmenci.vodafone.entities.impls;

import com.serdardegirmenci.vodafone.entities.Car;

public class SedanImpl implements Car {
    @Override
    public String getType() {
        return "Sedan";
    }
}

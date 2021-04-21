package com.serdardegirmenci.vodafone.entities.impls;

import com.serdardegirmenci.vodafone.entities.Car;

public class HatchbackImpl implements Car {
    @Override
    public String getType() {
        return "Hatchback";
    }
}

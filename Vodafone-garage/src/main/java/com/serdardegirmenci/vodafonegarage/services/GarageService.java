package com.serdardegirmenci.vodafonegarage.services;

import com.serdardegirmenci.vodafonegarage.entities.CarFeatures;

import java.util.ArrayList;

public interface GarageService {
    String carPark(CarFeatures car, CarFeatures emptySlot);
    String leaveCar(int ticket);
    String[] getStatus();
}

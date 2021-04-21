package com.serdardegirmenci.vodafonegarage.entities;

import java.util.ArrayList;

public class Garage {

    private static Garage garage = null;
    private ArrayList<CarFeatures> garageSlots = new ArrayList<>(10);

    Garage() {
    }

    public synchronized static Garage getInstance() {
        if (garage == null) {
            garage = new Garage();
        }
        return garage;
    }

    public ArrayList<CarFeatures> getGarageSlots() {
        if(garageSlots.size() == 0){
            for (int i=0;i<10;i++){
                this.garageSlots.add(null);
            }
        }
        return garageSlots;
    }

    public void parkCar (int index, CarFeatures car) {
        this.garageSlots.set(index, car);
    }

    public void leaveCar(int index){
        this.garageSlots.set(index,null);
    }
}

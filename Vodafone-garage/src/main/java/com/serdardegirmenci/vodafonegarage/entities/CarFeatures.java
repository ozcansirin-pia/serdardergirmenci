package com.serdardegirmenci.vodafonegarage.entities;

public class CarFeatures {
    public String carType;
    public String carPlate;
    public int carSlot;
    public  String carColor;
    public int carParkTicket;

    public int getCarParkTicket() {
        return carParkTicket;
    }

    public void setCarParkTicket(int carParkTicket) {
        this.carParkTicket = carParkTicket;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public int getCarSlot() {
        return carSlot;
    }

    public void setCarSlot(int carSlot) {
        this.carSlot = carSlot;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
}

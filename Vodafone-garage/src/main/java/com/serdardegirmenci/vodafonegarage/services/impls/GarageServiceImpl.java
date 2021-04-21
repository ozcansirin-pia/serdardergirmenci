package com.serdardegirmenci.vodafonegarage.services.impls;

import com.serdardegirmenci.vodafonegarage.entities.CarFeatures;
import com.serdardegirmenci.vodafonegarage.entities.Garage;
import com.serdardegirmenci.vodafonegarage.services.GarageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GarageServiceImpl implements GarageService {
    private Garage garage = Garage.getInstance();

    @Override
    public String carPark(CarFeatures car, CarFeatures emptySlot) {
        String response = "";
        boolean isPark = false;
        int emptySlots = 0;
        if (garage.getGarageSlots().size() > 0) {

            for (CarFeatures c : garage.getGarageSlots()) {
                if (c != null && c.getCarPlate().equals(car.getCarPlate())) {
                    isPark = true;
                    break;
                }
            }
        }
        if (!isPark) {

            for (int i = 0; i < 10; i++) {
                if (garage.getGarageSlots().get(i) == null) {
                    emptySlots = emptySlots + 1;
                } else {
                    emptySlots = 0;
                }

                if (emptySlots == (car.carSlot + 1)) {
                    for (int a = (i + 1 - emptySlots); a <= i; a++) {
                        if(a != i){
                            car.setCarParkTicket(a);
                            garage.parkCar(a, car);
                        }else {
                            emptySlot.setCarParkTicket(car.getCarParkTicket());
                            garage.parkCar(a, emptySlot);
                        }
                    }
                    response = "ok";
                    break;
                } else if (i == 9) {
                    response = "full";
                }
            }

        } else {
            response = "is-park";
        }

        return response;
    }

    @Override
    public String leaveCar(int ticket) {
        String response = "fail";
        int i = 0;
        for (CarFeatures c : garage.getGarageSlots()) {
            if (c != null && c.getCarParkTicket() == ticket) {
                garage.leaveCar(i);
                response = "ok";
            }
            i = i + 1;
        }
        return response;
    }

    private String getSlots(String carPlate) {
        String slots = "";
        return slots;
    }

    @Override
    public String[] getStatus() {
        String cars[] = new String[10];
        if (garage.getGarageSlots().size() > 0) {
            int i = 0;
            for (CarFeatures c : garage.getGarageSlots()) {

                if (c != null) {
                    if (cars[c.getCarParkTicket()] != null && c.getCarColor() != null) {
                        cars[c.getCarParkTicket()] = cars[c.getCarParkTicket()].replace("]", "") + ", " + (i + 1) + "]";
                    } else if(c.getCarColor() != null) {
                        cars[c.getCarParkTicket()] = c.getCarPlate() + " - (ticket no : " + c.getCarParkTicket() + ") [" + (i + 1)+"]";
                    }
                }
                i = i + 1;
            }
        }
        return cars;
    }
}

package com.serdardegirmenci.vodafonegarage.controllers;

import com.serdardegirmenci.vodafonegarage.entities.Car;
import com.serdardegirmenci.vodafonegarage.entities.CarFeatures;
import com.serdardegirmenci.vodafonegarage.entities.impl.CarImpl;
import com.serdardegirmenci.vodafonegarage.entities.impl.JeepImpl;
import com.serdardegirmenci.vodafonegarage.entities.impl.TruckImpl;
import com.serdardegirmenci.vodafonegarage.services.CarFactory;
import com.serdardegirmenci.vodafonegarage.services.GarageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class GarageController {
    private CarFactory carFactory;
    private GarageService garageService;

    public GarageController(CarFactory carFactory, GarageService garageService) {
        this.carFactory = carFactory;
        this.garageService = garageService;
    }

    @PostMapping(value = "/park-car")
    public String parkCar(HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        String response = "";

        if (
                request.getParameter("car_type") != null && !request.getParameter("car_type").isEmpty() &&
                        request.getParameter("car_color") != null && !request.getParameter("car_color").isEmpty() &&
                        request.getParameter("car_plate") != null && !request.getParameter("car_plate").isEmpty()
        ) {
            Car getCar = null;
            switch (request.getParameter("car_type")) {
                case "Car":
                    getCar = carFactory.getCarInfo(CarImpl.class);
                    break;
                case "Jeep":
                    getCar = carFactory.getCarInfo(JeepImpl.class);
                    break;
                case "Truck":
                    getCar = carFactory.getCarInfo(TruckImpl.class);
                    break;
                default:
                    getCar = null;
            }
            if(getCar != null) {
                CarFeatures carFeatures = new CarFeatures();
                carFeatures.setCarColor(request.getParameter("car_color"));
                carFeatures.setCarPlate(request.getParameter("car_plate"));
                carFeatures.setCarType(getCar.getType());
                carFeatures.setCarSlot(getCar.getSlots());

                CarFeatures emptySlot = new CarFeatures();
                emptySlot.setCarPlate(request.getParameter("car_plate"));

                String result = garageService.carPark(carFeatures, emptySlot);
                if(result.equals("full")){
                    response ="Garage is full.";
                }else if(result.equals("is-park")){
                    response ="This car is already in the park.";
                }else {
                    String slotCount = getCar.getSlots() > 1 ? " slots" : " slot";
                    response = "Allocated " + getCar.getSlots() + slotCount + ".";
                }
            }else{
                response = "Bad Request";
            }
        }else{
            response = "Bad Request";
        }
        return response;

    }

    @PostMapping(value = "/leave-car")
    public String leaveCar(HttpServletRequest request) {
        String response = "";
        if (request.getParameter("ticket") != null && !request.getParameter("ticket").isEmpty()){
            String result = garageService.leaveCar(Integer.parseInt(request.getParameter("ticket")));
            if(result.equals("fail")){
                response = "Bad Request";
            }
        }else{
            response = "Bad Request";
        }
        return response;
    }

    @GetMapping(value = "/status")
    public String getStatus() {
        String response = "";

        for (String s: garageService.getStatus()) {
            if(s != null){
                response = response + s +"\n";
            }
        }
        return response;

    }
}

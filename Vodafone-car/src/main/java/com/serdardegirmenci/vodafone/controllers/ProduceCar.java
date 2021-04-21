package com.serdardegirmenci.vodafone.controllers;

import com.serdardegirmenci.vodafone.entities.Car;
import com.serdardegirmenci.vodafone.entities.impls.CabrioImpl;
import com.serdardegirmenci.vodafone.entities.impls.HatchbackImpl;
import com.serdardegirmenci.vodafone.entities.impls.SedanImpl;
import com.serdardegirmenci.vodafone.services.CarFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ProduceCar {
    private CarFactory carFactory;

    public ProduceCar(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    @PostMapping(value = "/produce-car")
    public String produceCar(HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        String response = "Car could not be produce";
        if (request.getParameter("car_type") != null && !request.getParameter("car_type").isEmpty()) {
            String getCarType = "";
            switch (request.getParameter("car_type")) {
                case "Cabrio":
                    getCarType = carFactory.produceCar(CabrioImpl.class).getType();
                    break;
                case "Hatchback":
                    getCarType = carFactory.produceCar(HatchbackImpl.class).getType();
                    break;
                case "Sedan":
                    getCarType = carFactory.produceCar(SedanImpl.class).getType();
                    break;
            }
            if (!getCarType.isEmpty()) {
                response = getCarType + " Car has produced.";
            }
        }

        return response;
    }
}

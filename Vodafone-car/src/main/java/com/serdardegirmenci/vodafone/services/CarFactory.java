package com.serdardegirmenci.vodafone.services;

import com.serdardegirmenci.vodafone.entities.Car;
import org.springframework.stereotype.Service;

@Service
public class CarFactory {
    public static Car produceCar(Class carClass) throws InstantiationException, IllegalAccessException {
        return (Car) carClass.newInstance();
    }
}

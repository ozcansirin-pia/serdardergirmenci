package com.serdardegirmenci.vodafonegarage.services;

import com.serdardegirmenci.vodafonegarage.entities.Car;
import com.serdardegirmenci.vodafonegarage.entities.CarFeatures;
import org.springframework.stereotype.Service;

@Service
public class CarFactory {
    public static Car getCarInfo(Class carClass) throws InstantiationException, IllegalAccessException {
        return (Car) carClass.newInstance();
    }
}

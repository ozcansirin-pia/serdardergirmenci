package com.serdardegirmenci.vodafonegarage.services;

import com.serdardegirmenci.vodafonegarage.entities.impl.CarImpl;
import com.serdardegirmenci.vodafonegarage.entities.impl.JeepImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarFactoryTest {
    @InjectMocks
    CarFactory carFactory;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void getCarInfoTest() throws InstantiationException, IllegalAccessException {
        Assertions.assertEquals(1,carFactory.getCarInfo(CarImpl.class).getSlots());
    }

    @Test
    public void getCarInfoFailTest() throws InstantiationException, IllegalAccessException {
        Assertions.assertNotEquals("4",carFactory.getCarInfo(JeepImpl.class).getSlots());
    }
}
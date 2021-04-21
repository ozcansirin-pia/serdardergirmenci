package com.serdardegirmenci.vodafone.services;

import com.serdardegirmenci.vodafone.entities.impls.CabrioImpl;
import com.serdardegirmenci.vodafone.entities.impls.SedanImpl;
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
    public void produceCarTest() throws InstantiationException, IllegalAccessException {
        Assertions.assertEquals("Cabrio",carFactory.produceCar(CabrioImpl.class).getType());
    }

    @Test
    public void produceCarFailTest() throws InstantiationException, IllegalAccessException {
        Assertions.assertNotEquals("Cabrio",carFactory.produceCar(SedanImpl.class).getType());
    }
}
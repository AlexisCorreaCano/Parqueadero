package co.com.ceiba.domain.model;

import java.util.Date;

import co.com.ceiba.domain.common.exception.BusinessException;

public class Car extends Vehicle {
    public Car(String licensePlate, Date checkInDate) throws BusinessException {
        super(licensePlate, checkInDate);
    }
}

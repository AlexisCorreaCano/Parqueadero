package co.com.ceiba.domain.model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

import co.com.ceiba.domain.common.exception.BusinessException;

public class CarTest {

    private Date checkInDate;

    public void setUp(){
        checkInDate = new Date();
    }

    @Test
    public void shouldCreateCar() throws BusinessException {
        Car car;
        String licensePlate = "ASD234";

        car = new Car(licensePlate,checkInDate);

        assertEquals(car.getCheckInDate(),checkInDate);
        assertEquals(car.getLicensePlate(),"ASD234");

    }

    @Test(expected = BusinessException.class)
    public void shouldReturnBusinessExceptionBadLicensePlate() throws BusinessException {
        Car car;
        String licensePlate = "ASD";

        car = new Car(licensePlate,checkInDate);

    }

}

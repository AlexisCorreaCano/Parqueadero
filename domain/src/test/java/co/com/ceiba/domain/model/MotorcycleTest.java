package co.com.ceiba.domain.model;

import org.junit.Test;

import java.util.Date;

import co.com.ceiba.domain.common.exception.BusinessException;

import static org.junit.Assert.assertEquals;

public class MotorcycleTest {

    private Date checkInDate;

    public void setUp(){
        checkInDate = new Date();
    }

    @Test
    public void shouldCreateMotorcycle() throws BusinessException {
        Motorcycle motorcycle;
        String licensePlate = "ASD234";
        int cylinderCapacity = 200;

        motorcycle = new Motorcycle(licensePlate,checkInDate,cylinderCapacity);

        assertEquals(motorcycle.getCheckInDate(),checkInDate);
        assertEquals(motorcycle.getLicensePlate(),"ASD234");
        assertEquals(motorcycle.getCylinderCapacity(),200);
    }

    @Test(expected = BusinessException.class)
    public void shouldReturnBusinessExceptionBadCylinderCapacity() throws BusinessException {
        Motorcycle motorcycle;
        String licensePlate = "ASD234";
        int cylinderCapacity = 0;

        motorcycle = new Motorcycle(licensePlate,checkInDate,cylinderCapacity);
    }

    @Test(expected = BusinessException.class)
    public void shouldReturnBusinessExceptionBadLicensePlate() throws BusinessException {
        Motorcycle motorcycle;
        String licensePlate = "ASD";
        int cylinderCapacity = 200;

        motorcycle = new Motorcycle(licensePlate,checkInDate,cylinderCapacity);
    }
}

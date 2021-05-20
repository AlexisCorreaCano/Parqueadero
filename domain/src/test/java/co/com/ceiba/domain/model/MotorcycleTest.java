package co.com.ceiba.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

import co.com.ceiba.domain.common.exception.BusinessException;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MotorcycleTest {

    private Date checkInDate;

    public void setUp(){
        checkInDate = new Date();
    }

    @Test
    public void shouldCreateMotorcycle() throws BusinessException {
        //Arrange
        Motorcycle motorcycle;
        String licensePlate = "ASD234";
        int cylinderCapacity = 200;

        //Act
        motorcycle = new Motorcycle(licensePlate,checkInDate,cylinderCapacity);

        //Assert
        assertEquals(motorcycle.getCylinderCapacity(),200);
    }

    @Test(expected = BusinessException.class)
    public void shouldReturnBusinessExceptionBadCylinderCapacity() throws BusinessException {
        //Arrange
        Motorcycle motorcycle;
        String licensePlate = "ASD234";
        int cylinderCapacity = 0;

        //Act
        motorcycle = new Motorcycle(licensePlate,checkInDate,cylinderCapacity);
    }

    @Test(expected = BusinessException.class)
    public void shouldReturnBusinessExceptionBadLicensePlate() throws BusinessException {
        //Arrange
        Motorcycle motorcycle;
        String licensePlate = "ASD";
        int cylinderCapacity = 200;

        //Act
        motorcycle = new Motorcycle(licensePlate,checkInDate,cylinderCapacity);
    }
}

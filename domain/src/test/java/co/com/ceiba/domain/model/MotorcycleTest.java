package co.com.ceiba.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

import co.com.ceiba.domain.common.exception.BusinessException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class MotorcycleTest {

    private Date checkInDate;

    public void setUp(){
        checkInDate = new Date();
    }

    @Test
    public void constructor_createMotorcycleWith200CylinderCapacity_shouldCreateMotorcycle() throws BusinessException {
        //Arrange
        Motorcycle motorcycle;
        String licensePlate = "ASD234";
        int cylinderCapacity = 200;

        //Act
        motorcycle = new Motorcycle(licensePlate,checkInDate,cylinderCapacity);

        //Assert
        assertEquals(motorcycle.getCylinderCapacity(),200);
    }

    @Test
    public void constructor_createMotorcycleWith0CylinderCapacity_shouldReturnBusinessException(){
        //Arrange
        Motorcycle motorcycle;
        String licensePlate = "ASD234";
        int cylinderCapacity = 0;
        BusinessException exceptionExpected = null;

        try {
            //Act
            motorcycle = new Motorcycle(licensePlate,checkInDate,cylinderCapacity);
        }catch (BusinessException e){
            exceptionExpected = e;
        }finally {
            //Assert
            assertNotNull(exceptionExpected);
        }

    }

    @Test
    public void constructor_createThreeSixLicensePlateMotorcycle_shouldReturnBusinessException(){
        //Arrange
        Motorcycle motorcycle;
        String licensePlate = "ASD";
        int cylinderCapacity = 200;
        BusinessException exceptionExpected = null;

        try {
            //Act
            motorcycle = new Motorcycle(licensePlate,checkInDate,cylinderCapacity);
        }catch (BusinessException e){
            exceptionExpected = e;
        }finally {
            //Assert
            assertNotNull(exceptionExpected);
        }


    }
}

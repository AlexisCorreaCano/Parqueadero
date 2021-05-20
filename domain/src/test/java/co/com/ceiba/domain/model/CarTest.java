package co.com.ceiba.domain.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

import static org.junit.Assert.assertEquals;

import co.com.ceiba.domain.common.exception.BusinessException;

@RunWith(JUnit4.class)
public class CarTest {

    private Date checkInDate;

    @Before
    public void setUp(){
        checkInDate = new Date();
    }

    @Test
    public void constructor_createSizeSixLicensePlateCar_shouldCreateCar() throws BusinessException {
        //Arrange
        Car car;
        String licensePlate = "ASD234";

        //Act
        car = new Car(licensePlate,checkInDate);

        //Assert
        assertEquals(car.getLicensePlate(),"ASD234");

    }

    @Test(expected = BusinessException.class)
    public void  constructor_createThreeSixLicensePlateCar_shouldReturnBusinessException() throws BusinessException {
        //Arrange
        Car car;
        String licensePlate = "ASD";

        //Act
        car = new Car(licensePlate,checkInDate);

    }

}

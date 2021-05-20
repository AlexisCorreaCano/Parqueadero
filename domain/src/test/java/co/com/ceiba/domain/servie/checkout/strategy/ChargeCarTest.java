package co.com.ceiba.domain.servie.checkout.strategy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.service.checkout.strategy.ChargeCar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class ChargeCarTest {

    private ChargeCar chargeCar;

    @Mock
    private Car car;

    private Date date;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        chargeCar = new ChargeCar();
        date = new Date();
    }

    @Test
    public void chargeToVehicle_chargeVehicleForOneHour_shouldReturn1000total(){
        //Arrange
        date.setHours(date.getHours()-1);
        when(car.getCheckInDate()).thenReturn(date);

        //Act
        double result = chargeCar.chargeToVehicle(car);

        //Assert
        assertEquals(result,1000.0,0);

    }

    @Test
    public void chargeToVehicle_chargeVehicleForNineHours_shouldReturn8000total(){
        //Arrange
        date.setHours(date.getHours()-9);
        when(car.getCheckInDate()).thenReturn(date);

        //Act
        double result = chargeCar.chargeToVehicle(car);

        //Assert
        assertEquals(result,8000.0,0);
    }

    @Test
    public void chargeToVehicle_chargeVehicleForOneDay_shouldReturn8000total(){
        //Arrange
        date.setHours(date.getHours()-24);
        when(car.getCheckInDate()).thenReturn(date);

        //Act
        double result = chargeCar.chargeToVehicle(car);

        //Assert
        assertEquals(result,8000.0,0);
    }

    @Test
    public void chargeToVehicle_chargeVehicleForOneDayAndOneHour_shouldReturn9000total(){
        //Arrange
        date.setHours(date.getHours()-25);
        when(car.getCheckInDate()).thenReturn(date);

        //Act
        double result = chargeCar.chargeToVehicle(car);

        //Assert
        assertEquals(result,9000.0,0);
    }

    @Test
    public void chargeToVehicle_chargeVehicleForOneDayAndNineHours_shouldReturn16000total(){
        //Arrange
        date.setHours(date.getHours()-33);
        when(car.getCheckInDate()).thenReturn(date);

        //Act
        double result = chargeCar.chargeToVehicle(car);

        //Assert
        assertEquals(result,16000.0,0);
    }
}

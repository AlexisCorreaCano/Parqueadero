package co.com.ceiba.domain.servie.checkout.strategy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.service.checkout.strategy.ChargeMotorcycle;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class ChargeMotorcycleTest {

    private ChargeMotorcycle chargeMotorcycle;

    @Mock
    private Motorcycle motorcycle;

    private Date date;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        chargeMotorcycle = new ChargeMotorcycle();
        date = new Date();
    }

    @Test
    public void chargeToVehicle_chargeVehicleForOneHourAnd200CC_shouldReturn500total(){
        //Arrange
        date.setHours(date.getHours()-1);
        when(motorcycle.getCheckInDate()).thenReturn(date);
        when(motorcycle.getCylinderCapacity()).thenReturn(200);

        //Act
        double result = chargeMotorcycle.chargeToVehicle(motorcycle);

        //Assert
        assertEquals(result,500.0,0);

    }

    @Test
    public void chargeToVehicle_chargeVehicleForNineHoursAnd200CC_shouldReturn4000total(){
        //Arrange
        date.setHours(date.getHours()-9);
        when(motorcycle.getCheckInDate()).thenReturn(date);
        when(motorcycle.getCylinderCapacity()).thenReturn(200);

        //Act
        double result = chargeMotorcycle.chargeToVehicle(motorcycle);

        //Assert
        assertEquals(result,4000.0,0);
    }

    @Test
    public void chargeToVehicle_chargeVehicleForOneDayAnd200CC_shouldReturn4000total(){
        //Arrange
        date.setHours(date.getHours()-24);
        when(motorcycle.getCheckInDate()).thenReturn(date);
        when(motorcycle.getCylinderCapacity()).thenReturn(200);

        //Act
        double result = chargeMotorcycle.chargeToVehicle(motorcycle);

        //Assert
        assertEquals(result,4000.0,0);
    }

    @Test
    public void chargeToVehicle_chargeVehicleForOneDayAndOneHourAnd200CC_shouldReturn4500total(){
        //Arrange
        date.setHours(date.getHours()-25);
        when(motorcycle.getCheckInDate()).thenReturn(date);
        when(motorcycle.getCylinderCapacity()).thenReturn(200);

        //Act
        double result = chargeMotorcycle.chargeToVehicle(motorcycle);

        //Assert
        assertEquals(result,4500.0,0);
    }

    @Test
    public void chargeToVehicle_chargeVehicleForOneDayAndNineHoursAnd200CC_shouldReturn8000total(){
        //Arrange
        date.setHours(date.getHours()-33);
        when(motorcycle.getCheckInDate()).thenReturn(date);
        when(motorcycle.getCylinderCapacity()).thenReturn(200);

        //Act
        double result = chargeMotorcycle.chargeToVehicle(motorcycle);

        //Assert
        assertEquals(result,8000.0,0);
    }

    @Test
    public void chargeToVehicle_chargeVehicleForOneDayAndNineHoursAnd600CC_shouldReturn10000total(){
        //Arrange
        date.setHours(date.getHours()-33);
        when(motorcycle.getCheckInDate()).thenReturn(date);
        when(motorcycle.getCylinderCapacity()).thenReturn(600);

        //Act
        double result = chargeMotorcycle.chargeToVehicle(motorcycle);

        //Assert
        assertEquals(result,10000.0,0);
    }
}

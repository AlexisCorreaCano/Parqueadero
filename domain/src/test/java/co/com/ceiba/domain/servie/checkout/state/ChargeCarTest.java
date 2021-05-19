package co.com.ceiba.domain.servie.checkout.state;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.service.checkout.state.ChargeCar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
    public void shouldCalculateOneHour(){
        date.setHours(date.getHours()-1);
        when(car.getCheckInDate()).thenReturn(date);

        double result = chargeCar.chargeToVehicle(car);

        assertEquals(result,1000.0,0);

    }

    @Test
    public void shouldCalculateNineHour(){
        date.setHours(date.getHours()-9);
        when(car.getCheckInDate()).thenReturn(date);

        double result = chargeCar.chargeToVehicle(car);

        assertEquals(result,8000.0,0);
    }

    @Test
    public void shouldCalculateOneDay(){
        date.setHours(date.getHours()-24);
        when(car.getCheckInDate()).thenReturn(date);

        double result = chargeCar.chargeToVehicle(car);

        assertEquals(result,8000.0,0);
    }

    @Test
    public void shouldCalculateOneDayMoreOneHour(){
        date.setHours(date.getHours()-25);
        when(car.getCheckInDate()).thenReturn(date);

        double result = chargeCar.chargeToVehicle(car);

        assertEquals(result,9000.0,0);
    }

    @Test
    public void shouldCalculateOneDayMoreNineHour(){
        date.setHours(date.getHours()-33);
        when(car.getCheckInDate()).thenReturn(date);

        double result = chargeCar.chargeToVehicle(car);

        assertEquals(result,16000.0,0);
    }
}

package co.com.ceiba.domain.servie.checkout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.repository.VehicleRepository;
import co.com.ceiba.domain.service.checkout.CheckOutService;
import co.com.ceiba.domain.service.checkout.strategy.ChargeCar;
import co.com.ceiba.domain.service.checkout.strategy.ChargeContext;
import co.com.ceiba.domain.service.checkout.strategy.ChargeMotorcycle;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class CheckOutServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private ChargeContext chargeContext;

    @Mock
    private Car car;

    @Mock
    private Motorcycle motorcycle;

    @Mock
    private ChargeMotorcycle chargeMotorcycle;

    @Mock
    private ChargeCar chargeCar;

    private CheckOutService checkOutService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        checkOutService  = new CheckOutService(vehicleRepository,chargeContext);
    }

    @Test
    public void shouldDeleteAndChargeCar(){
        //Arrange
        when(chargeContext.getStrategy()).thenReturn(chargeCar);
        when(chargeCar.chargeToVehicle(car)).thenReturn(2000.0);

        //Act
        double result =checkOutService.takeOutVehicle(car);

        assertEquals(result,2000.0,0);
    }

    @Test
    public void shouldDeleteAndChargeMotorcycle(){
        //Arrange
        when(chargeContext.getStrategy()).thenReturn(chargeMotorcycle);
        when(chargeMotorcycle.chargeToVehicle(motorcycle)).thenReturn(4000.0);

        //Act
        double result = checkOutService.takeOutVehicle(motorcycle);

        //Assert
        assertEquals(result,4000.0,0);
    }

}

package co.com.ceiba.domain.servie.checkout.state;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.service.checkout.strategy.ChargeCar;
import co.com.ceiba.domain.service.checkout.strategy.ChargeContext;
import co.com.ceiba.domain.service.checkout.strategy.ChargeMotorcycle;
import co.com.ceiba.domain.service.checkout.strategy.ChargeStrategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class ChargeContextTest {

    @Mock
    private Car car;

    @Mock
    private Motorcycle motorcycle;

    private ChargeContext chargeContext;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        chargeContext = new ChargeContext();
    }

    @Test
    public void shouldReturnChargeCar(){
        //Arrange
        chargeContext.setStrategy(car);

        //Act
        ChargeStrategy stateResult = chargeContext.getStrategy();

        //Assert
        assertTrue(stateResult instanceof ChargeCar);
    }

    @Test
    public void shouldReturnChargeMotorcycle(){
        //Arrange
        chargeContext.setStrategy(motorcycle);

        //Act
        ChargeStrategy stateResult = chargeContext.getStrategy();

        //Assert
        assertTrue(stateResult instanceof ChargeMotorcycle);
    }

}

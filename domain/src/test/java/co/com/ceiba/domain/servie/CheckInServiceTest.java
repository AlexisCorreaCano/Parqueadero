package co.com.ceiba.domain.servie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.repository.VehicleRepository;
import co.com.ceiba.domain.service.CheckInService;

import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class CheckInServiceTest {
    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private Car car;

    @Mock
    private Motorcycle motorcycle;

    CheckInService checkInService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        checkInService = new CheckInService(vehicleRepository);
    }
    
    @Test
    public void shouldEnterCar() throws BusinessException {
        //Arrange
        when(vehicleRepository.getCarsNumber()).thenReturn(0);
        when(car.getLicensePlate()).thenReturn("ASD456");

        //Act
        checkInService.enterVehicle(car);

    }

    @Test
    public void shouldEnterMotorcycle() throws BusinessException {
        //Arrange
        when(vehicleRepository.getMotorcyclesNumber()).thenReturn(0);

        //Act
        checkInService.enterVehicle(motorcycle);

    }

    @Test(expected = BusinessException.class)
    public void shouldReturnBusinessExceptionNoCarCapacity() throws BusinessException {
        //Arrange
        when(vehicleRepository.getCarsNumber()).thenReturn(20);

        //Act
        checkInService.enterVehicle(car);

    }

    @Test(expected = BusinessException.class)
    public void shouldReturnBusinessExceptionNoMotorcycleCapacity() throws BusinessException {
        //Arrange
        when(vehicleRepository.getMotorcyclesNumber()).thenReturn(10);

        //Act
        checkInService.enterVehicle(motorcycle);

    }
    
}

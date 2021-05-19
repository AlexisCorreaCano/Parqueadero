package co.com.ceiba.domain.servie;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.repository.VehicleRepository;
import co.com.ceiba.domain.service.CheckInService;

import static org.mockito.Mockito.when;

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
        //
        when(vehicleRepository.getCarsNumber()).thenReturn(0);
        when(car.getLicensePlate()).thenReturn("ASD456");
        //
        checkInService.enterVehicle(car);

    }

    @Test
    public void shouldEnterMotorcycle() throws BusinessException {
        //
        when(vehicleRepository.getMotorcyclesNumber()).thenReturn(0);
        //
        checkInService.enterVehicle(motorcycle);

    }

    @Test(expected = BusinessException.class)
    public void shouldReturnBusinessExceptionNoCarCapacity() throws BusinessException {
        //
        when(vehicleRepository.getCarsNumber()).thenReturn(20);
        //
        checkInService.enterVehicle(car);

    }

    @Test(expected = BusinessException.class)
    public void shouldReturnBusinessExceptionNoMotorcycleCapacity() throws BusinessException {
        //
        when(vehicleRepository.getMotorcyclesNumber()).thenReturn(10);
        //
        checkInService.enterVehicle(motorcycle);

    }
    
}

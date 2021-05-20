package co.com.ceiba.domain.servie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.repository.VehicleRepository;
import co.com.ceiba.domain.service.ParkingService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class ParkingServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private List<Car> cars;

    @Mock
    private List<Motorcycle> motorcycles;

    @Mock
    private BusinessException businessException;

    private ParkingService parkingService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        parkingService = new ParkingService(vehicleRepository);
    }

    @Test
    public void shouldGetCars() throws BusinessException {
        //Arrange
        when(vehicleRepository.getCars()).thenReturn(cars);

        //Act
        List<Car> result = parkingService.getCars();

        //Assert
        assertEquals(result, cars);
    }

    @Test
    public void shouldGetMotorcycles() throws BusinessException {

        //Arrange
        when(vehicleRepository.getMotorcycles()).thenReturn(motorcycles);

        //Act
        List<Motorcycle> result = parkingService.getMotorcycles();

        assertEquals(result, motorcycles);
    }

    @Test(expected = BusinessException.class)
    public void shouldReturnBusinessExceptionErrorCar() throws BusinessException {
        //Arrange
        when(vehicleRepository.getCars()).thenThrow(businessException);

        //Act
        List<Car> result = parkingService.getCars();

    }

    @Test(expected = BusinessException.class)
    public void shouldReturnBusinessExceptionErrorMotorcycle() throws BusinessException {
        //Arrange
        when(vehicleRepository.getMotorcycles()).thenThrow(businessException);

        //Act
        List<Motorcycle> result = parkingService.getMotorcycles();

    }

}

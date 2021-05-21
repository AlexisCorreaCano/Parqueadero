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
import static org.junit.Assert.assertNotNull;
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
    public void getCars_askForAllCars_shouldReturnListCars() throws BusinessException {
        //Arrange
        when(vehicleRepository.getCars()).thenReturn(cars);

        //Act
        List<Car> result = parkingService.getCars();

        //Assert
        assertEquals(result, cars);
    }

    @Test
    public void getCars_askForAllMotorcycles_shouldReturnListMotorcycles() throws BusinessException {

        //Arrange
        when(vehicleRepository.getMotorcycles()).thenReturn(motorcycles);

        //Act
        List<Motorcycle> result = parkingService.getMotorcycles();

        //Assert
        assertEquals(result, motorcycles);
    }

    @Test
    public void getCars_askForAllCarsWithError_shouldReturnBusinessException(){
        //Arrange
        when(vehicleRepository.getCars()).thenThrow(businessException);
        BusinessException exceptionExpected = null;

        try{
            //Act
            List<Car> result = parkingService.getCars();
        }catch (BusinessException e){
            exceptionExpected = e;
        }finally {
            //Assert
            assertNotNull(exceptionExpected);
        }



    }

    @Test
    public void getCars_askForAllMotorcyclesWithError_shouldReturnBusinessException(){
        //Arrange
        when(vehicleRepository.getMotorcycles()).thenThrow(businessException);
        BusinessException exceptionExpected = null;

        try{
            //Act
            List<Motorcycle> result = parkingService.getMotorcycles();
        }catch (BusinessException e){
            exceptionExpected = e;
        }finally {
            //Assert
            assertNotNull(exceptionExpected);
        }


    }

}

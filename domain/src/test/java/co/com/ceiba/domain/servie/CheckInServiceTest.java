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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
    public void enterVehicle_enterCarWithSpaceInParking_shouldNotReturnError(){
        //Arrange
        when(vehicleRepository.getCarsNumber()).thenReturn(0);
        when(car.getLicensePlate()).thenReturn("ASD456");
        BusinessException exceptionExpected = null;

        try{
            //Act
            checkInService.enterVehicle(car);
        }catch (BusinessException e){
            exceptionExpected = e;
        }finally {
            //Assert
            assertNull(exceptionExpected);
        }
    }

    @Test
    public void enterVehicle_enterMotorcycleWithSpaceInParking_shouldNotReturnError(){
        //Arrange
        when(vehicleRepository.getMotorcyclesNumber()).thenReturn(0);
        BusinessException exceptionExpected = null;

        try {
            //Act
            checkInService.enterVehicle(motorcycle);
        }catch (BusinessException e){
            exceptionExpected = e;
        }finally {
            //Assert
            assertNull(exceptionExpected);
        }
    }

    @Test
    public void enterVehicle_enterCarNoSpaceInParking_shouldReturnBusinessException(){
        //Arrange
        when(vehicleRepository.getCarsNumber()).thenReturn(20);
        BusinessException exceptionExpected = null;

        try {
            //Act
            checkInService.enterVehicle(car);
        }catch (BusinessException e){
            exceptionExpected = e;
        }finally {
            //Assert
            assertNotNull(exceptionExpected);
        }

    }

    @Test
    public void enterVehicle_enterMotorcycleNoSpaceInParking_shouldReturnBusinessException(){
        //Arrange
        when(vehicleRepository.getMotorcyclesNumber()).thenReturn(10);
        BusinessException exceptionExpected = null;

        try {
            //Act
            checkInService.enterVehicle(motorcycle);
        }catch (BusinessException e){
            exceptionExpected = e;
        }finally {
            //Assert
            assertNotNull(exceptionExpected);
        }

    }
    
}

package co.com.ceiba.domain.repository;

import java.util.List;

import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;

public interface VehicleRepository {

    List<Car> getCars() throws BusinessException;

    List<Motorcycle> getMotorcycles() throws BusinessException;

    int getCarsNumber();

    int getMotorcyclesNumber();

    void takeOutCar(Car car);

    void enterCar(Car car);

    void takeOutMotorcycle(Motorcycle motorcycle);

    void enterMotorcycle(Motorcycle motorcycle);
}

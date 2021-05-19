package co.com.ceiba.domain.repository;

import java.text.ParseException;
import java.util.List;

import co.com.ceiba.domain.common.constant.VehicleType;
import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Vehicle;

public interface VehicleRepository {

    List<Vehicle> getVehiclesByType(VehicleType type) throws BusinessException;

    int getVehicleNumberByType(VehicleType type);

    void takeOutVehicle(Vehicle vehicle);

    void enterVehicle(Vehicle vehicle);
}

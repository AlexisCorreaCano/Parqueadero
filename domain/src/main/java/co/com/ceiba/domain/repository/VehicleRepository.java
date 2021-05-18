package co.com.ceiba.domain.repository;

import co.com.ceiba.domain.common.constant.VehicleType;
import co.com.ceiba.domain.model.Vehicle;

public interface VehicleRepository {

    int getVehiclesByType(VehicleType type);

    void takeOutVehicle(Vehicle vehicle);

    void enterVehicle(Vehicle vehicle);
}

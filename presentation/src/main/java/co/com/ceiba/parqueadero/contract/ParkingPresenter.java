package co.com.ceiba.parqueadero.contract;

import co.com.ceiba.domain.common.constant.VehicleType;
import co.com.ceiba.domain.model.Vehicle;

public interface ParkingPresenter {

    void addVehicle(Vehicle vehicle);
    void deleteVehicle();
    void listVehicles(VehicleType type);

}

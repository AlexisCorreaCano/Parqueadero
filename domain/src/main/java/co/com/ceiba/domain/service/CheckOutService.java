package co.com.ceiba.domain.service;

import co.com.ceiba.domain.Repository.VehicleRepository;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.domain.state.ChargeContext;
import co.com.ceiba.domain.state.ChargeState;

public class CheckOutService {

    private VehicleRepository vehicleRepository;

    private ChargeContext chargeContext;

    public CheckOutService(VehicleRepository vehicleRepository, ChargeContext chargeContext) {
        this.vehicleRepository = vehicleRepository;
        this.chargeContext = chargeContext;
    }

    public double takeOutVehicle(Vehicle vehicle){
        chargeContext.setContext(vehicle.getType());
        ChargeState chargeState = chargeContext.getContext();
        return chargeState.chargeToVehicle(vehicle);
    }
}

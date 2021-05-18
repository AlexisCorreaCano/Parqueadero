package co.com.ceiba.domain.service.checkout;

import javax.inject.Inject;

import co.com.ceiba.domain.repository.VehicleRepository;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.domain.service.checkout.state.ChargeContext;
import co.com.ceiba.domain.service.checkout.state.ChargeState;

public class CheckOutService {

    private final VehicleRepository vehicleRepository;
    private final ChargeContext chargeContext;

    @Inject
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

package co.com.ceiba.domain.state;

import co.com.ceiba.domain.model.Vehicle;

public class ChargeCar implements ChargeState {
    @Override
    public double chargeToVehicle(Vehicle vehicle) {
        return 0;
    }
}

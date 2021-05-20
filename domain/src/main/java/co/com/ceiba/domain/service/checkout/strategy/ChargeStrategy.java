package co.com.ceiba.domain.service.checkout.strategy;

import co.com.ceiba.domain.model.Vehicle;

public interface ChargeStrategy {
    double chargeToVehicle(Vehicle vehicle);
}

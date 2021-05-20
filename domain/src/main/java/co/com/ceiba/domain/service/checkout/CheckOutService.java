package co.com.ceiba.domain.service.checkout;

import javax.inject.Inject;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.repository.VehicleRepository;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.domain.service.checkout.strategy.ChargeCar;
import co.com.ceiba.domain.service.checkout.strategy.ChargeContext;
import co.com.ceiba.domain.service.checkout.strategy.ChargeMotorcycle;
import co.com.ceiba.domain.service.checkout.strategy.ChargeStrategy;

public class CheckOutService {

    private final VehicleRepository vehicleRepository;
    private final ChargeContext chargeContext;

    @Inject
    public CheckOutService(VehicleRepository vehicleRepository, ChargeContext chargeContext) {
        this.vehicleRepository = vehicleRepository;
        this.chargeContext = chargeContext;
    }

    public double takeOutVehicle(Vehicle vehicle){

        chargeContext.setStrategy(vehicle);
        ChargeStrategy chargeStrategy = chargeContext.getStrategy();

        if (chargeStrategy instanceof ChargeCar){
            vehicleRepository.takeOutCar((Car) vehicle);
        }

        if (chargeStrategy instanceof ChargeMotorcycle){
            vehicleRepository.takeOutMotorcycle((Motorcycle)vehicle);
        }

        return chargeStrategy.chargeToVehicle(vehicle);
    }
}

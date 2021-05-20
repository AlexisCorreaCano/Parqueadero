package co.com.ceiba.domain.service.checkout.strategy;

import javax.inject.Inject;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.model.Vehicle;

public class ChargeContext {

    private ChargeStrategy strategy;

    @Inject
    public ChargeContext() {
    }

    public ChargeStrategy getStrategy(){
        return strategy;
    }

    public void setStrategy(Vehicle vehicle) {
        if (vehicle instanceof Car){
            this.strategy = new ChargeCar();
        }
        if (vehicle instanceof Motorcycle){
            this.strategy = new ChargeMotorcycle();
        }

    }
}

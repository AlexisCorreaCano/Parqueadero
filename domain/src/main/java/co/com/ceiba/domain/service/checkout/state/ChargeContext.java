package co.com.ceiba.domain.service.checkout.state;

import javax.inject.Inject;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.model.Vehicle;

public class ChargeContext {

    private ChargeState state;

    @Inject
    public ChargeContext() {
    }

    public ChargeState getContext(){
        return state;
    }

    public void setContext(Vehicle vehicle) {
        if (vehicle instanceof Car){
            this.state = new ChargeCar();
        }
        if (vehicle instanceof Motorcycle){
            this.state = new ChargeMotorcycle();
        }

    }
}

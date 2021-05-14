package co.com.ceiba.domain.state;

import co.com.ceiba.domain.common.constant.VehicleType;

public class ChargeContext {

    private ChargeState state;

    public ChargeContext() {
    }

    public ChargeState getContext(){
        return state;
    }

    public void setContext(VehicleType vehicleType) {
        if (vehicleType.equals(VehicleType.CAR)){
            this.state = new ChargeCar();
        }
        if (vehicleType.equals(VehicleType.MOTORCYCLE)){
            this.state = new ChargeMotorcycle();
        }

    }
}

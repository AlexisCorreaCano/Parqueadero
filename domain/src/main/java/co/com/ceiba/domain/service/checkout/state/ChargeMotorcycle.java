package co.com.ceiba.domain.service.checkout.state;

import java.util.Date;

import co.com.ceiba.domain.common.constant.Constants;
import co.com.ceiba.domain.model.Vehicle;

public class ChargeMotorcycle implements ChargeState{
    @Override
    public double chargeToVehicle(Vehicle vehicle) {
        //TODO separar esta logica para que no se repita (horas)
        Date date = new Date();
        long milliseconds = vehicle.getCheckInDate().getTime()-date.getTime();

        long days = (milliseconds
                / (1000 * 60 * 60))
                / 24;

        long hours = (milliseconds
                / (1000 * 60 * 60))
                % 24;

        if (hours>8){
            days++;
            hours = 0;
        }

        double total = days * Constants.COTS_DAY_MOTORCYCLE + hours * Constants.COST_HOUR_MOTORCYCLE;

        if(vehicle.getCylinderCapacity() > 500){
            total = total+Constants.COTS_EXTRA_PRICE;
        }

        return total;
    }
}

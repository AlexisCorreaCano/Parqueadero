package co.com.ceiba.domain.service.checkout.strategy;

import java.util.Date;

import co.com.ceiba.domain.common.constant.Constants;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.model.Vehicle;

public class ChargeMotorcycle implements ChargeStrategy {
    @Override
    public double chargeToVehicle(Vehicle vehicle) {
        Date date = new Date();
        Date motorcycleDate = vehicle.getCheckInDate();
        long milliseconds = date.getTime() - motorcycleDate.getTime();
        
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

        if(((Motorcycle)vehicle).getCylinderCapacity() > 500){
            total = total+Constants.COTS_EXTRA_PRICE;
        }

        return total;
    }
}

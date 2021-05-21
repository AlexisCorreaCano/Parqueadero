package co.com.ceiba.domain.service.checkout.strategy;

import java.util.Date;

import co.com.ceiba.domain.common.constant.Constants;
import co.com.ceiba.domain.model.Vehicle;

public class ChargeCar implements ChargeStrategy {

    @Override
    public double chargeToVehicle(Vehicle vehicle) {
        Date date = new Date();
        Date carDate = vehicle.getCheckInDate();
        long milliseconds = date.getTime() - carDate.getTime();

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

        return days * Constants.COTS_DAY_CAR + hours * Constants.COST_HOUR_CAR;
    }


}

package co.com.ceiba.domain.service;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.repository.VehicleRepository;
import co.com.ceiba.domain.common.constant.Constants;
import co.com.ceiba.domain.common.constant.ErrorCode;
import co.com.ceiba.domain.common.constant.ErrorMessage;
import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Vehicle;

public class CheckInService {

    private final VehicleRepository vehicleRepository;
    private final Calendar calendar = Calendar.getInstance();

    @Inject
    public CheckInService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void enterVehicle(Vehicle vehicle) throws BusinessException {

        if (!thereIsCapacity(vehicle)){
            throw new BusinessException(ErrorMessage.MESSAGE_FULL_PARKING, ErrorCode.CODE_FULL_PARKING);
        }

        if (!entryIsAllowed(vehicle)){
            throw new BusinessException(ErrorMessage.MESSAGE_ENTRY_NOT_ALLOWED, ErrorCode.CODE_ENTRY_NOT_ALLOWED);
        }

        if(vehicle instanceof Car){
            vehicleRepository.enterCar((Car)vehicle);
        }

        if(vehicle instanceof Motorcycle){
            vehicleRepository.enterMotorcycle((Motorcycle) vehicle);
        }

    }

    //Todo validar que el vehiculo no este en el estacionamiento

    public boolean thereIsCapacity(Vehicle vehicle){

        boolean result = false;
        int numberVehicles = 0;

        if(vehicle instanceof Car){
            numberVehicles = vehicleRepository.getCarsNumber();
        }

        if(vehicle instanceof Motorcycle){
            numberVehicles = vehicleRepository.getMotorcyclesNumber();
        }


        if (vehicle instanceof Car && numberVehicles < Constants.NUMBER_CAR_CELLS){
            result = true;
        }

        if (vehicle instanceof Motorcycle && numberVehicles < Constants.NUMBER_MOTORCYCLE_CELLS)
        {
            result = true;
        }

        return result;
    }

    public boolean entryIsAllowed(Vehicle vehicle){

        if(vehicle instanceof Motorcycle){
            return true;
        }
        boolean result = true;
        Date date = new Date();
        calendar.setTime(date);
        String initialLetter = vehicle.getLicensePlate().substring(0,1);
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        if (day < 3 && initialLetter.equals(Constants.RESTRICTION_LATTER)){
            result = false;
        }

        return result;
    }

}

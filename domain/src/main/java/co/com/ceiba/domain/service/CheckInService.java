package co.com.ceiba.domain.service;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import co.com.ceiba.domain.repository.VehicleRepository;
import co.com.ceiba.domain.common.constant.Constants;
import co.com.ceiba.domain.common.constant.ErrorCode;
import co.com.ceiba.domain.common.constant.ErrorMessage;
import co.com.ceiba.domain.common.constant.VehicleType;
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

        if (!thereIsCapacity(vehicle.getType())){
            throw new BusinessException(ErrorMessage.MESSAGE_FULL_PARKING, ErrorCode.CODE_FULL_PARKING);
        }

        if (!entryIsAllowed(vehicle.getLicensePlate())){
            throw new BusinessException(ErrorMessage.MESSAGE_ENTRY_NOT_ALLOWED, ErrorCode.CODE_ENTRY_NOT_ALLOWED);
        }

        vehicleRepository.enterVehicle(vehicle);

    }

    //Todo validar que el vehiculo no este en el estacionamiento

    public boolean thereIsCapacity(VehicleType vehicleType){

        boolean result = false;
        int numberVehicles = vehicleRepository.getVehicleNumberByType(vehicleType);

        if (vehicleType.equals(VehicleType.CAR) && numberVehicles < Constants.NUMBER_CAR_CELLS){
            result = true;
        }

        if (vehicleType.equals(VehicleType.MOTORCYCLE) && numberVehicles < Constants.NUMBER_MOTORCYCLE_CELLS)
        {
            result = true;
        }

        return result;
    }

    public boolean entryIsAllowed(String licensePlate){

        boolean result = true;
        Date date = new Date();
        calendar.setTime(date);
        String initialLetter = licensePlate.substring(0,1);
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        if (day < 3 && initialLetter.equals(Constants.RESTRICTION_LATTER)){
            result = false;
        }

        return result;
    }

}

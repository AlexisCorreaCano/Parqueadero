package co.com.ceiba.domain.service;

import co.com.ceiba.domain.Repository.VehicleRepository;
import co.com.ceiba.domain.common.constant.ErrorCode;
import co.com.ceiba.domain.common.constant.ErrorMessage;
import co.com.ceiba.domain.common.constant.VehicleType;
import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Vehicle;

public class CheckInService {

    private VehicleRepository vehicleRepository;

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
        return false;
    }

    public boolean entryIsAllowed(String licensePlate){
        return false;
    }

}

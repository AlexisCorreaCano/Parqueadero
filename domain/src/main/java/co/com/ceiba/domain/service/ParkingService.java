package co.com.ceiba.domain.service;

import android.os.AsyncTask;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.common.constant.VehicleType;
import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.domain.repository.VehicleRepository;

public class ParkingService {
    private final VehicleRepository vehicleRepository;
    List<Vehicle> vehicles;
    @Inject
    public ParkingService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicles(VehicleType type) throws BusinessException {
        return vehicleRepository.getVehiclesByType(VehicleType.CAR);
    }


}

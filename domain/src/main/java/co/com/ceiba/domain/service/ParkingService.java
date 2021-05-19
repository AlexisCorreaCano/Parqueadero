package co.com.ceiba.domain.service;

import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.domain.repository.VehicleRepository;

public class ParkingService {
    private final VehicleRepository vehicleRepository;
    List<Vehicle> vehicles;
    @Inject
    public ParkingService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Car> getCars() throws BusinessException {
        return vehicleRepository.getCars();
    }

    public List<Motorcycle> getMotorcycles() throws BusinessException {
        return vehicleRepository.getMotorcycles();
    }


}

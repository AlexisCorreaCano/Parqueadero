package co.com.ceiba.domain.service;

import javax.inject.Inject;

import co.com.ceiba.domain.repository.VehicleRepository;

public class GetVehiclesService {
    private final VehicleRepository vehicleRepository;

    @Inject
    public GetVehiclesService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

}

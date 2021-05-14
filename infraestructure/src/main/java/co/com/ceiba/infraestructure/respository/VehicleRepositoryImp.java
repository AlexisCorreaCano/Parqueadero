package co.com.ceiba.infraestructure.respository;


import co.com.ceiba.domain.Repository.VehicleRepository;
import co.com.ceiba.domain.common.VehicleType;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.infraestructure.respository.DAO.VehicleDAO;

public class VehicleRepositoryImp implements VehicleRepository {

    private VehicleDAO vehicleDAO;

    public VehicleRepositoryImp(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    @Override
    public int getVehiclesByType(VehicleType type) {
        return vehicleDAO.getVehiclesByType(type);
    }

    @Override
    public void takeOutVehicle(Vehicle vehicle) {
        vehicleDAO.deleteVehicle(vehicle);
    }

    @Override
    public void enterVehicle(Vehicle vehicle) {
        vehicleDAO.insertVehicle(vehicles);
    }
}

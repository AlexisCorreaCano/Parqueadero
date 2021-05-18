package co.com.ceiba.infraestructure.respository;

import co.com.ceiba.infraestructure.respository.dao.VehicleDAO;

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
        vehicleDAO.insertVehicle(vehicle);
    }

}

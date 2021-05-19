package co.com.ceiba.infraestructure.respository;

import android.os.AsyncTask;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.common.constant.VehicleType;
import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.domain.repository.VehicleRepository;
import co.com.ceiba.infraestructure.respository.anticorruption.VehicleTranslator;
import co.com.ceiba.infraestructure.respository.dao.VehicleDAO;
import co.com.ceiba.infraestructure.respository.entity.VehicleEntity;

public class VehicleRepositoryRoom implements VehicleRepository {

    private VehicleDAO vehicleDAO;
    private VehicleTranslator translator = new VehicleTranslator();

    @Inject
    public VehicleRepositoryRoom(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    @Override
    public List<Vehicle> getVehiclesByType(VehicleType type) throws BusinessException {
        List<VehicleEntity> vehicleEntities =  vehicleDAO.getVehiclesByType(type);
        return translator.fromListEntityToListDomain(vehicleEntities);
    }

    @Override
    public int getVehicleNumberByType(VehicleType type) {
        return 0;
    }

    @Override
    public void takeOutVehicle(Vehicle vehicle) {

        vehicleDAO.deleteVehicle(translator.fromDomainToEntity(vehicle));
    }

    @Override
    public void enterVehicle(Vehicle vehicle) {

        vehicleDAO.insertVehicle(translator.fromDomainToEntity(vehicle));

    }

}

package co.com.ceiba.infraestructure.respository.anticorruption;

import androidx.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.infraestructure.respository.entity.VehicleEntity;

public class VehicleTranslator {

    public VehicleEntity fromDomainToEntity(Vehicle vehicle){
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.checkInDate = dateToTimestamp(vehicle.getCheckInDate());
        vehicleEntity.cylinderCapacity = vehicle.getCylinderCapacity();
        vehicleEntity.licensePlate = vehicle.getLicensePlate();
        vehicleEntity.type = vehicle.getType();

        return vehicleEntity;
    }

    public Vehicle fromEntityToDomain(VehicleEntity vehicleEntity) throws BusinessException {
        Vehicle vehicle = new Vehicle(vehicleEntity.licensePlate,
                vehicleEntity.cylinderCapacity,
                vehicleEntity.type,
                fromTimestamp(vehicleEntity.checkInDate));

        return vehicle;
    }

    public List<Vehicle> fromListEntityToListDomain(List<VehicleEntity> vehicleEntities) throws BusinessException {
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < vehicleEntities.size(); i++) {
            vehicles.add( new Vehicle(vehicleEntities.get(i).licensePlate,
                    vehicleEntities.get(i).cylinderCapacity,
                    vehicleEntities.get(i).type,
                    fromTimestamp(vehicleEntities.get(i).checkInDate)));
        }
        return vehicles;
    }

    @TypeConverter
    public Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();

    }

}

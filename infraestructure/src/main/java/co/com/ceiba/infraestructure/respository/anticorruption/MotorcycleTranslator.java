package co.com.ceiba.infraestructure.respository.anticorruption;

import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.infraestructure.respository.entity.MotorcycleEntity;

public class MotorcycleTranslator {

    @Inject
    public MotorcycleTranslator() {
    }

    public MotorcycleEntity fromDomainToEntity(Motorcycle motorcycle){
        MotorcycleEntity motorcycleEntity = new MotorcycleEntity();
        motorcycleEntity.checkInDate = dateToTimestamp(motorcycle.getCheckInDate());
        motorcycleEntity.cylinderCapacity = motorcycle.getCylinderCapacity();
        motorcycleEntity.licensePlate = motorcycle.getLicensePlate();

        return motorcycleEntity;
    }

    public List<Motorcycle> fromListEntityToListDomain(List<MotorcycleEntity> motorcycleEntities) {
        List<Motorcycle> motorcycles = new ArrayList<>();
        for (int i = 0; i < motorcycleEntities.size(); i++) {
            motorcycles.add( new Motorcycle(motorcycleEntities.get(i).licensePlate,
                    fromTimestamp(motorcycleEntities.get(i).checkInDate),
                    motorcycleEntities.get(i).cylinderCapacity));
        }
        return motorcycles;
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

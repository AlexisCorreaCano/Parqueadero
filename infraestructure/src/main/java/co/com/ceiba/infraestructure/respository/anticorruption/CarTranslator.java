package co.com.ceiba.infraestructure.respository.anticorruption;

import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Car;
import co.com.ceiba.infraestructure.respository.entity.CarEntity;

public class CarTranslator {

    @Inject
    public CarTranslator() {
    }

    public CarEntity fromDomainToEntity(Car car){
        CarEntity carEntity = new CarEntity();
        carEntity.checkInDate = dateToTimestamp(car.getCheckInDate());
        carEntity.licensePlate = car.getLicensePlate();
        return carEntity;
    }

    public Car fromEntityToDomain(CarEntity carEntity) throws BusinessException {
        Car car = new Car(carEntity.licensePlate,
                fromTimestamp(carEntity.checkInDate));

        return car;
    }

    public List<Car> fromListEntityToListDomain(List<CarEntity> carEntities) throws BusinessException {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carEntities.size(); i++) {
            cars.add( new Car(carEntities.get(i).licensePlate,
                    fromTimestamp(carEntities.get(i).checkInDate)));
        }
        return cars;
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

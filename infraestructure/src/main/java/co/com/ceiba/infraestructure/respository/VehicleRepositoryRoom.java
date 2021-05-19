package co.com.ceiba.infraestructure.respository;

import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.domain.repository.VehicleRepository;
import co.com.ceiba.infraestructure.respository.anticorruption.CarTranslator;
import co.com.ceiba.infraestructure.respository.anticorruption.MotorcycleTranslator;
import co.com.ceiba.infraestructure.respository.dao.CarDao;
import co.com.ceiba.infraestructure.respository.dao.MotorcycleDao;
import co.com.ceiba.infraestructure.respository.entity.CarEntity;
import co.com.ceiba.infraestructure.respository.entity.MotorcycleEntity;

public class VehicleRepositoryRoom implements VehicleRepository {

    private MotorcycleDao motorcycleDao;
    private CarDao carDao;
    private final CarTranslator carTranslator;
    private final MotorcycleTranslator motorcycleTranslator;

    @Inject
    public VehicleRepositoryRoom(MotorcycleDao motorcycleDao,
                                 CarDao carDao,
                                 CarTranslator carTranslator,
                                 MotorcycleTranslator motorcycleTranslator) {
        this.motorcycleDao = motorcycleDao;
        this.carDao = carDao;
        this.carTranslator = carTranslator;
        this.motorcycleTranslator = motorcycleTranslator;
    }

    @Override
    public List<Car> getCars() throws BusinessException {
        List<CarEntity> cars = carDao.getCars();
        return carTranslator.fromListEntityToListDomain(cars);
    }

    @Override
    public List<Motorcycle> getMotorcycles() throws BusinessException {
        List<MotorcycleEntity> motorcycles = motorcycleDao.getMotorcycles();
        return motorcycleTranslator.fromListEntityToListDomain(motorcycles);
    }

    @Override
    public int getCarsNumber() {
        return carDao.getCarNumber();
    }

    @Override
    public int getMotorcyclesNumber() {
        return motorcycleDao.getMotorcycleNumber();
    }

    @Override
    public void takeOutCar(Car car) {
        carDao.deleteCar(carTranslator.fromDomainToEntity(car));
    }

    @Override
    public void enterCar(Car car) {
        carDao.insertCar(carTranslator.fromDomainToEntity(car));
    }

    @Override
    public void takeOutMotorcycle(Motorcycle motorcycle) {
        motorcycleDao.deleteMotorcycle(motorcycleTranslator.fromDomainToEntity(motorcycle));
    }

    @Override
    public void enterMotorcycle(Motorcycle motorcycle) {
        motorcycleDao.insertMotorcycle(motorcycleTranslator.fromDomainToEntity(motorcycle));
    }
}

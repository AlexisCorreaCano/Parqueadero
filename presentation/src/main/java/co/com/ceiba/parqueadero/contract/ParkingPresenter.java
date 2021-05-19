package co.com.ceiba.parqueadero.contract;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.model.Vehicle;

public interface ParkingPresenter {

    void addCar(Car vehicle);
    void deleteCar(Car vehicle);
    void addMotorcycle(Motorcycle vehicle);
    void deleteMotorcycle(Motorcycle vehicle);
    void listCars();
    void listMotorcycles();
    void setCarView(CarView view);
    void setMotorcycleView(MotorcycleView view);

}

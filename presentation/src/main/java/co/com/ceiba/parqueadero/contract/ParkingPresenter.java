package co.com.ceiba.parqueadero.contract;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.model.Vehicle;

public interface ParkingPresenter {

    void addCar(String licensePlate);
    void deleteCar(Car vehicle);
    void addMotorcycle(String licensePlate,int cylinderCapacity);
    void deleteMotorcycle(Motorcycle vehicle);
    void listCars();
    void listMotorcycles();
    void setCarView(CarView view);
    void setMotorcycleView(MotorcycleView view);

}

package co.com.ceiba.parqueadero.presenter;

import android.os.AsyncTask;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.domain.service.CheckInService;
import co.com.ceiba.domain.service.ParkingService;
import co.com.ceiba.domain.service.checkout.CheckOutService;
import co.com.ceiba.parqueadero.contract.CarView;
import co.com.ceiba.parqueadero.contract.MotorcycleView;
import co.com.ceiba.parqueadero.contract.ParkingPresenter;

public class ParkingPresenterImp implements ParkingPresenter {

    private CarView carView;
    private MotorcycleView motorcycleView;
    private final CheckOutService checkOutService;
    private final CheckInService checkInService;
    private final ParkingService parkingService;

    private List<Vehicle> vehicles;

    @Inject
    public ParkingPresenterImp(CheckOutService checkOutService,
                               CheckInService checkInService,
                               ParkingService parkingService){
        this.checkOutService = checkOutService;
        this.checkInService = checkInService;
        this.parkingService = parkingService;
    }

    @Override
    public void setCarView(CarView carView){
        this.carView = carView;
    }

    @Override
    public void setMotorcycleView(MotorcycleView motorcycleView) {
        this.motorcycleView = motorcycleView;
    }


    @Override
    public void addCar(String licensePlate) {
        carView.showLoading();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Car vehicle =new Car(licensePlate,new Date());
                    checkInService.enterVehicle(vehicle);
                } catch (BusinessException e) {
                   carView.showAlert(e.getMessage());
                }
                carView.hideLoading();
            }
        });
    }

    @Override
    public void deleteCar(Car vehicle) {
        carView.showLoading();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                double total = checkOutService.takeOutVehicle(vehicle);
                carView.showAlert("Total a pagar "+total);
                carView.hideLoading();
            }
        });
    }

    @Override
    public void addMotorcycle(String licensePlate,int cylinderCapacity) {
        motorcycleView.showLoading();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Motorcycle vehicle  = new Motorcycle(licensePlate,new Date(),cylinderCapacity);
                    checkInService.enterVehicle(vehicle);
                } catch (BusinessException e) {
                    motorcycleView.showAlert(e.getMessage());
                }
                motorcycleView.hideLoading();
            }
        });
    }

    @Override
    public void deleteMotorcycle(Motorcycle vehicle) {
        motorcycleView.showLoading();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                double total = checkOutService.takeOutVehicle(vehicle);
                motorcycleView.showAlert("Total a pagar: "+total);
                motorcycleView.hideLoading();
            }
        });
    }

    @Override
    public void listCars() {
        carView.showLoading();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Car> cars = parkingService.getCars();
                    carView.showCars(cars);
                } catch (BusinessException e) {
                    carView.showAlert(e.getMessage());
                }
                carView.hideLoading();
            }
        });
    }

    @Override
    public void listMotorcycles() {
        motorcycleView.showLoading();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Motorcycle> motorcycles = parkingService.getMotorcycles();
                    motorcycleView.showMotorcycle(motorcycles);
                } catch (BusinessException e) {
                    motorcycleView.showAlert(e.getMessage());
                }
                motorcycleView.hideLoading();
            }
        });
    }

}

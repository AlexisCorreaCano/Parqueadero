package co.com.ceiba.parqueadero.presenter;

import android.os.AsyncTask;

import java.text.ParseException;

import javax.inject.Inject;

import co.com.ceiba.domain.common.constant.VehicleType;
import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.domain.service.CheckInService;
import co.com.ceiba.domain.service.ParkingService;
import co.com.ceiba.domain.service.checkout.CheckOutService;
import co.com.ceiba.parqueadero.contract.GenericView;
import co.com.ceiba.parqueadero.contract.ParkingPresenter;

public class ParkingPresenterImp implements ParkingPresenter {

    private final GenericView view;
    private final CheckOutService checkOutService;
    private final CheckInService checkInService;
    private final ParkingService parkingService;

    @Inject
    public ParkingPresenterImp(GenericView view,
                               CheckOutService checkOutService,
                               CheckInService checkInService,
                               ParkingService parkingService){
        this.view = view;
        this.checkOutService = checkOutService;
        this.checkInService = checkInService;
        this.parkingService = parkingService;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    checkInService.enterVehicle(vehicle);
                } catch (BusinessException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void deleteVehicle() {

    }

    @Override
    public void listVehicles(VehicleType type) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    view.showVehicles(parkingService.getVehicles(type));
                } catch (BusinessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

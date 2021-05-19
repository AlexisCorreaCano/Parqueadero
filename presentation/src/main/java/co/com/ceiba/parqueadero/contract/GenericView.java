package co.com.ceiba.parqueadero.contract;

import java.util.List;

import co.com.ceiba.domain.model.Vehicle;

public interface GenericView {

    void showLoading();
    void hideLoading();
    void showVehicles(List<Vehicle> vehicles);

}

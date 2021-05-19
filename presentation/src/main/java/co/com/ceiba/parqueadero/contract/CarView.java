package co.com.ceiba.parqueadero.contract;

import java.util.List;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;

public interface GenericView {

    void showLoading();
    void hideLoading();
    void showCars(List<Car> cars);
    void showMotorcycle(List<Motorcycle> motorcycles);

}

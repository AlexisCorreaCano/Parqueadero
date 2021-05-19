package co.com.ceiba.parqueadero.contract;

import java.util.List;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Motorcycle;

public interface CarView {

    void showLoading();
    void hideLoading();
    void showCars(List<Car> cars);
    void deleteCar(int position);
    void showTotal(double total);

}

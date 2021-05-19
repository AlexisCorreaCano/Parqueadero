package co.com.ceiba.parqueadero.contract;

import java.util.List;

import co.com.ceiba.domain.model.Motorcycle;

public interface MotorcycleView {
    void showLoading();
    void hideLoading();
    void showMotorcycle(List<Motorcycle> motorcycles);
    void deleteMotorcycle(int position);
    void showTotal(double total);
}

package co.com.ceiba.parqueadero.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.common.constant.VehicleType;
import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.parqueadero.dependencyInjection.ParkingApplication;
import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.contract.GenericView;
import co.com.ceiba.parqueadero.contract.ParkingPresenter;

public class CarFragment extends Fragment implements GenericView {

    @Inject
    ParkingPresenter parkingPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ParkingApplication) getActivity().getApplicationContext()).getApplicationComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        parkingPresenter.listVehicles(VehicleType.CAR);


        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Vehicle vehicle = new Vehicle("ASD987",1200, VehicleType.CAR,new Date());
                    parkingPresenter.addVehicle(vehicle);
                } catch (BusinessException e) {
                    e.printStackTrace();
                }

            }
        });


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showVehicles(List<Vehicle> vehicles) {
        List<Vehicle> vehicles1 = vehicles;

    }
}
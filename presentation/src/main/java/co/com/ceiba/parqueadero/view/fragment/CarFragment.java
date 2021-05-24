package co.com.ceiba.parqueadero.view.fragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Car;
import co.com.ceiba.parqueadero.dependencyInjection.ParkingApplication;
import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.contract.CarView;
import co.com.ceiba.parqueadero.contract.ParkingPresenter;
import co.com.ceiba.parqueadero.view.adapter.CarAdapter;

public class CarFragment extends Fragment implements CarView {

    @Inject
    ParkingPresenter parkingPresenter;

    private List<Car> cars = new ArrayList<>();
    private CarAdapter adapter;

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private EditText txtLicensePlace;
    private ProgressBar prg_car;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((ParkingApplication) getActivity().getApplicationContext()).getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        parkingPresenter.setCarView(this);
        setUpViews(view);
        addEvents();

    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        parkingPresenter.listCars();
    }

    private void setUpViews(View view) {
        fab = view.findViewById(R.id.fab);
        recyclerView = view.findViewById(R.id.rv_cars);
        txtLicensePlace = view.findViewById(R.id.txt_license_plate_car);
        prg_car = view.findViewById(R.id.prg_car);
    }

    private void addEvents() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String licensePlate = txtLicensePlace.getText().toString();
                parkingPresenter.addCar(licensePlate);
                txtLicensePlace.setText("");
                loadData();

            }
        });
    }

    @Override
    public void showLoading() {
        prg_car.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                prg_car.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void showCars(List<Car> cars) {
        this.cars = cars;

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter = new CarAdapter(cars);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adapter);
                
                recyclerViewConfig();

            }
        });
    }

    @Override
    public void deleteCar(int position) {
        cars.remove(position);

        adapter.notifyItemRemoved(position);
    }

    @Override
    public void showAlert(String message) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                builder1.setMessage(message);
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });


    }

    private void recyclerViewConfig() {

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(createHelperCallback());
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private ItemTouchHelper.Callback createHelperCallback() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                parkingPresenter.deleteCar(cars.get(position));
            }
        };

        return simpleItemTouchCallback;
    }

}
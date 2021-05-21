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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.common.exception.BusinessException;
import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.contract.MotorcycleView;
import co.com.ceiba.parqueadero.contract.ParkingPresenter;
import co.com.ceiba.parqueadero.dependencyInjection.ParkingApplication;
import co.com.ceiba.parqueadero.view.adapter.MotorcycleAdapter;

public class MotorcycleFragment extends Fragment implements MotorcycleView {

    @Inject
    ParkingPresenter parkingPresenter;

    private List<Motorcycle> motorcycles = new ArrayList<>();
    private MotorcycleAdapter adapter;

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private EditText txtLicensePlate;
    private EditText txtCylinderCapacity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((ParkingApplication) getActivity().getApplicationContext()).getApplicationComponent().inject(this);
        return inflater.inflate(R.layout.fragment_motorcycle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        parkingPresenter.setMotorcycleView(this);
        setUpViews(view);
        addEvents();


    }

    private void loadData() {
        parkingPresenter.listMotorcycles();
    }

    private void setUpViews(View view) {
        fab = view.findViewById(R.id.fab_motorcycle);
        recyclerView = view.findViewById(R.id.rv_motorcycle);
        txtLicensePlate = view.findViewById(R.id.txt_license_plate);
        txtCylinderCapacity = view.findViewById(R.id.txt_cylinder_capacity);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void addEvents() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String licensePlate = txtLicensePlate.getText().toString();
                String cylinderCapacity = txtCylinderCapacity.getText().toString();
                if(cylinderCapacity.isEmpty()){
                    cylinderCapacity = "0";
                }
                parkingPresenter.addMotorcycle(licensePlate,Integer.parseInt(cylinderCapacity));
                txtCylinderCapacity.setText("");
                txtLicensePlate.setText("");
                loadData();

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
    public void showMotorcycle(List<Motorcycle> motorcycles) {
        this.motorcycles = motorcycles;

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter = new MotorcycleAdapter(motorcycles);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adapter);

                recyclerViewConfig();
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
                parkingPresenter.deleteMotorcycle(motorcycles.get(position));
            }
        };

        return simpleItemTouchCallback;
    }

    @Override
    public void deleteMotorcycle(int position) {
        motorcycles.remove(position);

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


}
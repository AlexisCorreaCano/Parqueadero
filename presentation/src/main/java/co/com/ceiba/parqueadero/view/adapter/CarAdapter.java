package co.com.ceiba.parqueadero.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.com.ceiba.domain.model.Car;
import co.com.ceiba.domain.model.Vehicle;
import co.com.ceiba.parqueadero.R;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder>{

    private List<Car> cars;

    public CarAdapter(List<Car> cars) {
        this.cars = cars;
    }

    @NonNull
    @Override
    public CarAdapter.CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.CarViewHolder holder, int position) {
        holder.lblLicensePlate.setText(cars.get(position).getLicensePlate());
        holder.lblCheckInDate.setText(cars.get(position).getCheckInDate().toString());
        holder.lblCylinderCapacity.setText("");
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {

        private final TextView lblLicensePlate;
        private final TextView lblCheckInDate;
        private final TextView lblCylinderCapacity;

        public CarViewHolder(View view) {

            super(view);

            lblLicensePlate = view.findViewById(R.id.lbl_license_plate);
            lblCheckInDate = view.findViewById(R.id.lbl_check_in_date);
            lblCylinderCapacity = view.findViewById(R.id.lbl_cylinder_capacity);
        }

    }
}

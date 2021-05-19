package co.com.ceiba.parqueadero.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.com.ceiba.domain.model.Motorcycle;
import co.com.ceiba.parqueadero.R;

public class MotorcycleAdapter extends RecyclerView.Adapter<MotorcycleAdapter.MotorcycleViewHolder>{

    private List<Motorcycle> motorcycles;

    public MotorcycleAdapter(List<Motorcycle> motorcycles) {
        this.motorcycles = motorcycles;
    }

    @NonNull
    @Override
    public MotorcycleAdapter.MotorcycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new MotorcycleAdapter.MotorcycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MotorcycleAdapter.MotorcycleViewHolder holder, int position) {
        holder.lblLicensePlate.setText(motorcycles.get(position).getLicensePlate());
        holder.lblCheckInDate.setText(motorcycles.get(position).getCheckInDate().toString());
        holder.lblCylinderCapacity.setText(motorcycles.get(position).getCylinderCapacity()+"");
    }

    @Override
    public int getItemCount() {
        return motorcycles.size();
    }

    public static class MotorcycleViewHolder extends RecyclerView.ViewHolder {

        private final TextView lblLicensePlate;
        private final TextView lblCheckInDate;
        private final TextView lblCylinderCapacity;

        public MotorcycleViewHolder(View view) {

            super(view);

            lblLicensePlate = view.findViewById(R.id.lbl_license_plate);
            lblCheckInDate = view.findViewById(R.id.lbl_check_in_date);
            lblCylinderCapacity = view.findViewById(R.id.lbl_cylinder_capacity);
        }
    }
}

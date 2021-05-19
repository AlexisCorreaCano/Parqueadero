package co.com.ceiba.parqueadero.view.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MotorcycleAdapter extends RecyclerView.Adapter<MotorcycleAdapter.MotorcycleViewHolder>{

    @NonNull
    @Override
    public MotorcycleAdapter.MotorcycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MotorcycleAdapter.MotorcycleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MotorcycleViewHolder extends RecyclerView.ViewHolder {

        public MotorcycleViewHolder(View view) {
            super(view);
        }
    }
}

package co.com.ceiba.infraestructure.respository.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import co.com.ceiba.domain.common.VehicleType;
import co.com.ceiba.domain.model.Vehicle;

@Dao
public interface VehicleDAO {

    @Query("SELECT COUNT(*) FROM VehicleEntity WHERE type == :type")
    int getVehiclesByType(VehicleType type);

    @Delete
    void deleteVehicle(Vehicle vehicle);

    @Insert
    void insertVehicle(Vehicle vehicle);
}

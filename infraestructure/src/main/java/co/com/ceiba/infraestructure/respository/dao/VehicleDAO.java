package co.com.ceiba.infraestructure.respository.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.com.ceiba.domain.common.constant.VehicleType;
import co.com.ceiba.infraestructure.respository.entity.VehicleEntity;

@Dao
public interface VehicleDAO {

    @Query("SELECT * FROM VehicleEntity WHERE type == :type")
    List<VehicleEntity> getVehiclesByType(VehicleType type);

    @Query("SELECT COUNT(*) FROM VehicleEntity WHERE type == :type")
    int getVehiclesNumberByType(VehicleType type);

    @Delete
    void deleteVehicle(VehicleEntity vehicle);

    @Insert
    void insertVehicle(VehicleEntity vehicle);
}

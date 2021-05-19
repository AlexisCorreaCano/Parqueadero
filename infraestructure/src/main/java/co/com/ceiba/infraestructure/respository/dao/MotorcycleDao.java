package co.com.ceiba.infraestructure.respository.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import co.com.ceiba.infraestructure.respository.entity.MotorcycleEntity;

@Dao
public interface MotorcycleDao {
    @Query("SELECT * FROM MotorcycleEntity")
    List<MotorcycleEntity> getMotorcycles();

    @Query("SELECT COUNT(*) FROM MotorcycleEntity")
    int getMotorcycleNumber();

    @Delete
    void deleteMotorcycle(MotorcycleEntity vehicle);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMotorcycle(MotorcycleEntity vehicle);
}

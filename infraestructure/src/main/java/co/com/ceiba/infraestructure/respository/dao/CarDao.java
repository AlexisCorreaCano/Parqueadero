package co.com.ceiba.infraestructure.respository.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import co.com.ceiba.infraestructure.respository.entity.CarEntity;

@Dao
public interface CarDao {

    @Query("SELECT * FROM CarEntity")
    List<CarEntity> getCars();

    @Query("SELECT COUNT(*) FROM CarEntity ")
    int getCarNumber();

    @Delete
    void deleteCar(CarEntity vehicle);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCar(CarEntity vehicle);
}

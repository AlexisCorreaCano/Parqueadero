package co.com.ceiba.infraestructure.respository.config;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import co.com.ceiba.infraestructure.respository.dao.VehicleDAO;
import co.com.ceiba.infraestructure.respository.entity.VehicleEntity;

@Database(entities = {VehicleEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VehicleDAO vehicleDAO();
}

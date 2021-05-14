package co.com.ceiba.infraestructure.respository.config;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import co.com.ceiba.infraestructure.respository.DAO.VehicleDAO;
import co.com.ceiba.infraestructure.respository.Entity.VehicleEntity;

@Database(entities = {VehicleEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VehicleDAO vehicleDAO();
}

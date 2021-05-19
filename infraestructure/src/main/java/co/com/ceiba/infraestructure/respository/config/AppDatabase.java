package co.com.ceiba.infraestructure.respository.config;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import co.com.ceiba.infraestructure.respository.dao.CarDao;
import co.com.ceiba.infraestructure.respository.dao.MotorcycleDao;
import co.com.ceiba.infraestructure.respository.entity.CarEntity;
import co.com.ceiba.infraestructure.respository.entity.MotorcycleEntity;

@Database(entities = {CarEntity.class, MotorcycleEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CarDao carDao();
    public abstract MotorcycleDao motorcycleDao();
}

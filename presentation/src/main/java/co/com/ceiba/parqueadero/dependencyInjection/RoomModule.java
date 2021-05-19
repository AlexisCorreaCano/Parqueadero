package co.com.ceiba.parqueadero.dependencyInjection;

import android.app.Application;

import androidx.room.Room;

import javax.inject.Singleton;

import co.com.ceiba.domain.repository.VehicleRepository;
import co.com.ceiba.infraestructure.respository.VehicleRepositoryRoom;
import co.com.ceiba.infraestructure.respository.anticorruption.CarTranslator;
import co.com.ceiba.infraestructure.respository.anticorruption.MotorcycleTranslator;
import co.com.ceiba.infraestructure.respository.config.AppDatabase;
import co.com.ceiba.infraestructure.respository.dao.CarDao;
import co.com.ceiba.infraestructure.respository.dao.MotorcycleDao;
import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {


    private final AppDatabase database;

    public RoomModule(Application application) {
        this.database = Room.databaseBuilder(application,AppDatabase.class,"parking.db")
                .build();
    }

    @Provides
    @Singleton
    VehicleRepository provideVehicleRepository(MotorcycleDao motorcycleDao,
                                               CarDao carDao,
                                               CarTranslator carTranslator,
                                               MotorcycleTranslator motorcycleTranslator){
        return new VehicleRepositoryRoom(motorcycleDao,carDao,carTranslator,motorcycleTranslator);
    }

    @Provides
    @Singleton
    CarDao provideCarDao(AppDatabase database){
        return database.carDao();
    }

    @Provides
    @Singleton
    MotorcycleDao provideMotorcycleDao(AppDatabase database){
        return database.motorcycleDao();
    }

    @Provides
    @Singleton
    AppDatabase provideListItemDatabase(Application application){
        return database;
    }
}

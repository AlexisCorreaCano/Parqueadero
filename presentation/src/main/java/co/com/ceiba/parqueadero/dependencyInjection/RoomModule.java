package co.com.ceiba.parqueadero.dependencyInjection;

import android.app.Application;

import androidx.room.Room;

import javax.inject.Singleton;

import co.com.ceiba.domain.repository.VehicleRepository;
import co.com.ceiba.infraestructure.respository.VehicleRepositoryRoom;
import co.com.ceiba.infraestructure.respository.config.AppDatabase;
import co.com.ceiba.infraestructure.respository.dao.VehicleDAO;
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
    VehicleRepository provideListItemRepository(VehicleDAO vehicleDAO){
        return new VehicleRepositoryRoom(vehicleDAO);
    }

    @Provides
    @Singleton
    VehicleDAO provideListItemDao(AppDatabase database){
        return database.vehicleDAO();
    }

    @Provides
    @Singleton
    AppDatabase provideListItemDatabase(Application application){
        return database;
    }
}

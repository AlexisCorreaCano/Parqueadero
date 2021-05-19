package co.com.ceiba.parqueadero.dependencyInjection;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final ParkingApplication application;

    public ApplicationModule(ParkingApplication application) {
        this.application = application;
    }

    @Provides
    ParkingApplication provideRoomDemoApplication(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }
}

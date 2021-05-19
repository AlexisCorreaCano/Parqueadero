package co.com.ceiba.parqueadero.dependencyInjection;


import android.app.Application;

public class ParkingApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return this.applicationComponent;
    }
}

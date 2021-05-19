package co.com.ceiba.parqueadero.dependencyInjection;

import javax.inject.Singleton;

import co.com.ceiba.parqueadero.view.fragment.CarFragment;
import dagger.Component;

@Singleton
@Component(modules = {
        ContextModule.class,
        PresenterModule.class,
        ViewModule.class,
        RoomModule.class,
        ApplicationModule.class
})
public interface ApplicationComponent {
    void inject(CarFragment carFragment);
}

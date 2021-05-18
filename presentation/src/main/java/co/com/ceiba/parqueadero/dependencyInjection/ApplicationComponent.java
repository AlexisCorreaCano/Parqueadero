package co.com.ceiba.parqueadero.DI;

import javax.inject.Singleton;

import co.com.ceiba.parqueadero.view.activity.MainActivity;
import co.com.ceiba.parqueadero.view.fragment.CarFragment;
import dagger.Component;

@Singleton
@Component(modules = {
        ContextModule.class,
        PresenterModule.class
})
public interface ApplicationComponent {
    void inject(CarFragment carFragment);
}

package co.com.ceiba.parqueadero.dependencyInjection;

import co.com.ceiba.parqueadero.contract.GenericView;
import co.com.ceiba.parqueadero.view.fragment.CarFragment;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {

    @Provides
    public GenericView getGenericView(){
        return new CarFragment();
    }

}

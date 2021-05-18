package co.com.ceiba.parqueadero.DI;

import co.com.ceiba.parqueadero.contract.ParkingPresenter;
import co.com.ceiba.parqueadero.presenter.ParkingPresenterImp;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class PresenterModule {
    @Binds
    public abstract ParkingPresenter bindParkingPresenter(ParkingPresenterImp presenterImp);
}

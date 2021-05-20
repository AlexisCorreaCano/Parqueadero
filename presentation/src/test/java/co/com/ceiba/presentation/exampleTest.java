package co.com.ceiba.presentation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import co.com.ceiba.parqueadero.presenter.ParkingPresenterImp;

@RunWith(JUnit4.class)
public class exampleTest {
    @Test
    public void afa(){
        ParkingPresenterImp parkingPresenterImp = new ParkingPresenterImp(null,null,null);
        parkingPresenterImp.setCarView(null);
    }
}

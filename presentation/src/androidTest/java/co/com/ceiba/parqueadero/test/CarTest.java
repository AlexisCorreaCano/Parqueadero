package co.com.ceiba.parqueadero.test;

import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.com.ceiba.parqueadero.pages.CarPage;
import co.com.ceiba.parqueadero.view.activity.MainActivity;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class CarTest {

    private CarPage carPage;

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp(){
        carPage = new CarPage();
    }


    @Test
    public void addCar_addCarWithLicensePlateOK_shouldSeenInList(){
        carPage.enterLicencePlateCorrect("ASW456")
                .clickAddCar()
                .verityCarInList("ASW456");
    }

    @Test
    public void deleteCar_deleteCarFromList_shouldSeenAlert(){
        carPage.deleteItem(0)
                .verityAlert();
    }

    @Test
    public void addCar_tryAddCarWithLicensePlateWithOneLetter_shouldShowAlert(){
        carPage.enterLicencePlateIncorrect("A")
                .clickAddCar()
                .verityAlert();
    }

    @Test
    public void addCar_tryAddCarWithLicensePlateWithOnlyLatter_shouldShowAlert(){
        carPage.enterLicencePlateIncorrect("ASDMIJ")
                .clickAddCar()
                .verityAlert();
    }


    @Test
    public void addCar_tryAddCarWithLicensePlateWithSevenDigits_shouldShowAlert(){
        carPage.enterLicencePlateIncorrect("ADE3456")
                .clickAddCar()
                .verityAlert();
    }

    @Test
    public void addCar_tryAddCarWithLicensePlateWithOnlyNumbers_shouldShowAlert(){
        carPage.enterLicencePlateIncorrect("345656")
                .clickAddCar()
                .verityAlert();
    }

    @Test
    public void addCar_tryAddCarWithOneSpaceInParking_shouldAddCart(){

        for (int i = 1; i < 19; i++){
            String licensePlate = "ASW";
            if(i<10){
                licensePlate = licensePlate+"00"+i;
            }else{
                licensePlate = licensePlate+"0"+i;
            }

            carPage.enterLicencePlateCorrect(licensePlate)
                    .clickAddCar();
        }

        carPage.enterLicencePlateCorrect("ASW020")
                .clickAddCar();
    }

    @Test
    public void addCar_addCarWithOutSpaceInParking_shouldSeenAlert(){
        carPage.enterLicencePlateCorrect("ASW456")
                .clickAddCar()
                .verityAlert();
    }


}

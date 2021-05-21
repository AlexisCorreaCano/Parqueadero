package co.com.ceiba.parqueadero.test;

import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.com.ceiba.parqueadero.pages.MotorcyclePage;
import co.com.ceiba.parqueadero.view.activity.MainActivity;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class MotorcycleTest {

    private MotorcyclePage motorcyclePage;

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp(){
        motorcyclePage = new MotorcyclePage();
    }

    @Test
    public void addMotorcycle_writeLicensePlateAndCCAndAdd_shouldSeenMotorcycleInList(){
        motorcyclePage.navigateToMotorcyclePage()
                .enterLicensePlate("SDE467")
                .enterCylinderCapacity("150")
                .clickAddMotorcycle()
                .verityCarInList("SDE467");

    }

    @Test
    public void addMotorcycle_writeBadLicensePlate_shouldSeenAlert(){
        motorcyclePage.navigateToMotorcyclePage()
                .enterLicensePlateBad("SDE4")
                .enterCylinderCapacity("150")
                .clickAddMotorcycle()
                .verityAlert();

    }

    @Test
    public void addMotorcycle_writeLicensePlateWithSevenDigits_shouldSeenAlert(){
        motorcyclePage.navigateToMotorcyclePage()
                .enterLicensePlateBad("SDE4888")
                .enterCylinderCapacity("150")
                .clickAddMotorcycle()
                .verityAlert();

    }

    @Test
    public void addMotorcycle_writeCylinderCapacityZero_shouldSeenAlert(){
        motorcyclePage.navigateToMotorcyclePage()
                .enterLicensePlateBad("SDE488")
                .enterCylinderCapacity("0")
                .clickAddMotorcycle()
                .verityAlert();

    }

    @Test
    public void addMotorcycle_writeLicensePlateOnlyLatter_shouldSeenAlert(){
        motorcyclePage.navigateToMotorcyclePage()
                .enterLicensePlateBad("SDEDFR")
                .enterCylinderCapacity("150")
                .clickAddMotorcycle()
                .verityAlert();

    }

    @Test
    public void addMotorcycle_writeLicensePlateOnlyNumbers_shouldSeenAlert(){
        motorcyclePage.navigateToMotorcyclePage()
                .enterLicensePlateBad("456675")
                .enterCylinderCapacity("150")
                .clickAddMotorcycle()
                .verityAlert();

    }

}

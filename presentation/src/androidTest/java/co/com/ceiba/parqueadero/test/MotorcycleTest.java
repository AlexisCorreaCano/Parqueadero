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

}

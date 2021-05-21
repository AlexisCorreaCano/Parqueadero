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
    public void addCart_addCarWithLicensePlateOK_shouldSeenInList(){
        carPage.enterLicencePlateCorrect("ASW456")
                .clickAddCar()
                .verityCarInList("ASW456");
    }
}

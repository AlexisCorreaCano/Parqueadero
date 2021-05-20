package co.com.ceiba.parqueadero;

import android.content.Context;

import androidx.test.espresso.action.ViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.com.ceiba.parqueadero.view.activity.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void addCar_writeLicensePlateAndAdd_shouldSeenCarInList(){
        //Arrange
        String licensePlate = "ASD789";
        //Act
        onView(withId(R.id.txt_license_plate_car)).perform(typeText(licensePlate), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.fab)).perform(click());
        //Assert
        onView(withText(licensePlate))
                .check(matches(isDisplayed()));
    }

    @Test
    public void addMotorcycle_writeLicensePlateAndCCAndAdd_shouldSeenMotorcycleInList(){
        //Arrange
        String licensePlate = "APP789";
        String cc = "100";
        //Act

        onView(withText("MOTORCYCLES")).perform(click());
        onView(withId(R.id.txt_license_plate)).perform(typeText(licensePlate), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.txt_cylinder_capacity)).perform(typeText(cc), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.fab_motorcycle)).perform(click());

        //Assert
        onView(withText(cc))
                .check(matches(isDisplayed()));
    }
}
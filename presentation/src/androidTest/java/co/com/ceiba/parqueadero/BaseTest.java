package co.com.ceiba.parqueadero;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class BaseTest {

    protected static void clickButton(int resourceId){
        onView(withId(resourceId))
                .perform(click());
    }

    protected static void clickButton(String text){
        onView(withText(text))
                .perform(click());
    }

    protected static void enterText(int resourceId,String text){
        onView(withId(resourceId))
                .perform(replaceText(text), closeSoftKeyboard());
    }

    protected static void verifyTextDisplay(int resourceId,String text){
        onView(allOf(withId(resourceId),withText(text)))
                .check(matches(isDisplayed()));
    }
}

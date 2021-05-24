package co.com.ceiba.parqueadero;

import androidx.test.espresso.action.GeneralClickAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.action.Tap;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withResourceName;
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

    protected static void verifyTextDisplay(String resourceName){
        onView(allOf(withResourceName("message")))
                .check(matches(isDisplayed()));
    }

    protected static void deleteItem(int resourceId,int position){
        onView(withId(resourceId))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,click()))
                .perform(RecyclerViewActions
                        .actionOnItemAtPosition(0,
                                new GeneralSwipeAction(Swipe.SLOW,
                                        GeneralLocation.CENTER_LEFT,
                                        GeneralLocation.BOTTOM_RIGHT,
                                        Press.FINGER)));;


    }
}

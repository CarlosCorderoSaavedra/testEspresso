package cordero.carlos.testespresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.Gravity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by carlos.cordero on 18/4/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HelloWorldEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mNotesActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkHelloWorldText() {
        onView(withText("Hello World!")).check(matches(isDisplayed()));
    }

    @Test
    public void tapInNavigationDrawer() {
        onView(withId(R.id.drawer_layout)).perform(click());
    }
    @Test
    public void checkNavigationDrawerViewButton() {
        //onView(withId(R.id.imageView)).perform(click(), onView(withId(R.id.pepe_galery)).perform(click()));

        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(open()); // Open Drawer
    }
}

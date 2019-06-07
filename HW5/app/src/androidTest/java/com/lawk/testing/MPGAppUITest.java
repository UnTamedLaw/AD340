package com.lawk.testing;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;




@RunWith(AndroidJUnit4.class)
@LargeTest
public class MPGAppUITest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testMPGGeneration() {
        onView(withId(R.id.gasSpinner))
                .perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Unleaded")))
                .perform(click());
        onView(withId(R.id.mpgReply))
                .perform(typeText("25"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.milesEntered))
                .perform(typeText("100"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.Calculated))
                .check(matches(withText("$15.40")));

    }
}

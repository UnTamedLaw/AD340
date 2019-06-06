package com.lawk.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    @Test
    public void testNotEnoughDataProvided() {
        MainActivity  activity = Robolectric.setupActivity(MainActivity.class);

        activity.findViewById(R.id.button).performClick();

        assertEquals("Miles Per Gallon or miles must be a number",
                ShadowToast.getTextOfLatestToast());


    }
}

package com.catalog.app.activities;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.catalog.app.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Functional test for CatalogActivity
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CatalogActivityTest {

    @Rule
    public ActivityTestRule<CatalogActivity> activityRule = new ActivityTestRule<>(CatalogActivity.class);
    CatalogIdlingResource catalogIdlingResource;

    @Before
    public void setUp() throws Exception {
        catalogIdlingResource = new CatalogIdlingResource(activityRule.getActivity());
        Espresso.registerIdlingResources(catalogIdlingResource);
    }

    @Test
    public void testCatalogActivity() {
        onView(withId(R.id.container)).perform(swipeLeft());
        onView(withId(R.id.container)).perform(swipeLeft());
        onView(withId(R.id.container)).perform(swipeLeft());
        onView(withId(R.id.spinner)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
        Espresso.unregisterIdlingResources(catalogIdlingResource);
    }

}
package jonesbl.packt.com.plantplacespackt;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SearchPlantsActivityTest2 {

    @Rule
    public ActivityTestRule<SearchPlantsActivity> mActivityTestRule = new ActivityTestRule<>(SearchPlantsActivity.class);

    @Test
    public void searchPlantsActivityTest2() {

        ViewInteraction appCompatAutoCompleteTextView6 = onView(
                allOf(withId(R.id.actPlants),
                        withParent(allOf(withId(R.id.activity_search_plants),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatAutoCompleteTextView6.perform(replaceText("Redbud"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button), withText("Show Plant"),
                        withParent(allOf(withId(R.id.activity_search_plants),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.text1), withText("Cercis canadensis  Eastern Redbud"),
                        childAtPosition(
                                allOf(withId(R.id.lstPlants),
                                        childAtPosition(
                                                withId(R.id.activity_search_plants),
                                                3)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Cercis canadensis  Eastern Redbud")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

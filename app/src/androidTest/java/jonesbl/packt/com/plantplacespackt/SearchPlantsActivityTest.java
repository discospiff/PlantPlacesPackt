package jonesbl.packt.com.plantplacespackt;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import jonesbl.packt.com.dto.PlantDTO;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by jonesb on 1/2/2017.
 */

@RunWith(AndroidJUnit4.class)
public class SearchPlantsActivityTest {


    @Rule
    public ActivityTestRule<SearchPlantsActivity> activityRule = new ActivityTestRule<SearchPlantsActivity>(SearchPlantsActivity.class);

    @Test
    public void searchForRedbudShouldReturnAtLeastOneResult() {
        Context context = InstrumentationRegistry.getContext();

        onView(withId(R.id.actPlants)).perform(typeText("Redbud"));
        onView(withId(R.id.button)).perform(click());

        List<PlantDTO> plants = activityRule.getActivity().getPlants();
        assertThat(plants, not(empty()));


    }




}
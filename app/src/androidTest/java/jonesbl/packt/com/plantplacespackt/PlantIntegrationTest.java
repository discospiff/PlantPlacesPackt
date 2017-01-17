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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Created by jonesb on 1/1/2017.
 */

@RunWith(AndroidJUnit4.class)
public class PlantIntegrationTest {

    @Rule
    public ActivityTestRule<SearchPlantsActivity> mActivityRule = new ActivityTestRule<>(
            SearchPlantsActivity.class);

    @Test
    public void testSearchRedbud() {
        Context context = InstrumentationRegistry.getContext();
        // context.sendBroadcast();

        onView(withId(R.id.actPlants)).perform(typeText("Redbud"), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        List<PlantDTO> plants = mActivityRule.getActivity().getPlants();
        assertThat(plants, not(empty()));

    }



}

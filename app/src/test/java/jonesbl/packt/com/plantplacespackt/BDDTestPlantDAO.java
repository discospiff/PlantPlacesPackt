package jonesbl.packt.com.plantplacespackt;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import jonesbl.packt.com.dao.IPlantDAO;
import jonesbl.packt.com.dao.PlantDAO;
import jonesbl.packt.com.dto.PlantDTO;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertThat;

/**
 * Created by jonesb on 1/9/2017.
 */

public class BDDTestPlantDAO {

    IPlantDAO plantDAO;
    private List<PlantDTO> plants;

    @Test
    public void testPlantDAO_fetchShouldReturnResultsForRedbud() throws IOException, JSONException {
        givenPlantDAOIsInitialized();
        whenSearchForRedbud();
        thenVerifyAtLeastOneCercisCanadensis();
    }

    @Test
    public void testPlantDAO_fetchShouldReturnAtLeastTwoOaksForQuercus() throws IOException, JSONException {
        givenPlantDAOIsInitialized();
        whenSearchForQuercus();
        thenVerifyTwoOaks();
    }

    @Test
    public void testPlantDAO_fetchShouldReturnGenusQuercusForQuercus() throws IOException, JSONException {
        givenPlantDAOIsInitialized();
        whenSearchForQuercus();
        thenVerifyAllGenusAreQuercus();
    }

    private void thenVerifyAllGenusAreQuercus() {
        for (PlantDTO plant : plants)
        {
            assertThat(plant, hasProperty("genus", containsString("Quercus")));
        }
    }

    @Test
    public void testPlantDAO_fetchShouldReturnNothingForGibberish() throws IOException, JSONException {
        givenPlantDAOIsInitialized();
        whenSearchForGibberish();
        thenVerifyNoResults();
    }

    private void givenPlantDAOIsInitialized() {
        plantDAO = new PlantDAO();
    }

    private void whenSearchForRedbud() throws IOException, JSONException {
        plants = plantDAO.fetchPlants("Redbud");
    }

    private void thenVerifyAtLeastOneCercisCanadensis() {
        // assume we do not have a match.
        boolean redbudFound = false;

        for (PlantDTO plant : plants) {
            if (plant.getGenus().contains("Cercis") && plant.getSpecies().contains("canadensis")) {
                redbudFound = true;
            }
        }
        // did we find a redbud?
        assertTrue(redbudFound);

    }

    private void thenVerifyNoResults() {
        assertThat(plants, empty());
    }

    private void whenSearchForGibberish() throws IOException, JSONException {
        plants = plantDAO.fetchPlants("sklujapouetllkjsda;u");
    }

    private void whenSearchForQuercus() throws IOException, JSONException {
        plants = plantDAO.fetchPlants("Quercus");
    }

    private void thenVerifyTwoOaks() {
        // assume we do not have a match.
        boolean quercusRoburFound = false;

        for (PlantDTO plant : plants) {
            if (plant.getGenus().contains("Quercus") && plant.getSpecies().contains("robur") && plant.getCommon().contains("Oak")) {
                quercusRoburFound = true;
            }
        }
        // did we find a redbud?
        assertTrue(quercusRoburFound);

        // assume we do not have a match.
        boolean quercusAlbaFound = false;

        for (PlantDTO plant : plants) {
            if (plant.getGenus().contains("Quercus") && plant.getSpecies().contains("alba") && plant.getCommon().contains("Oak")) {
                quercusAlbaFound = true;
            }
        }
        // did we find a redbud?
        assertTrue(quercusAlbaFound);
    }

}

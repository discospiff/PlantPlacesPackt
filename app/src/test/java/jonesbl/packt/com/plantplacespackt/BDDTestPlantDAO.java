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
}

package jonesbl.packt.com.plantplacespackt;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import jonesbl.packt.com.dao.IPlantDAO;
import jonesbl.packt.com.dao.PlantDAOStub;
import jonesbl.packt.com.dto.PlantDTO;

import static junit.framework.Assert.assertTrue;

/**
 * Created by jonesb on 1/7/2017.
 */

public class TestPlantDAO {

    // define a variable for the DAO we are testing.
    IPlantDAO plantDAO;

    @Before
    public void setup() {
        plantDAO = new PlantDAOStub();
    }

    @Test
    public void testPlantDAO_searchForRedbudShouldReturnAtLeastOneResult() {

        // assume we do not have a match.
        boolean redbudFound = false;

        List<PlantDTO> plants = plantDAO.fetchPlants("Redbud");

        for (PlantDTO plant : plants) {
            if (plant.getCommon().contains("Redbud")) {
                redbudFound = true;
            }
        }
        // did we find a redbud?
        assertTrue(redbudFound);
    }

}

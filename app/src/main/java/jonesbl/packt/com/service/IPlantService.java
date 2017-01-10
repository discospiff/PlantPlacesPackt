package jonesbl.packt.com.service;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import jonesbl.packt.com.dto.PlantDTO;

/**
 * Business logic for fetching and managing plants.
 * Created by jonesb on 1/7/2017.
 */

public interface IPlantService {

    /**
     * Return a series of plants that contain the specified filter text
     * @param filter text that should be contained in the returned plants.
     * @return a list of plants that match the specified search criteria
     */
    List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException;
}

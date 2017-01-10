package jonesbl.packt.com.dao;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import jonesbl.packt.com.dto.PlantDTO;

/**
 * A collection of methods to access plant data.
 * Created by jonesb on 1/7/2017.
 */
public interface IPlantDAO {

    /**
     * Accept filter text, and return a collection of plants that contain that filter text.
     * @param filter the text we want to match in our returned list of plants.
     * @return a list of plants that contain the given filter text in either genus, species, cultivar, or common name.
     */
    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException;

}

package jonesbl.packt.com.dao;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import jonesbl.packt.com.dto.PlantDTO;

/**
 * Created by jonesb on 1/7/2017.
 */

public class PlantJsonDao implements IPlantDAO {
    @Override
    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException {
        return null;
    }
}

package jonesbl.packt.com.service;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import jonesbl.packt.com.dao.IPlantDAO;
import jonesbl.packt.com.dao.PlantDAO;
import jonesbl.packt.com.dao.PlantDAOStub;
import jonesbl.packt.com.dao.PlantJsonDao;
import jonesbl.packt.com.dto.PlantDTO;

/**
 * Created by jonesb on 1/7/2017.
 */

public class PlantService implements  IPlantService {

    IPlantDAO plantDAO;

    public PlantService() {
        plantDAO = new PlantDAO();
    }

    @Override
    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException {
        return plantDAO.fetchPlants(filter);
    }
}

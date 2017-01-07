package jonesbl.packt.com.service;

import java.util.List;

import jonesbl.packt.com.dao.IPlantDAO;
import jonesbl.packt.com.dao.PlantJsonDao;
import jonesbl.packt.com.dto.PlantDTO;

/**
 * Created by jonesb on 1/7/2017.
 */

public class PlantService implements  IPlantService {

    IPlantDAO plantDAO;

    public PlantService() {
        plantDAO = new PlantJsonDao();
    }

    @Override
    public List<PlantDTO> fetchPlants(String filter) {
        return plantDAO.fetchPlants(filter);
    }
}

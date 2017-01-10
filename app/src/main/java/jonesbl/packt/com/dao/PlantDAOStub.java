package jonesbl.packt.com.dao;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jonesbl.packt.com.dto.FlowerDTO;
import jonesbl.packt.com.dto.PlantDTO;
import jonesbl.packt.com.dto.TreeDTO;

/**
 * Created by jonesb on 1/7/2017.
 */

public class PlantDAOStub implements IPlantDAO {
    @Override
    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException {
        List<PlantDTO> allPlants = new ArrayList<PlantDTO>();
        TreeDTO plant = new TreeDTO();
        plant.setGenus("Cercis");
        plant.setSpecies("canadensis");
        plant.setCommon("Eastern Redbud");
        plant.setSize(30);
        plant.setFallColor("Yellowish");
        plant.setType("tree");
        allPlants.add(plant);

        PlantDTO flower = new FlowerDTO();
        flower.setGenus("Tropoleum");
        flower.setSpecies("spp");
        flower.setCommon("Nasturtium");
        flower.setType("flower");
        allPlants.add(flower);

        return allPlants;
    }
}

package jonesbl.packt.com.dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jonesbl.packt.com.dto.PlantDTO;

/**
 * Created by jonesb on 1/9/2017.
 */

public class PlantDAO implements IPlantDAO {

    private NetworkDAO networkDAO;

    public PlantDAO() {
        setNetworkDAO(new NetworkDAO());
    }

    @Override
    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException {
        ArrayList<PlantDTO> allPlants = new ArrayList<PlantDTO>();


        String request = getNetworkDAO().fetch("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=" + filter);

        // the entire JSON string is in root.
        JSONObject root = new JSONObject(request);

        // now that we have root, let's get the first array, named plants
        JSONArray plants = root.getJSONArray("plants");

        for (int i = 0; i < plants.length(); i++) {
            // this guy right here represents an individual plant.
            JSONObject jsonObject = plants.getJSONObject(i);
            int id = jsonObject.getInt("id");
            String genus = jsonObject.getString("genus");
            String species = jsonObject.getString("species");
            String cultivar = jsonObject.getString("cultivar");
            String common = jsonObject.getString("common");

            // now, let's put them into a PlantDTO.
            PlantDTO plantDTO = new PlantDTO();
            plantDTO.setGuid(id);
            plantDTO.setGenus(genus);
            plantDTO.setSpecies(species);
            plantDTO.setCultivar(cultivar);
            plantDTO.setCommon(common);

            // add this plant to the collection.
            allPlants.add(plantDTO);
        }
        System.out.println("Foobat");
        return allPlants;

    }

    @Override
    public NetworkDAO getNetworkDAO() {
        return networkDAO;
    }

    @Override
    public void setNetworkDAO(NetworkDAO networkDAO) {
        this.networkDAO = networkDAO;
    }
}

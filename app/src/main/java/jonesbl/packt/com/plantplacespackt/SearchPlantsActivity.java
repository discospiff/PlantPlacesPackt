package jonesbl.packt.com.plantplacespackt;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import jonesbl.packt.com.dto.PlantDTO;
import jonesbl.packt.com.service.IPlantService;
import jonesbl.packt.com.service.PlantService;

public class SearchPlantsActivity extends AppCompatActivity {

    IPlantService plantService;
    private AutoCompleteTextView actPlants;
    private ListView lstPlants;
    private List<PlantDTO> plants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_plants);
        plantService = new PlantService();
        actPlants = (AutoCompleteTextView) findViewById(R.id.actPlants);
        lstPlants = (ListView) findViewById(R.id.lstPlants);
        plantService = new PlantService();

    }

    public void searchPlants(View v) throws IOException, JSONException {
        String search = actPlants.getText().toString();
        PlantSearchTask pst = new PlantSearchTask();
        pst.execute(search);
    }


    public List<PlantDTO> getPlants() {
        return plants;
    }

    public void setPlants(List<PlantDTO> plants) {
        this.plants = plants;
    }

    class PlantSearchTask extends AsyncTask<String, Integer, List<PlantDTO>> {

        @Override
        protected void onPostExecute(List<PlantDTO> plants) {
            ArrayAdapter<PlantDTO> plantDTOArrayAdapter = new ArrayAdapter<PlantDTO>(SearchPlantsActivity.this, android.R.layout.simple_list_item_1, plants);
            lstPlants.setAdapter(plantDTOArrayAdapter);
            setPlants(plants);
        }

        @Override
        protected List<PlantDTO> doInBackground(String... params) {
            List<PlantDTO> plants = null;
            try {
                plants = plantService.fetchPlants(params[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return plants;
        }
    }

}

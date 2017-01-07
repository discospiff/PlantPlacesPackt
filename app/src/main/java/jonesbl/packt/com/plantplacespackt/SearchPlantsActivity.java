package jonesbl.packt.com.plantplacespackt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.List;

import jonesbl.packt.com.dto.PlantDTO;
import jonesbl.packt.com.service.IPlantService;
import jonesbl.packt.com.service.PlantService;

public class SearchPlantsActivity extends AppCompatActivity {

    IPlantService plantService;
    private AutoCompleteTextView actPlantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_plants);
        plantService = new PlantService();
        actPlantName = (AutoCompleteTextView) findViewById(R.id.actPlantName);
    }

    public void searchPlants(View v) {
        List<PlantDTO> plants = plantService.fetchPlants(actPlantName.getText().toString());

        for (PlantDTO plant : plants) {
            Toast.makeText(this, plant.toString(), Toast.LENGTH_LONG).show();
        }
    }
}

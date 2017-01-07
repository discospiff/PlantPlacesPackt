package jonesbl.packt.com.plantplacespackt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;

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
        plantService.fetchPlants(actPlantName.getText().toString());
    }
}

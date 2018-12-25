package com.aoalaka.android.osmolator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double weightOfSugar;
    double volumeOfWater;
    double wtPerSample;
    int qtyOfSamples;
    double fruitSugarRatio;
    double degBrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView instruction = findViewById(R.id.instruction);
        String instructionString = getString(R.string.asumme);
        instruction.setText(instructionString);

        Button calcButton = findViewById(R.id.calc_btn);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final EditText wtPerSampleEditText = (EditText) findViewById(R.id.unit_sample_weight);
                    wtPerSample = Double.parseDouble(wtPerSampleEditText.getText().toString());
                    final EditText qtyOfSamplesEditText = (EditText) findViewById(R.id.quantity_of_samples);
                    qtyOfSamples = Integer.parseInt(qtyOfSamplesEditText.getText().toString());
                    final EditText fruitSugarRatioEditText = (EditText) findViewById(R.id.fruit_sugar_ratio);
                    fruitSugarRatio = Double.parseDouble(fruitSugarRatioEditText.getText().toString());
                    final EditText degBrixEditText = (EditText) findViewById(R.id.deg_brix);
                    degBrix = Double.parseDouble(degBrixEditText.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                OsmoticDehydration od = new OsmoticDehydration(wtPerSample, qtyOfSamples, fruitSugarRatio, degBrix);

                weightOfSugar = Utils.calculateWeightOfSugarRequired(od);
                volumeOfWater = Utils.calculateVolumeOfWaterRequired(od, weightOfSugar);

//                passing the results to the result activity for display to user
                Intent ResultPageIntent = new Intent(MainActivity.this, ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("weightOfSugar", weightOfSugar);
                bundle.putDouble("volumeOfWater", volumeOfWater);
                ResultPageIntent.putExtras(bundle);
                startActivity(ResultPageIntent);
            }
        });
    }

    @Override
    // This method initialize the contents of the Activity's options menu.
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the Options Menu we specified in XML
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_developer) {
            Intent actionBarIntent = new Intent(this, DeveloperNoteActivity.class);
            startActivity(actionBarIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

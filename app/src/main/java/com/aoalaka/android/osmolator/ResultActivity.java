package com.aoalaka.android.osmolator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    double weightOfSugar;
    double volumeOfWater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView sugarRequiredDisplay = findViewById(R.id.sugar_water_required);
        TextView resultHeading = findViewById(R.id.result_page_heading);
        String resultHeadingString = getString(R.string.prepare);
        resultHeading.setText(resultHeadingString);

        Bundle bundle = getIntent().getExtras();
//        Check if the results are passed to the result activity.
        if (bundle != null) {

            weightOfSugar = bundle.getDouble("weightOfSugar");
            volumeOfWater = bundle.getDouble("volumeOfWater");
        }

        String resultString = weightOfSugar + getString(R.string.g_sugar) + "\n" + volumeOfWater + getString(R.string.ml_water);
        sugarRequiredDisplay.setText(resultString);
    }
}

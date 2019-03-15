package com.example.cs_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioGroup options = findViewById(R.id.rgShapes);
        Intent intent = getIntent();
        int area = intent.getIntExtra("AREA", -1);
        String shape = intent.getStringExtra("SHAPE");
        if (intent != null && area != -1) {
            ((TextView) findViewById(R.id.tvAnswer)).setText(String.valueOf(area));
            if (!TextUtils.isEmpty(shape)) {
                if (shape.equalsIgnoreCase("TRIANGLE")) {

                    ((RadioButton) options.getChildAt(0)).setChecked(true);
                } else if (shape.equalsIgnoreCase("CIRCLE")) {

                    ((RadioButton) options.getChildAt(1)).setChecked(true);
                } else if (shape.equalsIgnoreCase("ELLIPSE")) {

                    ((RadioButton) options.getChildAt(2)).setChecked(true);
                }
            }
        }
        options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ((TextView) findViewById(R.id.tvAnswer)).setText("");
            }
        });
        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = ((RadioButton) findViewById(options.getCheckedRadioButtonId())).getText().toString();
                Intent intent = new Intent(MainActivity.this, AreaDetailsActivity.class);
                intent.putExtra("SHAPE", answer);
                startActivity(intent);
            }
        });
    }
}

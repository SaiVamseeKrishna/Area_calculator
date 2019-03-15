package com.example.cs_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by vamsee on 3/7/2018.
 */

public class AreaDetailsActivity extends AppCompatActivity {

    RelativeLayout circleLayout, triangleLayout,ellipseLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Intent intent = getIntent();
        circleLayout = findViewById(R.id.rlCircle);
        triangleLayout = findViewById(R.id.rlTriangle);
        ellipseLayout = findViewById(R.id.rlEllipse);
        final String shape = intent.getStringExtra("SHAPE");
        ((TextView)findViewById(R.id.tvShapeName)).setText(shape + " Area");
        if (shape.equalsIgnoreCase("Circle")) {
            triangleLayout.setVisibility(View.GONE);
            ellipseLayout.setVisibility(View.GONE);
            circleLayout.setVisibility(View.VISIBLE);
            Button btnCalculate = findViewById(R.id.btnCCalculate);
            btnCalculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String radius = ((EditText) findViewById(R.id.etRadius)).getText().toString();
                    Intent i = new Intent(AreaDetailsActivity.this, MainActivity.class);
                    int area = (int) (3.14 * Integer.parseInt(radius) * Integer.parseInt(radius));
                    i.putExtra("AREA", area);
                    i.putExtra("SHAPE",shape);
                    startActivity(i);
                }
            });
        } else if (shape.equalsIgnoreCase("Triangle")) {
            circleLayout.setVisibility(View.GONE);
            ellipseLayout.setVisibility(View.GONE);
            triangleLayout.setVisibility(View.VISIBLE);
            Button btnCalculate = findViewById(R.id.btnTCalculate);
            btnCalculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String breadth = ((EditText) findViewById(R.id.etBreadth)).getText().toString();
                    String height = ((EditText) findViewById(R.id.etHeight)).getText().toString();
                    Intent i = new Intent(AreaDetailsActivity.this, MainActivity.class);
                    int area = (int) (0.5 * (Integer.parseInt(breadth) * (Integer.parseInt(height))));
                    i.putExtra("AREA", area);
                    i.putExtra("SHAPE",shape);
                    startActivity(i);
                }
            });
        } else if (shape.equalsIgnoreCase("Ellipse")) {
            circleLayout.setVisibility(View.GONE);
            triangleLayout.setVisibility(View.GONE);
            ellipseLayout.setVisibility(View.VISIBLE);
            Button btnCalculate = findViewById(R.id.btnECalculate);
            btnCalculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String major = ((EditText) findViewById(R.id.etMajor)).getText().toString();
                    String minor = ((EditText) findViewById(R.id.etMinor)).getText().toString();
                    Intent i = new Intent(AreaDetailsActivity.this, MainActivity.class);
                    int area = (int) (3.14 * (Integer.parseInt(major) * (Integer.parseInt(minor))));
                    i.putExtra("AREA", area);
                    i.putExtra("SHAPE",shape);
                    startActivity(i);
                }
            });
        }
    }
}

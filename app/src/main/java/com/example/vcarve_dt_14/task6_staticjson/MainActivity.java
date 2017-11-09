package com.example.vcarve_dt_14.task6_staticjson;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner1 = findViewById(R.id.spinner1);
        final Button btn1 = findViewById(R.id.btn1);
        final ArrayList<String> spinnerDataList = new ArrayList<>();

        final String strJson = "{\n" +
                "  \"title\":\"CountriesList\",\n" +
                "  \"array\":[\n" +
                "    {\n" +
                "    \"Country\":\"India\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"Country\":\"US\"\n" +
                "    },\n" +
                "    {\n" +
                "    \"Country\":\"UK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"Country\" : \"Australia\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"Country\": \"Germany\"\n" +
                "    }\n" +
                "    ],\n" +
                "    \"nested\":{\n" +
                "    \"flag\": true,\n" +
                "    \"random_number\":1\n" +
                "    }\n" +
                "}";


        btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinnerData = "";


                try {
                    JSONObject root = new JSONObject(strJson);
                    JSONArray array = root.getJSONArray("array");

                    int lengthJsonArr = array.length();
                    for(int i=0;i<lengthJsonArr;i++) {
                        JSONObject jsonChildNode = array.getJSONObject(i);
                        String name = jsonChildNode.getString("Country");

                        spinnerDataList.add(name);

                    }



                    ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, spinnerDataList);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner1.setAdapter(adapter);

                    JSONObject nested= root.getJSONObject("nested");
                    Log.d("TAG","flag value "+nested.getBoolean("flag"));


            }catch (JSONException e){
                    e.printStackTrace();
                }
        }


    });
    }


    }


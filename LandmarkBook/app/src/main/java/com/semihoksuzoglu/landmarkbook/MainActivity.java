package com.semihoksuzoglu.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        final ArrayList<String> landmarkNames = new ArrayList<>();

        landmarkNames.add("Pisa");
        landmarkNames.add("Colosseum");
        landmarkNames.add("Eiffel");
        landmarkNames.add("London Bridge");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.pisaleaning);
        Bitmap colosseum = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.colosseum);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.eiffel);
        Bitmap londonBridge = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.londonbridge);

        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();

        landmarkImages.add(pisa);
        landmarkImages.add(colosseum);
        landmarkImages.add(eiffel);
        landmarkImages.add(londonBridge);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("name", landmarkNames.get(i));

               // selectedImage = landmarkImages.get(i);

                Bitmap bitmap = landmarkImages.get(i);
                Globals globals = Globals.getInstance();
                globals.setData(bitmap);

                startActivity(intent);
            }
        });

    }
}

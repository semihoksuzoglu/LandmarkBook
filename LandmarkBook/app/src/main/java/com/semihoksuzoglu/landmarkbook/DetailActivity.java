package com.semihoksuzoglu.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textView = findViewById(R.id.textView);
        ImageView imageView = findViewById(R.id.imageView2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        //imageView.setImageBitmap(MainActivity.selectedImage);
        Globals globals = Globals.getInstance();
        Bitmap bitmap = globals.getData();

        textView.setText(name);
        imageView.setImageBitmap(bitmap);
    }
}

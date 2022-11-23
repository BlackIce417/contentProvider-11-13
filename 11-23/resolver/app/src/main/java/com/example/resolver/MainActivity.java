package com.example.resolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver = getContentResolver();
        Button button = findViewById(R.id.button);

        ContentValues values = new ContentValues();
        values.put("name","张三");
        values.put("age",20);

        Uri uri = Uri.parse("content://myDB.provider/student");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resolver.insert(uri,values);
            }
        });
    }
}
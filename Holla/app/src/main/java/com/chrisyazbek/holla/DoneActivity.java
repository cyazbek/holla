package com.chrisyazbek.holla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);


        Button doneB = (Button) findViewById(R.id.hollazButtonDone);
        doneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DoneActivity.this, HollaAtActivity.class);
                startActivity(intent);
            }
        });

        Button anotherB = (Button) findViewById(R.id.anotherHolla);
        anotherB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DoneActivity.this, FavActivity.class);
                startActivity(intent);
            }
        });
    }
}

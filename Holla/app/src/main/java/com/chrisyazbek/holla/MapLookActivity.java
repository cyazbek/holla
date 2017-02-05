package com.chrisyazbek.holla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MapLookActivity extends AppCompatActivity {

    Button doneB;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_look);

        Intent i = getIntent();
        str = i.getStringExtra("contact");



        doneB = (Button) findViewById(R.id.doneB);
        doneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),str, Toast.LENGTH_SHORT).show();

                String loc = ((EditText)findViewById(R.id.editLocation)).toString();

                Intent intent = new Intent(MapLookActivity.this, DoneActivity.class);
                Notifyer.getInstance().AddNotifier(str,loc);
                startActivity(intent);
            }
        });

    }



}

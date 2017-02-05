package com.chrisyazbek.holla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.plus.model.people.Person;

public class FavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);

        LinearLayout jokerLayout = (LinearLayout) findViewById(R.id.joker);
        jokerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"haha", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FavActivity.this, Location2Activity.class);
                startActivity(intent);
            }
        });

        LinearLayout gjokerLayout = (LinearLayout) findViewById(R.id.gjoker);
        gjokerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavActivity.this, Location2Activity.class);
                startActivity(intent);
            }
        });

        LinearLayout greenlanternLayout = (LinearLayout) findViewById(R.id.greenlantern);
        greenlanternLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavActivity.this, Location2Activity.class);
                startActivity(intent);
            }
        });

        LinearLayout flashLayout = (LinearLayout) findViewById(R.id.flash);
        flashLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavActivity.this, Location2Activity.class);
                startActivity(intent);
            }
        });

        LinearLayout supermanLayout = (LinearLayout) findViewById(R.id.superman);
        supermanLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavActivity.this, Location2Activity.class);
                startActivity(intent);
            }
        });

        LinearLayout moreLayout = (LinearLayout) findViewById(R.id.more);
        moreLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavActivity.this, Location2Activity.class);
                startActivity(intent);
            }
        });
    }

}

package com.chrisyazbek.holla;

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
        jokerLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                    Toast.makeText(getApplicationContext(), "JOKER",   Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        LinearLayout gjokerLayout = (LinearLayout) findViewById(R.id.gjoker);
        gjokerLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                Toast.makeText(getApplicationContext(), "GIRLJOKER",   Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        LinearLayout greenlanternLayout = (LinearLayout) findViewById(R.id.greenlantern);
        greenlanternLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                Toast.makeText(getApplicationContext(), "GREEN LANTERN",   Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        LinearLayout flashLayout = (LinearLayout) findViewById(R.id.flash);
        flashLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                Toast.makeText(getApplicationContext(), "FLASH",   Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        LinearLayout supermanLayout = (LinearLayout) findViewById(R.id.superman);
        supermanLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                Toast.makeText(getApplicationContext(), "SUPERMAN",   Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        LinearLayout moreLayout = (LinearLayout) findViewById(R.id.more);
        moreLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                    Toast.makeText(getApplicationContext(), "MORE",   Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

}

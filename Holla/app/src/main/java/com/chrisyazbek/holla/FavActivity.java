package com.chrisyazbek.holla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.plus.model.people.Person;

public class FavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
    }

    ImageView firstFav = (ImageView) findViewById(R.id.joker_view);
    LinearLayout gjoker = (LinearLayout) findViewById(R.id.gjoker);

}

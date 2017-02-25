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

import butterknife.OnClick;
import butterknife.ButterKnife;

public class FavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.joker, R.id.gjoker, R.id.greenlantern, R.id.flash, R.id.superman, R.id.TestMe})
    public void contacClick()
    {
        Intent intent = new Intent(FavActivity.this, Location2Activity.class);
        intent.putExtra("contact","5144421279");
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "CLICKED", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.more)
    public void moreClick()
    {
        Intent intent = new Intent(FavActivity.this, ContactActivity.class);
        startActivity(intent);
        finish();
    }

}

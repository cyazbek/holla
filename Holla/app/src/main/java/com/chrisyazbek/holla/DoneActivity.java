package com.chrisyazbek.holla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.hollazButtonDone)
    public void GoToQueueActivity()
    {
        Intent intent = new Intent(DoneActivity.this, HollaAtActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.anotherHolla)
    public void GoBack()
    {
        Intent intent = new Intent(DoneActivity.this, FavActivity.class);
        startActivity(intent);
    }

}

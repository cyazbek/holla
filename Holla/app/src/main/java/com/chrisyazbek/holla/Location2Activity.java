package com.chrisyazbek.holla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Location2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location2);

        Intent i = getIntent();
        final String number = i.getStringExtra("contact");

        LinearLayout homeLayout = (LinearLayout) findViewById(R.id.homeLayout);
        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),number, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Location2Activity.this, DoneActivity.class);
                Notifyer.getInstance().AddNotifier(number,"Home");
                startActivity(intent);
            }
        });

        LinearLayout officeLayout = (LinearLayout) findViewById(R.id.officeLayout);
        officeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),number, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Location2Activity.this, DoneActivity.class);
                Notifyer.getInstance().AddNotifier(number,"Office");
                startActivity(intent);
            }
        });

        LinearLayout bankLayout = (LinearLayout) findViewById(R.id.bankLayout);
        bankLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),number, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Location2Activity.this, DoneActivity.class);
                Notifyer.getInstance().AddNotifier(number,"Bank");
                startActivity(intent);
            }
        });

        LinearLayout churchLayout = (LinearLayout) findViewById(R.id.churchLayout);
        churchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),number, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Location2Activity.this, DoneActivity.class);
                Notifyer.getInstance().AddNotifier(number,"Church");
                startActivity(intent);
            }
        });

        LinearLayout hospitalLayout = (LinearLayout) findViewById(R.id.hospitalLayout);
        hospitalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),number, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Location2Activity.this, DoneActivity.class);
                Notifyer.getInstance().AddNotifier(number,"Hospital");
                startActivity(intent);
            }
        });

        LinearLayout moreLayout = (LinearLayout) findViewById(R.id.moremoreLayout);
        moreLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),number, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Location2Activity.this, DoneActivity.class);
                startActivity(intent);
            }
        });

    }
}

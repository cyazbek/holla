package com.chrisyazbek.holla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HollaAtActivity extends AppCompatActivity {

    ArrayList<ContactLocation> contactLoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holla_at);


        contactLoc = Notifyer.getInstance().getHollaz();

        Toast.makeText(getApplicationContext(), "Contact Selected : "+contactLoc.size(),   Toast.LENGTH_LONG).show();
        ListView listview = (ListView) findViewById(R.id.hollaz_list_view);
        listview.setAdapter(new HollazListItemAdapter(this, contactLoc));

        // register onClickListener to handle click events on each item
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {
                String selectedContact = ((ContactLocation)contactLoc.get(position)).Location;

                //Intent intent = new Intent(ContactActivity.this, Location2Activity.class);
                //intent.putExtra("contact",selectedContact);
                //startActivity(intent);
            }
        });
    }
}

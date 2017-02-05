package com.chrisyazbek.holla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
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

        ListView listview = (ListView) findViewById(R.id.hollaz_list_view);
        listview.setAdapter(new HollazListItemAdapter(this, contactLoc));

        // register onClickListener to handle click events on each item
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {
                String phone = ((ContactLocation)contactLoc.get(position)).Phone;
                sendSMS(phone);

            }
        });

    }

    public void sendSMS (String phoneNb) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNb, "5145693080", "Holla! Your friend has arrived safely.", null, null);
    }
}

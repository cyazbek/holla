package com.chrisyazbek.holla;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {
    ArrayList<Kontacts> contact_List;
    Button bb;
    String nb;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Get the reference of movies
        //ListView moviesList=(ListView)findViewById(R.id.contact_list_view);

        contact_List = new ArrayList<Kontacts>();

        getContacts();

        Toast.makeText(getApplicationContext(), "Contact Selected : "+contact_List.size(),   Toast.LENGTH_LONG).show();
        listview = (ListView) findViewById(R.id.contact_list_view);
        listview.setAdapter(new ContactListItemAdapter(this, contact_List));

        // register onClickListener to handle click events on each item
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {
                String selectedContact = ((Kontacts)contact_List.get(position)).getNumber();

                Intent intent = new Intent(ContactActivity.this, Location2Activity.class);
                intent.putExtra("contact",selectedContact);
                startActivity(intent);
            }
        });

        nb = ((EditText) findViewById(R.id.phonenb_text)).getText().toString();
        bb = (Button) findViewById(R.id.next);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ContactActivity.this, Location2Activity.class);
                intent.putExtra("contact",nb);
                startActivity(intent);
            }
        });


    }

    public void getContacts()
    {
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));


                if (cur.getInt(cur.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                        contact_List.add(new Kontacts(name, phoneNo));
                        break;
                    }
                    pCur.close();
                }
            }
        }
    }
}

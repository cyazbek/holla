package com.chrisyazbek.holla;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {
    ArrayList<Kontacts> contact_List;
    ArrayList<Kontacts> KKList;
    ArrayList<String> movies;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Get the reference of movies
        //ListView moviesList=(ListView)findViewById(R.id.contact_list_view);

        contact_List = new ArrayList<Kontacts>();

        getMovies();

        Toast.makeText(getApplicationContext(), "Contact Selected : "+contact_List.size(),   Toast.LENGTH_LONG).show();
        listview = (ListView) findViewById(R.id.contact_list_view);
        listview.setAdapter(new ContactListItemAdapter(this, contact_List));
/*
        KKList = new ArrayList<Kontacts>();
        movies = new ArrayList<String>();
        getMovies();

        // Create The Adapter with passing ArrayList as 3rd parameter
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, movies);
        // Set The Adapter
        moviesList.setAdapter(arrayAdapter);

        // register onClickListener to handle click events on each item
        moviesList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {
                String selectedContact = movies.get(position);
                Toast.makeText(getApplicationContext(), "Contact Selected : "+selectedContact,   Toast.LENGTH_LONG).show();
            }
        });

    */
    }

    public void getMovies()
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
                    }
                    pCur.close();
                }
            }
//            for(int i = 0 ; i < KKList.size(); i++){
//                movies.add(KKList.get(i).getName());
//            }
        }
    }
}

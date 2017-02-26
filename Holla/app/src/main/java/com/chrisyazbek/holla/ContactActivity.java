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
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactActivity extends AppCompatActivity {
    ArrayList<Kontacts> contact_List;
    @BindView(R.id.contact_list_view) ListView listview;
    public static final int MULTIPLE_PERMISSIONS = 10; //Required for permissions

    String[] permissions = new String[] {
            Manifest.permission.READ_CONTACTS
    };

    @Override
    protected void onStart() {
        super.onStart();
        if (checkPermissions())
        {
            //Granted
            Toast.makeText(getApplicationContext(), "HAVE PERMISSIONS", Toast.LENGTH_SHORT).show();
            RetrieveContacts();

        }
        else
        {
            //Lack permissions
            Toast.makeText(getApplicationContext(), "NO PERMISSIONS", Toast.LENGTH_SHORT).show();
            Log.e("MISSING PERMISSION", "Contact permission wasn't granted in ContactActivity");
            //TODO: Either Exit Application or Go back One Page
        }
    }

    //Called only after permissions are given
    private void RetrieveContacts()
    {
        contact_List = new ArrayList<Kontacts>();
        getContacts();

        Toast.makeText(getApplicationContext(), "Contact Selected : "+contact_List.size(),   Toast.LENGTH_LONG).show();
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
    }

    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p:permissions) {
            result = ContextCompat.checkSelfPermission(this,p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MULTIPLE_PERMISSIONS:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // permissions granted.
                    RetrieveContacts();
                } else {
                    // no permissions granted.
                }
                return;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);

        // Get the reference of movies
        //ListView moviesList=(ListView)findViewById(R.id.contact_list_view);
    }

    @OnClick(R.id.next)
    public void CustomPhoneEntered()
    {
        Intent intent = new Intent(ContactActivity.this, Location2Activity.class);
        String customNumber = ((EditText) findViewById(R.id.phonenb_text)).getText().toString();
        Toast.makeText(getApplicationContext(), customNumber, Toast.LENGTH_SHORT).show();
        intent.putExtra("contact",customNumber);
        startActivity(intent);
    }


    public void getContacts()
    {
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if (cur.getCount() <= 0) {
            return;
        }

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

package com.chrisyazbek.holla;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapLookActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_look);
        ButterKnife.bind(this);

        Intent i = getIntent();
        str = i.getStringExtra("contact");  //TODO: Replace to Contact

        Log.e("MAP", "Creating...");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @OnClick(R.id.doneB)
    public void DoneSelecting()
    {
        Toast.makeText(getApplicationContext(),str, Toast.LENGTH_SHORT).show();

        String loc = ((EditText)findViewById(R.id.editLocation)).getText().toString();

        Intent intent = new Intent(MapLookActivity.this, DoneActivity.class);
        Notifyer.getInstance().AddNotifier(str,loc);
        startActivity(intent);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Toast.makeText(getApplicationContext(), "MAP READY", Toast.LENGTH_SHORT).show();
        Log.e("MAP", "Map Ready");

        // Add a marker at Polytechnic
        LatLng poly = new LatLng(45.504628, -73.614675);
        mMap.addMarker(new MarkerOptions().position(poly).title("Marker at Polytechnique"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(poly));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(mMap.getMaxZoomLevel()));
    }

}

package com.project.uas_akb_10117216.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.project.uas_akb_10117216.R;

import java.io.IOException;
import java.util.List;

public class Map_Activity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    Geocoder coder;
    List<Address> address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        float zoomLevel = 16.0f;
        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama_wisata");
        Log.d("TAG", "onMapReady: " + nama);

        LatLng lokasiWisata = getLocationFromAddress(this, nama);
        Marker loc = map.addMarker(new MarkerOptions().position(lokasiWisata).title(nama));
        loc.showInfoWindow();
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiWisata, zoomLevel));
    }

    public LatLng getLocationFromAddress(Context context, String strAddress) {
        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            // May throw an IOException
            address = coder.getFromLocationName(strAddress, 5);
            Log.d("TAG -->", "getLocationFromAddress: " + address);
            if (address == null) { return null; }
            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return p1;
    }

}
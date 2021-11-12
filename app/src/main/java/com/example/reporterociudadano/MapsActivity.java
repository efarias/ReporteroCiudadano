package com.example.reporterociudadano;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.reporterociudadano.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private String ubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ubicacion = (String) getIntent().getSerializableExtra("ubicacion");
        System.out.println(ubicacion);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        LatLng arica = new LatLng(-18.4746, -70.29792);
        LatLng iquique = new LatLng(-20.22036,-70.13913);
        LatLng antofagasta = new LatLng(-23.65236,-70.3954);
        LatLng santiago =  new LatLng(-33.45694,-70.64827);

        switch (ubicacion){
            case "Arica":
                mMap.addMarker(new MarkerOptions().position(arica).title("Arica"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arica,15));

                break;
            case "Iquique":
                mMap.addMarker(new MarkerOptions().position(iquique).title("Iquique"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(iquique,15));
                break;
            case "Antofagasta":
                mMap.addMarker(new MarkerOptions().position(antofagasta).title("Antofagasta"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(antofagasta,15));
                break;
            case "Santiago":
                mMap.addMarker(new MarkerOptions().position(santiago).title("Santiago"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(santiago,15));
                break;
            default:
                mMap.addMarker(new MarkerOptions().position(arica).title("Arica"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arica,15));

        }

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
}
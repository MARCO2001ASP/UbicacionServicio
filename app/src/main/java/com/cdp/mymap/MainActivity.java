package com.cdp.mymap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtLatitud, txtLongitud;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);

        // Configuración del fragmento del mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);

        // Coordenadas de ejemplo: México
        LatLng mexico = new LatLng(19.8077463, -99.4077038);
        mMap.addMarker(new MarkerOptions().position(mexico).title("México"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mexico, 10));  // Zoom inicial de 10
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        // Actualizar latitud y longitud al hacer clic en el mapa
        txtLatitud.setText(String.valueOf(latLng.latitude));
        txtLongitud.setText(String.valueOf(latLng.longitude));

        // Limpiar el mapa y agregar un marcador en la ubicación seleccionada
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(latLng).title("Ubicación seleccionada"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        // Actualizar latitud y longitud al hacer clic largo en el mapa
        txtLatitud.setText(String.valueOf(latLng.latitude));
        txtLongitud.setText(String.valueOf(latLng.longitude));

        // Limpiar el mapa y agregar un marcador en la ubicación seleccionada
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(latLng).title("Ubicación seleccionada (largo)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }
}

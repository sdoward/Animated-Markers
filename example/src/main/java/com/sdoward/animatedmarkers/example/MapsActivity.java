package com.sdoward.animatedmarkers.example;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.animation.*;
import android.view.View;
import android.view.animation.*;
import android.widget.*;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import com.sdoward.animatedmarkers.MarkerAnimator;
import com.sdoward.example.animatedmarkers.R;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMapClickListener,
        AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener {

    private Marker marker;
    private GoogleMap googleMap;
    private Spinner interpolatorSpinner;
    private SeekBar seekBar;
    private Interpolator interpolator = new BounceInterpolator();
    private int duration = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(this);
        interpolatorSpinner = (Spinner) findViewById(R.id.interpolater_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.interpolator_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        interpolatorSpinner.setAdapter(adapter);
        interpolatorSpinner.setOnItemSelectedListener(this);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (googleMap == null) {
            googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            if (googleMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        marker = googleMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        googleMap.setOnMapClickListener(this);
    }


    @Override
    public void onMapClick(LatLng latLng) {
        MarkerAnimator.animateMarker(marker, latLng, interpolator, duration);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                interpolator = new AccelerateDecelerateInterpolator();
                break;
            case 1:
                interpolator = new AccelerateInterpolator();
                break;
            case 2:
                interpolator = new AnticipateInterpolator();
                break;
            case 3:
                interpolator = new AnticipateOvershootInterpolator();
                break;
            case 4:
                interpolator = new BounceInterpolator();
                break;
            case 5:
                interpolator = new DecelerateInterpolator();
                break;
            case 6:
                interpolator = new FastOutLinearInInterpolator();
                break;
            case 7:
                interpolator = new FastOutSlowInInterpolator();
                break;
            case 8:
                interpolator = new LinearInterpolator();
                break;
            case 9:
                interpolator = new LinearOutSlowInInterpolator();
                break;
            case 10:
                interpolator = new OvershootInterpolator();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        duration = progress * 1000;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

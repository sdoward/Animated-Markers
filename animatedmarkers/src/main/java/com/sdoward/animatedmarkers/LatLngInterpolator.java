package com.sdoward.animatedmarkers;

import com.google.android.gms.maps.model.LatLng;

public interface LatLngInterpolator {

    LatLng interpolate(float fraction, LatLng a, LatLng b);

}

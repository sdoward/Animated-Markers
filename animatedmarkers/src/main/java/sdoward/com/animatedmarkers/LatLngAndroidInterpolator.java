package sdoward.com.animatedmarkers;

import android.view.animation.Interpolator;

import com.google.android.gms.maps.model.LatLng;

public class LatLngAndroidInterpolator implements LatLngInterpolator {

    private Interpolator interpolator;

    public LatLngAndroidInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
    }

    @Override
    public LatLng interpolate(float fraction, LatLng a, LatLng b) {
        fraction = interpolator.getInterpolation(fraction);
        double lat = (b.latitude - a.latitude) * fraction + a.latitude;
        double lng = (b.longitude - a.longitude) * fraction + a.longitude;
        return new LatLng(lat, lng);
    }
}

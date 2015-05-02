package sdoward.com.animatedmarkers;

import android.animation.*;
import android.util.Property;
import android.view.animation.Interpolator;

import com.google.android.gms.maps.model.*;

public class MarkerAnimator {


    public static void animateMarker(Marker marker, LatLng finalPosition, Interpolator interpolator, long duration) {
        final LatLngInterpolator latLngInterpolator = new LatLngAndroidInterpolator(interpolator);
        TypeEvaluator<LatLng> typeEvaluator = new TypeEvaluator<LatLng>() {
            @Override
            public LatLng evaluate(float fraction, LatLng startValue, LatLng endValue) {
                return latLngInterpolator.interpolate(fraction, startValue, endValue);
            }
        };
        Property<Marker, LatLng> property = Property.of(Marker.class, LatLng.class, "position");
        ObjectAnimator animator = ObjectAnimator.ofObject(marker, property, typeEvaluator, finalPosition);
        animator.setDuration(duration);
        animator.start();
    }

    public static void animateCircle(Circle circle, LatLng finalPosition, Interpolator interpolator, long duration) {
        final LatLngInterpolator latLngInterpolator = new LatLngAndroidInterpolator(interpolator);
        TypeEvaluator<LatLng> typeEvaluator = new TypeEvaluator<LatLng>() {
            @Override
            public LatLng evaluate(float fraction, LatLng startValue, LatLng endValue) {
                return latLngInterpolator.interpolate(fraction, startValue, endValue);
            }
        };
        Property<Circle, LatLng> property = Property.of(Circle.class, LatLng.class, "center");
        ObjectAnimator animator = ObjectAnimator.ofObject(circle, property, typeEvaluator, finalPosition);
        animator.setDuration(duration);
        animator.start();
    }

}

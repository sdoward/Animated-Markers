# Animated-Markers

This is a helper library to animate markers and circles on google maps.

To use add a marker/circle to google maps on the starting location.

```
Marker marker = googleMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
```

Then call animate marker passing in the marker to animate, the end LatLng and the duration

```
MarkerAnimator.animateMarker(marker, latLng, interpolator, duration);
```
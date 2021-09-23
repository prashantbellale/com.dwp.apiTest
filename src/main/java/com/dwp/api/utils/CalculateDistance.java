package com.dwp.api.utils;

import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;
import org.json.JSONObject;

public class CalculateDistance {

    private static  double londonLatitude = 51 + (30 / 60.0) + (26 / 60.0 / 60.0);
    private static  double londonLongitude = 0 - (7 / 60.0) - (40 / 60.0 / 60.0);

    public static double getDistance(JSONObject user) {

        double lon = user.getDouble("longitude");
        double lat = user.getDouble("latitude");
        GeodesicData result = Geodesic.WGS84.Inverse(londonLatitude, londonLongitude, lat, lon);
        double miles = result.s12/1609.34;
        return miles;

    }

}

package com.dataojo.putuo.util;

import com.dataojo.putuo.entity.Gps;


import java.math.BigDecimal;


public class PositionUtils {
    public static double PI = 3.1415926535897932384626;
    public static double a = 6378245.0;
    public static double ee = 0.00669342162296594323;
    public static double x_PI = 3.14159265358979324 * 3000.0 / 180.0;
    public static final String BAIDU_LBS_TYPE = "bd09ll";

    

    /**
     * 84坐标转换成上海城地坐标
     * @param lon
     * @param lat
     * @return
     */
    public static Gps wgs84_To_Sh(double lon, double lat) {
        double xx, yy, r2d, tolat, tolon, rearth, PI;
        PI = 3.141592653589793;
        r2d = 57.2957795131;
        tolat = (31 + (14.0 + 7.55996 / 60.0) / 60.0) / r2d;
        tolon = (121.0 + (28.0 + 1.80651 / 60.0) / 60) / r2d;
        rearth = 6371006.84;
        double hor, frlat, frlon, gcdist, clatf, clatt, slatf, slatt, gcbrg;
        double dlon, cdlon, sdlon, sdist, cdist, sbrg, cbrg, temp;
        double intlat, intlon;
        intlat = lat;
        intlon = lon;
        frlat = lat / r2d;
        frlon = lon / r2d;
        clatt = Math.cos(frlat);
        clatf = Math.cos(tolat);
        slatt = Math.sin(frlat);
        slatf = Math.sin(tolat);
        dlon = frlon - tolon;
        cdlon = Math.cos(dlon);
        sdlon = Math.sin(dlon);
        cdist = slatf * slatt + clatf * clatt * cdlon;
        temp = (clatt * sdlon) * (clatt * sdlon) + (clatf * slatt - slatf * clatt * cdlon) * (clatf * slatt - slatf * clatt * cdlon);
        sdist = Math.sqrt(Math.abs(temp));
        if ((Math.abs(sdist) > 1e-7) || (Math.abs(cdist) > 1e-7)) {
            gcdist = Math.atan2(sdist, cdist);
        } else {
            gcdist = 0;
        }
        sbrg = sdlon * clatt;
        cbrg = (clatf * slatt - slatf * clatt * cdlon);
        if ((Math.abs(sbrg) > 1e-7) || (Math.abs(cbrg) > 1e-7)) {
            temp = Math.atan2(sbrg, cbrg);
            while (temp < 0) {
                temp = temp + 2 * PI;
                gcbrg = temp;
            }
        } else {
            gcbrg = 0;
        }
        hor = gcdist * rearth;
        xx = (hor * Math.sin(temp)) ;
        yy = (hor * Math.cos(temp)) ;
        double xxb = new BigDecimal(xx).setScale(2,BigDecimal.ROUND_DOWN).doubleValue();
        double yyb = new BigDecimal(yy).setScale(2,BigDecimal.ROUND_DOWN).doubleValue();
        return new Gps(yyb, xxb);
    }

    /**
     * 84 to 火星坐标系 (GCJ-02) World Geodetic System ==> Mars Geodetic System
     * @param lat
     * @param lon
     */
    public static Gps Gps84_To_Gcj02(double lat, double lon) {
        if (outOfChina(lat, lon)) {
            return null;
        }
        double dLat = transformLat(lon - 105.0, lat - 35.0);
        double dLon = transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * PI;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * PI);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * PI);
        double mgLat = lat + dLat;
        double mgLon = lon + dLon;
        return new Gps(mgLat, mgLon);
    }

    /**
     * * 火星坐标系 (GCJ-02) to 84 * * @param lon * @param lat * @return
     */
    public static Gps gcj_To_Gps84(double lat, double lon) {
        Gps Gps = transform(lat, lon);
        double lontitude = lon * 2 - Gps.getLon();
        double latitude = lat * 2 - Gps.getLat();
        return new Gps(latitude, lontitude);
    }

    /**
     * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 将 GCJ-02 坐标转换成 BD-09 坐标
     *
     * @param gg_lat
     * @param gg_lon
     */
    public static Gps gcj02_To_Bd09(double gg_lat, double gg_lon) {
        double x = gg_lon, y = gg_lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * PI);
        double bd_lon = z * Math.cos(theta) + 0.0065;
        double bd_lat = z * Math.sin(theta) + 0.006;
        return new Gps(bd_lat, bd_lon);
    }

    /**
     * * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 * * 将 BD-09 坐标转换成GCJ-02 坐标 * * @param
     * bd_lat * @param bd_lon * @return
     */
    public static Gps bd09_To_Gcj02(double bd_lat, double bd_lon) {
        double x = bd_lon - 0.0065, y = bd_lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * PI);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * PI);
        double gg_lon = z * Math.cos(theta);
        double gg_lat = z * Math.sin(theta);
        return new Gps(gg_lat, gg_lon);
    }

    /**
     * (BD-09)-->84
     * @param bd_lat
     * @param bd_lon
     * @return
     */
    public static Gps bd09_To_Gps84(double bd_lat, double bd_lon) {
        Gps gcj02 = bd09_To_Gcj02(bd_lat, bd_lon);
        Gps map84 = gcj_To_Gps84(gcj02.getLat(),
                gcj02.getLon());
        return map84;

    }

    /**
     * is or not outOfChina
     * @param lat
     * @param lon
     * @return
     */
    public static boolean outOfChina(double lat, double lon) {
        if (lon < 72.004 || lon > 137.8347) {
            return true;
        }if (lat < 0.8293 || lat > 55.8271) {
            return true;
        }return false;
    }

    public static Gps transform(double lat, double lon) {
        if (outOfChina(lat, lon)) {
            return new Gps(lat, lon);
        }
        double dLat = transformLat(lon - 105.0, lat - 35.0);
        double dLon = transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * PI;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * PI);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * PI);
        double mgLat = lat + dLat;
        double mgLon = lon + dLon;
        return new Gps(mgLat, mgLon);
    }

    public static double transformLat(double x, double y) {
        double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y
                + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * PI) + 40.0 * Math.sin(y / 3.0 * PI)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * PI) + 320 * Math.sin(y * PI / 30.0)) * 2.0 / 3.0;
        return ret;
    }


    public static double transformLon(double x, double y) {
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1
                * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * PI) + 40.0 * Math.sin(x / 3.0 * PI)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * PI) + 300.0 * Math.sin(x / 30.0
                * PI)) * 2.0 / 3.0;
        return ret;
    }


}

//Name: 

public class GeoLocation
{
    private double latitude;
    private double longitude;
    
    public GeoLocation()
    {
        longitude = 0;
        latitude = 0;
    }
    
    public GeoLocation(double lati, double longi)
    {
        latitude = lati;
        longitude = longi;
    }
    
    //Accessor
    public String toString()
    {
        return "latitude: " + latitude + ", longitude: " + longitude;
    }
    
    //modifier
    public double distanceTo(GeoLocation other)
    {
        double lat1  = Math.toRadians(latitude);       //this  object's lat
        double long1 = Math.toRadians(longitude);
        double lat2  = Math.toRadians(other.latitude); //other object's lat
        double long2 = Math.toRadians(other.longitude);
        
        //apply the spherical law of cosines
        double theCos = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2);
        
        double arcLength = Math.acos(theCos);
        
        return arcLength * 3963.1676; //3963.1676 is ~ radius of Earth, in miles
    }
}

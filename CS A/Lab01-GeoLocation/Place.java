
//Name: vishruth M

public class Place
{
    private String name;
    private String address;
    private GeoLocation location;
    
    public Place(String n, String a, double lati, double longi)
    {
        name = n;
        address = a;
        location = new GeoLocation(lati, longi);
    }
    public Place(String n, String a, GeoLocation loc)
    {
        name = n;
        address = a;
        location = loc;
    }
    //Accessor
    public double distanceTo(Place other)
    {
        return location.distanceTo(other.location);
    }
    public String toString()
    {
        return name + "\n" + address + "\n" + location;
    }
    //modifier
}

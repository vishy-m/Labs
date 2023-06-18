
//Name: Vishruth M

public class Runner
{
    public static void main(String[] args)
    {
        final double fisdLat = 33.123961;
        final double fisdLong = -96.798735;
        GeoLocation fisd = new GeoLocation(fisdLat, fisdLong);
        System.out.println(fisd);
        System.out.println();
        
        Place fisdAdmin = new Place("Frico ISD Admin Building", "5515 Ohio Dr, Frisco, TX 75035", fisd);
        System.out.println(fisdAdmin);
        System.out.println();
        
        Place mySchool = new Place("Lone Star HS", "2606 Panther Creek Pkwy, Frisco, TX 75033", 33.1910, -96.8663);
        System.out.println(mySchool);
        System.out.println();
        
        System.out.println(fisdAdmin.distanceTo(mySchool));
    }
}

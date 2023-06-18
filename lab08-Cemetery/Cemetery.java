
//Name:Vishruth M 
import java.util.*;
import java.io.*;
public class Cemetery
{
    private ArrayList<Tombstone> tombstones = new ArrayList<Tombstone>();

    public Cemetery(String fileName)
    {
        File file = new File(fileName);
        Scanner input = null;
        try {
            input = new Scanner(file);
        }
        catch (IOException e) { System.out.print(e); }
        
        while (input.hasNextLine())
        {
            Scanner chopper = new Scanner(input.nextLine());
            String name = "";
            String burialD = "";
            int age = 0;
            int count = 1;
            String ad = "";
            while (!chopper.hasNextInt())
            {
                name += chopper.next() + " ";
            }
            while (count < 4)
            {
                burialD += chopper.next() + " ";
                count++;
            }
                
            age += parseAge(chopper.next());
            ad = chopper.nextLine();
            tombstones.add(new Tombstone(name, burialD, age, ad));
        }
    }
    
    /** 
	 * convert the ageString to a number of days; age can 
	 * take a variety of forms in the data file
	 */
	public static int parseAge(String ageString)
	{
		if (ageString.contains("d")) { //age supplied in days
			ageString = ageString.replaceAll("d", "");
			return Integer.parseInt(ageString);
		}
		
		int result = 0;
		
		boolean done = true;

		try { result = Integer.parseInt(ageString); } //is the String a whole number of years?
		
		catch (NumberFormatException n) { done = false; }
		
		if (done) //successfully parsed as an int, return value
			return 365 * result; //ignoring leap years
		
		double ageDouble = 0;
		
		done = true;
		
		try { ageDouble = Double.parseDouble(ageString); } //is the String a floating point number of years?
		
		catch (NumberFormatException n) { done = false; }
		
		if (done) { //successfully parse as a double, String doesn't contain any text
			return (int)(ageDouble * 365); //ignoring leap years, using 30 for days in a month
		}
		
		if (ageString.contains("w")) { //age is supplied in weeks, return appropriately
			ageString = ageString.replaceAll("w", "");
			return Integer.parseInt(ageString) * 7;
		}
		
		return 0;
	}
	
	public double averageAgeByStreet(String street)
	{
	    int sum = 0;
	    int count = 0;
	    for (int i = 0; i < tombstones.size(); i++)
	    {
	        if (tombstones.get(i).getAddress().indexOf(street) != -1)
	        {
	            sum += tombstones.get(i).getAgeInDays();
	            count++;
	        }
	    }
	    double years = ((double)sum/ (double)count) / 365.0;
	    return Math.round(years * 10.0) / 10.0;
	}
	
	public void tombstoneInfo()
	{
	    for (int i = 0; i < tombstones.size(); i++)
	    {
	        System.out.println(tombstones.get(i));
	    }
	}
}

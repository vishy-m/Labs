
//Name: 

public class Schedular
{
    public static void main(String[] args)
    {
        //an Appointment is-a Date and can therefore be stored in a Date reference
	 //more info on this in future labs
        Date app1 = new Appointment();
        System.out.println(app1.toString());
        System.out.println();
        Date app2 = new Appointment(1, 27, 2021, "Dentist - 9:00am");
        System.out.println(app2.toString());
        System.out.println();
        Date app3 = new Appointment(3, 27, 2021, "Job Interview - 8:30am");
        System.out.println(app3.toString());
        System.out.println();
    }

}


//Name: 

public class Date
{
    private int month;
    private int day;
    private int year;

    public Date() {
        month = 1;
        day   = 1;
        year  = 1970;
    }

    public Date(int m, int d, int y) {
        month = m;
        day   = d;
        year  = y;
    }   

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }

}

//Name: 

/** NO CHANGES ARE NEEDED FOR THIS CLASS */
public class CityPop
{
    private String cityName;
    private int population;

    public CityPop(String cN, int pop)
    {
        cityName = cN;
        population = pop;
    }

    public String getCityName() { return cityName; }        

    public int getPopulation() { return population; }

    public boolean equals(CityPop other)
    {
        return 
          this.cityName.equals(other.cityName) &&
          this.population == other.population;
    }

    public String toString()
    {
        return cityName + " (" + population + " people)";
    }
}


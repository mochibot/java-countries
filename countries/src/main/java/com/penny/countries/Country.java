package com.penny.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private long population;
    private int landMass;
    private int medianAge;

    public Country (String name, long population, int landMass, int medianAge)
    {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    //getters
    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public long getPopulation()
    {
        return population;
    }

    public int getLandMass()
    {
        return landMass;
    }

    public int getMedianAge()
    {
        return medianAge;
    }

    //setters
    public void setId(long newId)
    {
        this.id = newId;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setPopulation(long newPopulation)
    {
        this.population = newPopulation;
    }

    public void setLandMass(int newLandMass)
    {
        this.landMass = newLandMass;
    }

    public void setMedianAge(int newMedianAge)
    {
        this.medianAge = newMedianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" + "id=" + id + ", name='" + name + '\'' + ", population=" + population + ", landMass=" + landMass + ", medianAge=" + medianAge + '}';
    }
}

package org.baali.base;

public class Couple
{
    private Male male;

    private Female female;

    public Couple()
    {

    }

    public Couple(Male male, Female female)
    {
        this.male = male;
        this.female = female;
    }

    public Male getMale()
    {
        return male;
    }

    public void setMale(Male male)
    {
        this.male = male;
    }

    public Female getFeMale()
    {
        return female;
    }

    public void setFemale(Female female)
    {
        this.female = female;
    }

   /* @Override
    public String toString()
    {
        return String.format("Male: %s, Female: %s", male, "b");
    }*/
}

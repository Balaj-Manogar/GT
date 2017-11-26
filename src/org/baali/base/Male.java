package org.baali.base;

public class Male extends Person
{


    public Male(){}

    public Male(String theName)
    {
        super(theName, Gender.MALE);
    }



    public Couple marry(Female wife)
    {
        // since men don't have special privilege
        // at least i want to give this privilege to set partner
        getCouple().setMale(this);
        getCouple().setFemale(wife);
        wife.getCouple().setMale(this);
        wife.getCouple().setFemale(wife);
        return this.getCouple();
    }
}

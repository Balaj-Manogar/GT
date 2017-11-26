package org.baali.base;

import java.util.List;

public interface IPerson extends LifePartner
{
    enum Gender
    {
        MALE, FEMALE
    }


    Couple getCouple();


    Couple getParents();


    List<Person> getSiblings();


    List<Person> getChildrens();


    String getName();


    String getGender();


}

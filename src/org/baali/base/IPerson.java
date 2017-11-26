package org.baali.base;

import java.util.List;

public interface IPerson extends LifePartner
{
    enum Gender
    {
        MALE, FEMALE
    }

    Person getCurrentPerson();

    Couple getCouple();


    Couple getParents();


    List<Person> getSiblings();


    List<Person> getChildrens();


    String getName();

    void setName(String name);

    String getGender();

    void setLevel(int level);

    int getLevel();

    void setFamilyName(String familyName);

    String getFamilyName();

    String getChildFamilyName();
}

package org.baali.base;

import java.util.List;

public interface IPerson extends LifePartner, IRelatives
{
    enum Gender
    {
        MALE, FEMALE
    }

    IPerson getCurrentPerson();

    Couple getCouple();


    Couple getParents();


    List<IPerson> getSiblings();


    List<IPerson> getChildrens();


    String getName();

    void setName(String name);

    String getGender();

    void setLevel(int level);

    int getLevel();

    void setFamilyName(String familyName);

    String getFamilyName();

    String getChildFamilyName();
}

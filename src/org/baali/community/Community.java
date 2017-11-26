package org.baali.community;

import org.baali.base.Couple;
import org.baali.base.Female;
import org.baali.base.Male;
import org.baali.base.Person;

import java.util.List;
import java.util.function.Predicate;

public abstract class Community
{

    public Couple marriageService(Person husband, Person wife)
    {
        ((Male) husband).marry((Female) wife);
        return husband.getCouple();
    }

    public Couple deliveryService(Person mom, Person child)
    {
        Female mother = (Female) mom;
        mother.addChild(child);
        return mom.getCouple();
    }

    abstract public List<Person> getChildrensTypeService(Person person, Predicate<Person> constraint);

    abstract public Person getRelationship(Person from, Person to);

    public Person getBoyBaby(String theName)
    {
        Person boy = new Male(theName);
        boy.setFamilyName(getCommunityName());
        return boy;
    }

    public Person getGirlBaby(String theName)
    {
        Person girl = new Female(theName);
        girl.setFamilyName(getCommunityName());
        return girl;
    }

    abstract public String getCommunityName();
}

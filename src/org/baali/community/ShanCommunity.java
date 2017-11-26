package org.baali.community;

import org.baali.base.Couple;
import org.baali.base.Female;
import org.baali.base.Person;
import org.baali.base.Male;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShanCommunity
{
    private static final String SHAN_FAMILY_NAME = "SHAN";
    public static Predicate<Person> femaleChildren = c -> c.getGender().equalsIgnoreCase("female");

    public static Couple marriageService(Person husband, Person wife)
    {
        ((Male)husband).marry((Female)wife);
        return null;
    }

    public static Couple deliveryService(Person mom, Person child)
    {
        Female mother = (Female)mom;
        child.setFamilyName(SHAN_FAMILY_NAME);
        mother.addChild(child);
        return mom.getCouple();
    }

    public static Person getRelationship(Person from, Person to)
    {
        return null;
    }

    public static List<Person> getChildrensTypeService(Person person, Predicate<Person> constraint){
        return  person.getChildrens().stream().filter(constraint).collect(Collectors.toList());
    }

}

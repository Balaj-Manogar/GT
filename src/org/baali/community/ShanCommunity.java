package org.baali.community;

import org.baali.base.Couple;
import org.baali.base.Person;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShanCommunity extends Community
{

    private static ShanCommunity instance;
    public static Predicate<Person> femaleChildren = c -> c.getGender().equalsIgnoreCase("female");

    public static ShanCommunity getInstance()
    {
        if (instance == null)
        {
            synchronized (ShanCommunity.class)
            {
                if (instance == null)
                {
                    instance = new ShanCommunity();
                    instance.COMMUNITY_NAME = "SHAN";
                }
            }
        }
        return instance;
    }


    @Override
    public Couple deliveryService(Person mom, Person child)
    {
        //child.setFamilyName(SHAN_FAMILY_NAME);
        return super.deliveryService(mom, child);
    }

    public Person getRelationship(Person from, Person to)
    {
        return null;
    }

    public List<Person> getChildrensTypeService(Person person, Predicate<Person> constraint)
    {
        return person.getChildrens().stream().filter(constraint).collect(Collectors.toList());
    }


}

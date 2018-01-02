package org.baali.community;

import org.baali.base.Couple;
import org.baali.base.Person;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RedCommunity extends Community
{
    private static RedCommunity instance;
    public static Predicate<Person> femaleChildren = c -> c.getGender().equalsIgnoreCase("female");

    public static RedCommunity getInstance()
    {
        if (instance == null)
        {
            synchronized (RedCommunity.class)
            {
                if (instance == null)
                {
                    instance = new RedCommunity();
                    instance.COMMUNITY_NAME = "RED";
                }
            }
        }
        return instance;
    }

    @Override
    public Couple deliveryService(Person mom, Person child)
    {
        child.setFamilyName(COMMUNITY_NAME);
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

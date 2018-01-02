package org.baali.community;

import org.baali.base.Couple;
import org.baali.base.Person;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BluCommunity extends Community
{
    private static BluCommunity instance;
    public static Predicate<Person> femaleChildren = c -> c.getGender().equalsIgnoreCase("female");

    public static BluCommunity getInstance()
    {
        if (instance == null)
        {
            synchronized (BluCommunity.class)
            {
                if (instance == null)
                {
                    instance = new BluCommunity();
                    instance.COMMUNITY_NAME = "BLU";
                }
            }
        }
        return instance;
    }

    @Override
    public Couple deliveryService(Person mom, Person child)
    {
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

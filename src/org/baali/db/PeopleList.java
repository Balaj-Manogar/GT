package org.baali.db;

import org.baali.base.IPerson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PeopleList
{
    private static Map<String, List<IPerson>> people = new HashMap<>();

    public static void add(IPerson person)
    {
        String name = person.getName();
        if (Objects.isNull(people.get(name)))
        {
            List<IPerson> nameList = new ArrayList<>();
            nameList.add(person);
            people.put(name, nameList);
        }
        else
        {
            people.get(name).add(person);
        }
    }

    public static List<IPerson> getByName(String theName)
    {
        return people.get(theName);
    }

    public static String getPeopleNames()
    {
        return people.keySet().toString() + "\nSize: " + people.keySet().size();
    }
}

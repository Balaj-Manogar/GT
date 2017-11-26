package org.baali.base;

import org.baali.db.PeopleList;
import org.baali.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Person implements IPerson
{
    private static int idGenerator = 1000;
    protected int id;
    private String name;
    private String gender;
    private String familyName;
    private int level;

    private Couple couple;
    private List<Person> childrens;
    private Couple parents;
    private List<Person> siblings;
    private Map<String, List<Person>> cousinsList;

    private Person()
    {
        couple = new Couple();
        childrens = new ArrayList<>();
        parents = new Couple();
        siblings = new ArrayList<>();
        cousinsList = new HashMap<>();
        this.id = idGenerator++;
    }

    public Person(String theName, Gender theGender)
    {
        this();
        this.name = theName;
        this.gender = theGender.name();
        this.familyName = name;
        PeopleList.add(this);

    }

    public Person getCurrentPerson()
    {
        return this;
    }

    @Override
    public String getChildFamilyName()
    {
        return StringUtils.isBlank(familyName) ? name : familyName;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void setName(String theName)
    {
        this.name = theName;
    }

    @Override
    public String getGender()
    {
        return this.gender;
    }

    @Override
    public void setLevel(int theLevel)
    {
        this.level = theLevel;
    }

    @Override
    public int getLevel()
    {
        return this.level;
    }

    @Override
    public void setFamilyName(String theFamilyName)
    {
        this.familyName = theFamilyName;
    }

    @Override
    public String getFamilyName()
    {
        return familyName;
    }

    @Override
    public Couple getCouple()
    {
        return couple;
    }

    @Override
    public List<Person> getSiblings()
    {
        return siblings;
    }

    @Override
    public Couple getParents()
    {
        return parents;
    }

    public List<Person> getChildrens()
    {
        return this.childrens;
    }


    public void setCousinsList(Map<String, List<Person>> theRelatives)
    {
        this.cousinsList = theRelatives;
    }

    public Map<String, List<Person>> getCousinsList()
    {
        return this.cousinsList;
    }

    @Override
    public String toString()
    {
        String border = "----------------------------------------------------";

        String dadName = Objects.nonNull(parents.getMale()) ? parents.getMale().getName() : null;
        String momName = Objects.nonNull(parents.getFeMale()) ? parents.getFeMale().getName() : null;

        String husbandName = Objects.nonNull(couple.getMale()) ? couple.getMale().getName() : null;
        String wifeName = Objects.nonNull(couple.getFeMale()) ? couple.getFeMale().getName() : null;

        String childrensName = "[]";
        if (Objects.nonNull(childrens) && childrens.size() > 0)
        {
            childrensName = childrens.stream().map(c -> c.getName()).collect(Collectors.joining(", "));
        }

        String siblingsName = "[]";
        if (Objects.nonNull(siblings) && siblings.size() > 0)
        {
            siblingsName = siblings.stream().map(c -> c.getName()).collect(Collectors.joining(", "));
        }

        String relativesName = "[]";
        if (Objects.nonNull(cousinsList) && cousinsList.size() > 0)
        {
            relativesName = cousinsList.values().stream().
                    flatMap(list -> list.stream().map(rel -> rel.getName())).collect(Collectors.joining(","));
        }

        return String.format("ID: %d, Name: %s, Gender: %s, " + " Family name: %s" +
                        "\nSiblings: %s \nParents{Mom: %s, Dad: %s), " +
                        "\nCouple{Husband: %s, Wife: %s}, \nChildren: %s\n" +
                        "Relatives: %s\n"
                , id, name, gender, getFamilyName(),
                siblingsName, momName, dadName, husbandName, wifeName, childrensName, relativesName);
    }

   /* @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Person person = (Person) o;

        return name.equals(person.name);
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }*/

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Person person = (Person) o;

        if (id != person.id)
        {
            return false;
        }
        return name.equals(person.name);
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}

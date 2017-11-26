package org.baali.base;

import org.baali.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Person implements IPerson
{
    private String name;
    private String gender;
    private String familyName;
    private int level;

    private Couple couple;
    private List<IPerson> childrens;
    private Couple parents;
    private List<IPerson> siblings;
    private Map<String, List<IPerson>> currentGenerationRelatives;

    public Person()
    {
        couple = new Couple();
        childrens = new ArrayList<>();
        parents = new Couple();
        siblings = new ArrayList<>();
        currentGenerationRelatives = new HashMap<>();

    }

    public Person(String theName, Gender theGender)
    {
        this();
        this.name = theName;
        this.gender = theGender.name();
        this.familyName = name;
    }

    public IPerson getCurrentPerson()
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
    public List<IPerson> getSiblings()
    {
        return siblings;
    }

    @Override
    public Couple getParents()
    {
        return parents;
    }

    public List<IPerson> getChildrens()
    {
        return this.childrens;
    }


    @Override
    public void setCurrentGenerationRelatives(Map<String, List<IPerson>> theRelatives)
    {
        this.currentGenerationRelatives = theRelatives;
    }

    @Override
    public Map<String, List<IPerson>> getCurrentGenerationRelatives()
    {
        return this.currentGenerationRelatives;
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
        if (Objects.nonNull(currentGenerationRelatives) && currentGenerationRelatives.size() > 0)
        {
            relativesName = currentGenerationRelatives.values().stream().
                    flatMap(list -> list.stream().map(rel -> rel.getName())).collect(Collectors.joining(","));
        }

        return String.format("Name: %s, Gender: %s, " + " Family name: %s" +
                        "\nSiblings: %s \nParents{Mom: %s, Dad: %s), " +
                        "\nCouple{Husband: %s, Wife: %s}, \nChildren: %s\n" +
                        "Relatives: %s\n"
                , name, gender, getFamilyName(),
                siblingsName, momName, dadName, husbandName, wifeName, childrensName, relativesName);
    }

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

        return name.equals(person.name);
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }
}

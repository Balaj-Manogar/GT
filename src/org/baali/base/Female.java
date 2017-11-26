package org.baali.base;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Female extends Person implements SpecialPrivilege
{

    public Female()
    {
    }


    public Female(String theName)
    {
        super(theName, Gender.FEMALE);
    }


    @Override
    public void addChild(IPerson child)
    {
        String childFamilyName = child.getChildFamilyName();
        //child.setFamilyName(childFamilyName);
        child.getParents().setMale(getCouple().getMale());
        child.getParents().setFemale(getCouple().getFeMale());
        addChildToParents(child);
        addSiblings(getChildrens(), child);
        addRelatives(child, getCouple());
        if (getParents().getMale() != null)
        {
            String names = getParents().getMale().getChildrens().stream()
                    .flatMap(c -> c.getChildrens().stream())
                    .map(s -> s.getName())
                    .collect(joining(","));
            names = names.replace(child.getName(), "");
            //System.out.println("Child Name: " + child.getName() + ", Parent: " + child.getParents().getMale().getName());
            //System.out.println("Names:: " + names);
        }

    }


    private void addChildToParents(IPerson child)
    {
        getChildrens().add(child);
        getCouple().getMale().getChildrens().add(child);
    }

    private void addSibling(IPerson child)
    {
        child.getSiblings().add(child);
    }

    private void addSiblings(List<IPerson> siblings, IPerson child)
    {
        siblings.forEach(s -> {
            s.getSiblings().clear();
            s.getSiblings().addAll(siblings);
            s.getSiblings().remove(s);
        });
    }

    private void addRelatives(IPerson child, Couple couple)
    {
        Male dad = couple.getMale();
        Female mom = couple.getFeMale();
        String dadFamilyName = dad.getFamilyName();
        String momFamilyName = mom.getFamilyName();

      /*  System.out.println("SSSSSS: " + child.getName() + ", " + couple.getMale().getSiblings()
                .stream().map(m -> m.getName())
                .collect(joining(",")) + " ......");
        System.out.println("MMMMMMM: " + child.getName() + ", " + couple.getFeMale().getSiblings()
                .stream().map(m -> m.getName())
                .collect(joining(",")) + " ......");*/


        List<IPerson> dadSiblingsChildren = dad.getSiblings().stream()
                .flatMap(Female::currentGenerationRelativesStream)
                .collect(Collectors.toList());

        List<IPerson> momSiblingsChildren = mom.getSiblings().stream()
                .flatMap(Female::currentGenerationRelativesStream)
                .collect(Collectors.toList());


        child.getCurrentGenerationRelatives().clear();

        child.getCurrentGenerationRelatives().put(dadFamilyName, dadSiblingsChildren);
        child.getCurrentGenerationRelatives().put(momFamilyName, momSiblingsChildren);

       dadSiblingsChildren.stream().filter(d -> {
           //List<IPerson> hasFamilyNameInRelatives = d.getCurrentGenerationRelatives().get(d.getFamilyName());
           List<IPerson> hasFamilyNameInRelatives = d.getCurrentGenerationRelatives().get(d.getFamilyName());
           boolean isNotSibling = !d.getSiblings().contains(d);
           return isNotSibling && Objects.nonNull(hasFamilyNameInRelatives) && !hasFamilyNameInRelatives.contains(child);
       }).forEach(d -> addRelatives(d, d.getParents()));

        momSiblingsChildren.stream().filter(d -> {
            //List<IPerson> hasFamilyNameInRelatives = d.getCurrentGenerationRelatives().get(d.getFamilyName());
            List<IPerson> hasFamilyNameInRelatives = d.getCurrentGenerationRelatives().get(d.getFamilyName());
            boolean isNotSibling = !d.getSiblings().contains(d);
            return isNotSibling && Objects.nonNull(hasFamilyNameInRelatives) && !hasFamilyNameInRelatives.contains(child);
        }).forEach(d -> addRelatives(d, d.getParents()));

        Function<IPerson, Predicate<IPerson>> updateRelatives = currentChild -> {
            Predicate<IPerson> updateRelativesPredicate = d -> {
                List<IPerson> hasFamilyNameInRelatives = d.getCurrentGenerationRelatives().get(d.getFamilyName());
                boolean isNotSibling = !d.getSiblings().contains(d);
                return isNotSibling && Objects.nonNull(hasFamilyNameInRelatives) && !hasFamilyNameInRelatives.contains(currentChild);
            };
            return updateRelativesPredicate;
        };

        //dadSiblingsChildren.forEach();



        //System.out.println(child.getName() + ", " + dadFamilyName + ", " + momFamilyName);


    }

    private static Stream<? extends IPerson> currentGenerationRelativesStream(IPerson sibling)
    {
        return sibling.getChildrens().stream();
    }


    private int addLevel()
    {
        if (getParents().getMale() == null)
        {
            return getLevel();
        }
        int level = getParents().getMale().getLevel();
        return ++level;
    }
}

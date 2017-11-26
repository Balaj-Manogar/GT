package org.baali.base;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Female extends Person implements SpecialPrivilege
{



    public Female(String theName)
    {
        super(theName, Gender.FEMALE);
    }


    @Override
    public void addChild(Person child)
    {
        String childFamilyName = child.getChildFamilyName();
        //child.setFamilyName(childFamilyName);
        child.getParents().setMale(getCouple().getMale());
        child.getParents().setFemale(getCouple().getFeMale());
        addChildToParents(child);
        addSiblings(getChildrens(), child);
        addRelatives(child, getCouple());
    }


    private void addChildToParents(Person child)
    {
        getChildrens().add(child);
        getCouple().getMale().getChildrens().add(child);
    }

    private void addSibling(Person child)
    {
        child.getSiblings().add(child);
    }

    private void addSiblings(List<Person> siblings, Person child)
    {
        siblings.forEach(s -> {
            s.getSiblings().clear();
            s.getSiblings().addAll(siblings);
            s.getSiblings().remove(s);
        });
    }

    private void addRelatives(Person child, Couple couple)
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


        /*List<IPerson> dadSiblingsChildren = dad.getSiblings().stream()
                .flatMap(Female::currentGenerationRelativesStream)
                .collect(Collectors.toList());

        List<IPerson> momSiblingsChildren = mom.getSiblings().stream()
                .flatMap(Female::currentGenerationRelativesStream)
                .collect(Collectors.toList());*/

        List<Person> dadSiblingsChildren = currentGenerationRelativesList(dad.getSiblings().stream());
        List<Person> momSiblingsChildren = currentGenerationRelativesList(mom.getSiblings().stream());
        child.getCousinsList().clear();

        child.getCousinsList().put(dadFamilyName, dadSiblingsChildren);
        child.getCousinsList().put(momFamilyName, momSiblingsChildren);

        updateRelativesInCousins(child, dadSiblingsChildren);
        updateRelativesInCousins(child, momSiblingsChildren);

       /* dadSiblingsChildren.stream().filter(d -> {
            //List<IPerson> hasFamilyNameInRelatives = d.getCousinsList().get(d.getFamilyName());
            List<IPerson> hasFamilyNameInRelatives = d.getCousinsList().get(d.getFamilyName());
            boolean isNotSibling = !d.getSiblings().contains(d);
            return isNotSibling && Objects.nonNull(hasFamilyNameInRelatives) && !hasFamilyNameInRelatives.contains(child);
        }).forEach(d -> addRelatives(d, d.getParents()));

        momSiblingsChildren.stream().filter(d -> {
            //List<IPerson> hasFamilyNameInRelatives = d.getCousinsList().get(d.getFamilyName());
            List<IPerson> hasFamilyNameInRelatives = d.getCousinsList().get(d.getFamilyName());
            boolean isNotSibling = !d.getSiblings().contains(d);
            return isNotSibling && Objects.nonNull(hasFamilyNameInRelatives) && !hasFamilyNameInRelatives.contains(child);
        }).forEach(d -> addRelatives(d, d.getParents()));
*/

     /*   Function<IPerson, Predicate<IPerson>> updateRelatives = currentChild -> {
            Predicate<IPerson> updateRelativesPredicate = d -> {
                List<IPerson> hasFamilyNameInRelatives = d.getCousinsList().get(d.getFamilyName());
                boolean isNotSibling = !d.getSiblings().contains(d);
                return isNotSibling && Objects.nonNull(hasFamilyNameInRelatives) && !hasFamilyNameInRelatives.contains(currentChild);
            };
            return updateRelativesPredicate;
        };

        Consumer<IPerson> addMissedRelatives = r -> addRelatives(r, r.getParents());*/

    }

    private void updateRelativesInCousins(Person child, List<Person> siblingsChildren)
    {
        siblingsChildren.stream().filter(d -> {
            //List<IPerson> hasFamilyNameInRelatives = d.getCousinsList().get(d.getFamilyName());
            List<Person> hasFamilyNameInRelatives = d.getCousinsList().get(d.getFamilyName());
            boolean isNotSibling = !d.getSiblings().contains(d);
            return isNotSibling && Objects.nonNull(hasFamilyNameInRelatives) && !hasFamilyNameInRelatives.contains(child);
        }).forEach(d -> addRelatives(d, d.getParents()));
    }

    private List<Person> currentGenerationRelativesList(Stream<Person> relativeStream)
    {
        return relativeStream.flatMap(Female::currentGenerationRelativesStream)
            .collect(Collectors.toList());
    }


    private static Stream<? extends Person> currentGenerationRelativesStream(Person sibling)
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

package org.baali.community;

import org.baali.base.Couple;
import org.baali.base.Person;

import java.util.List;
import java.util.function.Predicate;

public interface ICommunity
{
    Couple marriageService(Person husband, Person wife);

    Couple deliveryService(Person mom, Person child);

    ICommunity getInstance();

    List<Person> getChildrensTypeService(Person person, Predicate<Person> constraint);

    Person getRelationship(Person from, Person to);
}

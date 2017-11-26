package org.baali.family;

import org.baali.base.Couple;
import org.baali.base.Female;
import org.baali.base.IPerson;
import org.baali.base.Male;

public class ShanCommunity
{
    private static final String SHAN_FAMILY_NAME = "SHAN";

    public static Couple marriage(IPerson husband, IPerson wife)
    {
        ((Male)husband).marry((Female)wife);
        return null;
    }

    public static Couple addChild(IPerson mom, IPerson child)
    {
        Female mother = (Female)mom;
        child.setFamilyName(SHAN_FAMILY_NAME);
        mother.addChild(child);
        return mom.getCouple();
    }

    public static IPerson getRelationship(IPerson from, IPerson to)
    {
        return null;
    }

}

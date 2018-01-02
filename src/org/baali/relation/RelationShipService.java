package org.baali.relation;

import org.baali.base.IPerson;

import java.util.List;
import java.util.Map;

public class RelationShipService
{


    private Map<String, String> relationType;

    private List<RelationKey> relationKeys;

    public enum RelationType
    {
        GRA_DAD, GRA_MOM, MOM, DAD, SON,
        DAUGHTER, BROTHER, SISTER, WIFE, HUSBAND,
        SON_IN_LAW, DAU_IN_LAW, DAD_BRO_WIFE, COU_MALE,
        COU_FEM, COU_WIFE, COU_HUS, WIFE_BRO, HUS_BRO,
        DAD_BRO, MOM_BRO, MOM_HUS_BRO, DAD_SIS, MOM_SIS
    }

    // this data will come from some service in production (DB)
    public static void generateExistingRelations()
    {
        // 1
        RelationKey grandFather = new RelationKey("GRA_DAD", DefaultRelationOptions.NA, IPerson.Gender.MALE, "Grand " +
                "Father");
        RelationKey grandMother = new RelationKey("GRA_MOM", DefaultRelationOptions.NA, IPerson.Gender.FEMALE, "Grand " +
                "Mother");
        RelationKey dad = new RelationKey("DAD", DefaultRelationOptions.NA, IPerson.Gender.MALE, "Dad");
        RelationKey mom = new RelationKey("MOM", DefaultRelationOptions.NA, IPerson.Gender.FEMALE, "Mom");
        RelationKey son = new RelationKey("SON", DefaultRelationOptions.NA, IPerson.Gender.MALE, "Son");
        // 2
        RelationKey daughter = new RelationKey("DAUGHTER", DefaultRelationOptions.NA, IPerson.Gender.FEMALE, "Daughter");
        RelationKey brother = new RelationKey("BROTHER", DefaultRelationOptions.NA, IPerson.Gender.MALE, "Brother");
        RelationKey sister = new RelationKey("SISTER", DefaultRelationOptions.NA, IPerson.Gender.FEMALE, "Sister");
        RelationKey wife = new RelationKey("WIFE", DefaultRelationOptions.NA, IPerson.Gender.FEMALE, "Wife");
        RelationKey husband = new RelationKey("HUSBAND", DefaultRelationOptions.NA, IPerson.Gender.MALE, "Husband");
        // 3
        RelationKey sonInLaw = new RelationKey("SON_IN_LAW", DefaultRelationOptions.NA, IPerson.Gender.MALE, "Son In " +
                "Law");
        RelationKey sonWifeBrother = new RelationKey("SON_WIFE_BRO", DefaultRelationOptions.NA, IPerson.Gender.MALE,
                "Son In Law", "Son's wife brother");
        RelationKey sonWife = new RelationKey("SON_WIFE", DefaultRelationOptions.NA, IPerson.Gender.FEMALE,
                "Daughter In Law", "Son's wife");
        RelationKey sonWifeSister = new RelationKey("DAU_IN_LAW", DefaultRelationOptions.NA, IPerson.Gender.FEMALE,
                "Daughter In Law", "Son's wife sister");
        RelationKey sonWifeBrotherWife = new RelationKey("SON_WIFE_BRO_WIFE", DefaultRelationOptions.NA, IPerson.Gender
                .FEMALE, "Daughter In Law", "son's wife brother wife");
        //4
        RelationKey sonWifeSisterHusband = new RelationKey("SON_WIFE_SIS_HUS", DefaultRelationOptions.NA, IPerson.Gender
                .MALE, "Son In Law", "Son's wife's sister husband");


        RelationKey daughterHusband = new RelationKey("DAU_HUS", DefaultRelationOptions.NA, IPerson.Gender.MALE,
                "Son In Law", "daughter's husband");
        RelationKey daughterHusbandBrother = new RelationKey("DAU_HUS_BRO", DefaultRelationOptions.NA, IPerson.Gender.MALE,
                "Son In Law", "daughter's husband brother");
        RelationKey daughterHusbandBrotherWife = new RelationKey("DAU_HUS_BRO_WIFE", DefaultRelationOptions.NA, IPerson
                .Gender.FEMALE, "Daughter In Law", "Daughter husband brother wife");
        RelationKey daughterHusbandSister = new RelationKey("DAU_HUS_SIS", DefaultRelationOptions.NA, IPerson.Gender.FEMALE,
                "Daughter In Law", "daughter husband sister");
        //5
        RelationKey daughterHusbandSisterHusband = new RelationKey("DAU_HUS_SIS_HUS", DefaultRelationOptions.NA, IPerson
                .Gender.MALE, "Son In Law", "daughter's husband sister husband");
        RelationKey cousinMale = new RelationKey("COU_MALE", DefaultRelationOptions.NA, IPerson.Gender.MALE, "Cousin");
        RelationKey cousinFemale = new RelationKey("COU_FEM", DefaultRelationOptions.NA, IPerson.Gender.FEMALE, "Cousin");
        RelationKey cousinWife = new RelationKey("COU_WIFE", DefaultRelationOptions.NA, IPerson.Gender.FEMALE, "Cousin's" +
                " Wife");
        RelationKey cousinHusband = new RelationKey("COU_HUS", DefaultRelationOptions.NA, IPerson.Gender.MALE, "Cousin's" +
                " Husband");
        //6
        RelationKey wifeBrother = new RelationKey("WIFE_BRO", DefaultRelationOptions.NA, IPerson.Gender.MALE, "Brother " +
                "In Law", "wife's brother");
        RelationKey wifeBrotherWife = new RelationKey("WIFE_BRO_WIFE", DefaultRelationOptions.NA, IPerson.Gender.FEMALE,
                "Sister " + "In Law", "Wife's brother's wife");
        RelationKey wifeSister = new RelationKey("WIFE_SIS", DefaultRelationOptions.NA, IPerson.Gender.FEMALE,
                "Sister " + "In Law", "Wife's Sister");
        RelationKey wifeSisterHusband = new RelationKey("WIFE_SIS_HUS", DefaultRelationOptions.NA, IPerson.Gender.MALE,
                "Brother " + "In Law", "Wife's Sister's husband");
        //7
        RelationKey husbandBrother = new RelationKey("HUS_BRO", DefaultRelationOptions.NA, IPerson.Gender.MALE,
                "Brother In Law", "husband's brother");
        RelationKey husbandBrotherWife = new RelationKey("HUS_BRO_WIFE", DefaultRelationOptions.NA, IPerson.Gender.FEMALE,
                "Sister " + "In Law", "Husband brother's wife");
        RelationKey husbandSister = new RelationKey("HUS_SIS", DefaultRelationOptions.NA, IPerson.Gender.FEMALE,
                "Sister In Law", "husband sister");
        RelationKey husbandSisterHusband = new RelationKey("HUS_SIS_HUS", DefaultRelationOptions.NA, IPerson.Gender.MALE,
                "Brother In Law", "husband's sister husband");
        RelationKey dadBrother = new RelationKey("DAD_BRO", DefaultRelationOptions.NA, IPerson.Gender.MALE, "Paternal " +
                "Uncle", "dad's brother");
        //8
        RelationKey dadBrotherWife = new RelationKey("DAD_BRO_WIFE", DefaultRelationOptions.NA, IPerson.Gender.FEMALE,
                "Paternal Aunt", "dad's brother wife");
        RelationKey dadSister = new RelationKey("DAD_SIS", DefaultRelationOptions.NA, IPerson.Gender.FEMALE, "Paternal " +
                "Aunt");
        RelationKey dadSisterHusband = new RelationKey("DAD_SIS_HUS", DefaultRelationOptions.NA, IPerson.Gender.MALE,
                "Paternal Uncle", "dad's sister husband");
        RelationKey momBrother = new RelationKey("MOM_BRO", DefaultRelationOptions.NA, IPerson.Gender.MALE,
                "maternal uncle", "mom's brother");
        RelationKey momBrotherWife = new RelationKey("MOM_BRO_WIFE", DefaultRelationOptions.NA, IPerson.Gender.FEMALE,
                "maternal aunt", "mom's brother wife");
        //
        RelationKey momSister = new RelationKey("MOM_SIS", DefaultRelationOptions.NA, IPerson.Gender.FEMALE, "Maternal " +
                "aunt");
        RelationKey momSisterHusband = new RelationKey("MOM_SIS_HUS", DefaultRelationOptions.NA, IPerson.Gender.MALE,
                "maternal uncle", "mom sister's husband ");


    }
}



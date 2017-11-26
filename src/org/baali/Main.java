package org.baali;

import org.baali.base.Female;
import org.baali.base.Male;
import org.baali.base.IPerson;
import org.baali.base.SpecialPrivilege;
import org.baali.family.ShanCommunity;

public class Main {

    public static void main(String[] args) {
        IPerson kingShan = new Male("Shan");
        IPerson queenAngs = new Female("Anga");

        ShanCommunity.marriage(kingShan, queenAngs);

        System.out.println("Queen Anga gets child now");
        // 1st gen
        IPerson ish = new Male("Ish");
        IPerson chit = new Male("Chit");
        IPerson vich = new Male("Vich");
        IPerson satya = new Female("Satya");
        ShanCommunity.addChild(queenAngs, ish);
        ShanCommunity.addChild(queenAngs, chit);
        ShanCommunity.addChild(queenAngs, vich);
        ShanCommunity.addChild(queenAngs, satya);
//        System.out.println(ish);
//        System.out.println(chit);
//        System.out.println(satya);

        // 1st gen partners
        IPerson ambi = new Female("Ambi");
        IPerson lika = new Female("Lika");
        IPerson vyan = new Male("Vyan");
        ShanCommunity.marriage(chit, ambi);
        ShanCommunity.marriage(vich, lika);
        ShanCommunity.marriage(vyan, satya);

        /*System.out.println(ish);
        System.out.println(chit);
        System.out.println(vich);
        System.out.println(satya);*/

        // 2nd gen - Chit
        IPerson drita = new Male("Drita");
        IPerson vrita = new Male("Vrita");
        // 2nd gen - Vich
        IPerson vila = new Male("Vila");
        IPerson chika = new Female("Chika");
        // 2nd gen - satya
        IPerson satvy = new Female("Satvy");
        IPerson savya = new Male("Savya");
        IPerson saayan = new Male("Saayan");

        // 2nd gen  adding child(Chit)
        ShanCommunity.addChild(ambi, drita);
        ShanCommunity.addChild(ambi, vrita);
        // 2nd gen  adding child(LIKA)
        ShanCommunity.addChild(lika, vila);
        ShanCommunity.addChild(lika, chika);
        // 2nd gen  adding child(satya)
        // since she is not shan family we are adding
        // her childs directly
        ((SpecialPrivilege)satya).addChild(satvy);
        ((SpecialPrivilege)satya).addChild(savya);
        ((SpecialPrivilege)satya).addChild(saayan);

        // 2nd gen partners -
        IPerson jaya = new Female("Jaya");
        IPerson jnki = new Female("Jnki");
        IPerson kpila = new Male("Kpila");
        IPerson asva = new Male("Asva");
        IPerson krpi = new Female("Krpi");
        IPerson mina = new Female("Mina");


        // 2nd gen marriage
        ShanCommunity.marriage(drita, jaya);
        ShanCommunity.marriage(vila, jnki);
        ShanCommunity.marriage(kpila, chika);
        // since they are coming from royal community
        // marriage will be based on shan culture
        ShanCommunity.marriage(asva, satvy);
        ShanCommunity.marriage(savya, krpi);
        ShanCommunity.marriage(saayan, mina);

        System.out.println(drita);
//      System.out.println(jaya);
        System.out.println(vrita);
       System.out.println(vila);
//        System.out.println(jnki);
//        System.out.println(chika);
//        System.out.println(kpila);
//        System.out.println(satvy);
//        System.out.println(asva);
//        System.out.println(savya);
//        System.out.println(krpi);
//        System.out.println(saayan);
//        System.out.println(mina);



       // System.out.println(drita);

      //  System.out.println(kingShan);
       // System.out.println(queenAngs);



    }
}

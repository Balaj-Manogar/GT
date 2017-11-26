package org.baali;

import org.baali.base.Female;
import org.baali.base.Male;
import org.baali.base.Person;
import org.baali.db.PeopleList;
import org.baali.community.ShanCommunity;

public class Main
{

    public static void main(String[] args)
    {
        Person kingShan = new Male("Shan");
        Person queenAngs = new Female("Anga");

        ShanCommunity.marriageService(kingShan, queenAngs);

        System.out.println("Queen Anga gets child now");
        // 1st gen
        Person ish = new Male("Ish");
        Person chit = new Male("Chit");
        Person vich = new Male("Vich");
        Person satya = new Female("Satya");
        ShanCommunity.deliveryService(queenAngs, ish);
        ShanCommunity.deliveryService(queenAngs, chit);
        ShanCommunity.deliveryService(queenAngs, vich);
        ShanCommunity.deliveryService(queenAngs, satya);
//        System.out.println(ish);
//        System.out.println(chit);
//        System.out.println(satya);

        // 1st gen partners
        Person ambi = new Female("Ambi");
        Person lika = new Female("Lika");
        Person vyan = new Male("Vyan");
        ShanCommunity.marriageService(chit, ambi);
        ShanCommunity.marriageService(vich, lika);
        ShanCommunity.marriageService(vyan, satya);

        /*System.out.println(ish);
        System.out.println(chit);
        System.out.println(vich);
        System.out.println(satya);*/

        // 2nd gen - Chit
        Person drita = new Male("Drita");
        Person vrita = new Male("Vrita");
        // 2nd gen - Vich
        Person vila = new Male("Vila");
        Person chika = new Female("Chika");
        // 2nd gen - satya
        Person satvy = new Female("Satvy");
        Person savya = new Male("Savya");
        Person saayan = new Male("Saayan");

        // 2nd gen  adding child(Chit)
        ShanCommunity.deliveryService(ambi, drita);
        ShanCommunity.deliveryService(ambi, vrita);
        // 2nd gen  adding child(LIKA)
        ShanCommunity.deliveryService(lika, vila);
        ShanCommunity.deliveryService(lika, chika);
        // 2nd gen  adding child(satya)
        // since she is not shan family we are adding
        // her childs directly
        ((Female) satya).addChild(satvy);
        ((Female) satya).addChild(savya);
        ((Female) satya).addChild(saayan);

        // 2nd gen partners -
        Person jaya = new Female("Jaya");
        Person jnki = new Female("Jnki");
        Person kpila = new Male("Kpila");
        Person asva = new Male("Asva");
        Person krpi = new Female("Krpi");
        Person mina = new Female("Mina");


        // 2nd gen marriage
        ShanCommunity.marriageService(drita, jaya);
        ShanCommunity.marriageService(vila, jnki);
        ShanCommunity.marriageService(kpila, chika);
        // since they are coming from royal community
        // marriage will be based on shan culture
        ShanCommunity.marriageService(asva, satvy);
        ShanCommunity.marriageService(savya, krpi);
        ShanCommunity.marriageService(saayan, mina);

//        System.out.println(drita);
//      System.out.println(jaya);
//        System.out.println(vrita);
//        System.out.println(vila);
//        System.out.println(jnki);
//        System.out.println(chika);
//        System.out.println(kpila);
//        System.out.println(satvy);
//        System.out.println(asva);
//        System.out.println(savya);
//        System.out.println(krpi);
//        System.out.println(saayan);
//        System.out.println(mina);


        // 3rd gen - Drit
        Person jata = new Male("Jata");
        Person driya = new Female("Driya");

        // 3rd gen - Vila
        Person lavanya = new Female("Lavanya");

        // 3rd gen - Savya
        Person kriya = new Male("Kriya");

        // 3rd gen - Saayan
        Person misa = new Male("Misa");

        // 3rd gen partners
        Person mnu = new Male("Mnu");
        Person gru = new Male("Gru");

        ShanCommunity.deliveryService(jaya, jata);
        ShanCommunity.deliveryService(jaya, driya);
        ShanCommunity.deliveryService(jnki, lavanya);
        ShanCommunity.deliveryService(krpi, kriya);
        ShanCommunity.deliveryService(mina, misa);

        // 3rd gen marriage
        ShanCommunity.marriageService(mnu, driya);
        ShanCommunity.marriageService(gru, lavanya);

//        System.out.println(jata);
//        System.out.println(driya);
//        System.out.println(lavanya);
//        System.out.println(kriya);
//        System.out.println(misa);
//        System.out.println(drita);

        System.out.println(ShanCommunity.getChildrensTypeService(jaya, ShanCommunity.femaleChildren));
        System.out.println(PeopleList.getPeopleNames());

        //  System.out.println(kingShan);
        // System.out.println(queenAngs);


    }
}

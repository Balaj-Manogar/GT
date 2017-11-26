package org.baali;

import org.baali.base.Person;
import org.baali.community.BluCommunity;
import org.baali.community.Community;
import org.baali.community.RedCommunity;
import org.baali.community.ShanCommunity;
import org.baali.db.PeopleList;

public class Main
{

    public static void main(String[] args)
    {

        Community shanCommunity = ShanCommunity.getInstance();
        Community bluCommunity = BluCommunity.getInstance();
        Community redCommunity = RedCommunity.getInstance();

        Person kingShan = shanCommunity.getBoyBaby("Shan");

        Person queenAnga = redCommunity.getGirlBaby("Anga");

        shanCommunity.marriageService(kingShan, queenAnga);

//        System.out.println("Queen Anga gets child now");
        // 1st gen
        Person ish = shanCommunity.getBoyBaby("Ish");
        Person chit = shanCommunity.getBoyBaby("Chit");
        Person vich = shanCommunity.getBoyBaby("Vich");
        Person satya = shanCommunity.getGirlBaby("Satya");
        shanCommunity.deliveryService(queenAnga, ish);
        shanCommunity.deliveryService(queenAnga, chit);
        shanCommunity.deliveryService(queenAnga, vich);
        shanCommunity.deliveryService(queenAnga, satya);

        Person ambi = redCommunity.getGirlBaby("Ambi");
        Person lika = redCommunity.getGirlBaby("Lika");
        Person vyan = bluCommunity.getBoyBaby("Vyan");
        shanCommunity.marriageService(chit, ambi);
        shanCommunity.marriageService(vich, lika);
        bluCommunity.marriageService(vyan, satya);


        // 2nd gen - Chit
        Person drita = shanCommunity.getBoyBaby("Drita");
        Person vrita = shanCommunity.getBoyBaby("Vrita");
        // 2nd gen - Vich
        Person vila = shanCommunity.getBoyBaby("Vila");
        Person chika = shanCommunity.getGirlBaby("Chika");
        // 2nd gen - satya
        Person satvy = bluCommunity.getGirlBaby("Satvy");
        Person savya = bluCommunity.getBoyBaby("Savya");
        Person saayan = bluCommunity.getBoyBaby("Saayan");

        // 2nd gen  adding child(Chit)
        shanCommunity.deliveryService(ambi, drita);
        shanCommunity.deliveryService(ambi, vrita);
        // 2nd gen  adding child(LIKA)
        shanCommunity.deliveryService(lika, vila);
        shanCommunity.deliveryService(lika, chika);
        // 2nd gen  adding child(satya)
        bluCommunity.deliveryService(satya, satvy);
        bluCommunity.deliveryService(satya, savya);
        bluCommunity.deliveryService(satya, saayan);

        System.out.println(satvy);

        // 2nd gen partners -
        Person jaya = redCommunity.getGirlBaby("Jaya");
        Person jnki = redCommunity.getGirlBaby("Jnki");
        Person krpi = redCommunity.getGirlBaby("Krpi");
        Person mina = redCommunity.getGirlBaby("Mina");
        Person kpila = redCommunity.getBoyBaby("Kpila");
        Person asva = redCommunity.getBoyBaby("Asva");


        // 2nd gen marriage
        // just for readability
        secondGenMarriageService(shanCommunity, bluCommunity, redCommunity, drita, vila, chika, satvy, savya, saayan, jaya, jnki, krpi, mina, kpila, asva);



        // 3rd gen - Drit
        Person jata = shanCommunity.getBoyBaby("Jata");
        Person driya = shanCommunity.getGirlBaby("Driya");

        // 3rd gen - Vila
        Person lavanya = shanCommunity.getGirlBaby("Lavanya");

        // 3rd gen - Savya
        Person kriya = bluCommunity.getBoyBaby("Kriya");

        // 3rd gen - Saayan
        Person misa = bluCommunity.getBoyBaby("Misa");

        // 3rd gen partners
        Person mnu = redCommunity.getBoyBaby("Mnu");
        Person gru = redCommunity.getBoyBaby("Gru");

        thirdGenDeliveryService(shanCommunity, jaya, jnki, krpi, mina, jata, driya, lavanya, kriya, misa);

        // 3rd gen marriage
        thirdGenMarriageService(shanCommunity, driya, lavanya, mnu, gru);

        System.out.println(shanCommunity.getChildrensTypeService(jaya, ShanCommunity.femaleChildren));
        System.out.println(PeopleList.getPeopleNames());

        System.out.println(satvy);

        System.out.println(kingShan);
        System.out.println(queenAnga);


    }

    private static void secondGenMarriageService(Community shanCommunity, Community bluCommunity, Community redCommunity, Person drita, Person vila, Person chika, Person satvy, Person savya, Person saayan, Person jaya, Person jnki, Person krpi, Person mina, Person kpila, Person asva)
    {
        shanCommunity.marriageService(drita, jaya);
        shanCommunity.marriageService(vila, jnki);
        redCommunity.marriageService(kpila, chika);

        redCommunity.marriageService(asva, satvy);
        bluCommunity.marriageService(savya, krpi);
        bluCommunity.marriageService(saayan, mina);
    }

    private static void thirdGenMarriageService(Community shanCommunity, Person driya, Person lavanya, Person mnu, Person gru)
    {
        shanCommunity.marriageService(mnu, driya);
        shanCommunity.marriageService(gru, lavanya);
    }

    private static void thirdGenDeliveryService(Community shanCommunity, Person jaya, Person jnki, Person krpi, Person mina, Person jata, Person driya, Person lavanya, Person kriya, Person misa)
    {
        shanCommunity.deliveryService(jaya, jata);
        shanCommunity.deliveryService(jaya, driya);
        shanCommunity.deliveryService(jnki, lavanya);
        shanCommunity.deliveryService(krpi, kriya);
        shanCommunity.deliveryService(mina, misa);
    }
}

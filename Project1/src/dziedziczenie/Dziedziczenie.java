package dziedziczenie;

import dziedziczenie_potwory.Potwor;
import dziedziczenie_potwory.Szkielet;
import dziedziczenie_potwory.Zombie;

public class Dziedziczenie {

    public static void main(String[] args) {

        Potwor p;

//        Potwor potwor = new Potwor(10, 100);
//        System.out.println(potwor.getZywotnosc());
//        System.out.println(potwor.getPredkoscChodzenia());
//
//        Szkielet szkielet = new Szkielet(20,50, "Łuk");
//        szkielet.atakuj();
//        System.out.println(szkielet.getZywotnosc());
//        System.out.println(szkielet.getPredkoscChodzenia());
//
//
//        Zombie zombie = new Zombie(15,20);
//        System.out.println(zombie.getZywotnosc());
//        System.out.println(zombie.getPredkoscChodzenia());

        Potwor potwor1 = new Szkielet(10,100);
        Potwor potwor2 = new Zombie();

        potwor1.atakuj();
    }
}

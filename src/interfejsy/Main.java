package interfejsy;

import javax.sound.midi.Soundbank;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
//        nazwaInterfejsu a = new Pracownik();

//        ((Pracownik)a).getWynagrodzenie(); // downcasting - rzutowanie do klasy implementującej interfejs, aby dostać się do metod

        System.out.println(nazwaInterfejsu.PI);

        int[] tab = new int[3];

        tab[0] = 3;
        tab[1] = -5;
        tab[2] = 13;
        Arrays.sort(tab);
        System.out.println(tab[0]);

        Pracownik[] pracownik = new Pracownik[3];
        pracownik[0] = new Pracownik(10000);
        pracownik[1] = new Pracownik(1000);
        pracownik[2] = new Pracownik(5000);

        System.out.println("Przed sortowaniem: ");
        for (Pracownik p: pracownik)
        {
            System.out.println(p.getWynagrodzenie());
        }

        System.out.println(pracownik[0].compareTo(pracownik[1]));
        System.out.println();

//        Arrays.sort(pracownik);     //wymagane jest, aby zaimplementować intefejs Comperable w klasach, które mają korzystać z metody sort
        Arrays.sort(pracownik, Collections.reverseOrder());  //sortowanie malejąco; domyślnie jest rosnąco



//        System.out.println(pracownik[0].getWynagrodzenie());

        System.out.println("Po sortowaniu: ");
        for (Pracownik p: pracownik)
        {
            System.out.println(p.getWynagrodzenie());
        }

        System.out.println(pracownik[0].compareTo(pracownik[1]));



    }
}

interface nazwaInterfejsu {
    double PI = 3.14; //public (dostępna wszędzie, z innych pakunków) static (dostępne zawsze) final (stałe i niezmienne)

    void cos(); //public (dostępna wszędzie, z innych pakunków) abstract (musi zostać nadpisana w klasie, która będzie ją implementować)
}

interface cosik {

}


class Pracownik implements nazwaInterfejsu, cosik, Comparable  //wymagane jest, aby zaimplementować intefejs Comperable w klasach, które mają korzystać z metody sort
/*
od razu musimy zaimplementować wszystkie metody interfejsu (abstrakcyjne)
można implementować więcej niż 1 interfejs
 */ {

    @Override
    public void cos() {

    }

    Pracownik(double wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public double getWynagrodzenie() {
        return this.wynagrodzenie;
    }

    private double wynagrodzenie;


    @Override
    public int compareTo(Object o)
    {
       Pracownik przyslany = (Pracownik)o;

        if (this.wynagrodzenie < przyslany.wynagrodzenie)
            return -1; //jak jest return to funkcja wychodzi z instrukcji warunkowej

        if (this.wynagrodzenie > przyslany.wynagrodzenie)
            return 1;

        return 0;


    }
}
//
//class Programista extends Pracownik // ale rozszerzać możesz tylko JEDNĄ klasę
//{
//      //wymaga konstruktora w klasie, którą klasa Pracownik rozszerza
//}
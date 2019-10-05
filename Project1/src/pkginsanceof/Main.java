package pkginsanceof;

import javax.lang.model.util.ElementScanner6;

public class Main {
    public static void main(String[] args) {
        Osoba[] osoba = new Osoba[200];
        osoba[0] = new Pracownik("Kamil", "Ciepiela", 1000000);
        osoba[1] = new Student("Jan", "Nowak");
        osoba[2] = new Pracownik("Adam", "Nowak", 5000);

//        osoba[1].pobierzOpis();

//        for (int i = 0; i < osoba.length; i++)
//        {
//            if (osoba[i] instanceof Osoba)
//                osoba[i]. pobierzOpis();
//            else
//                break;
//        }

        for (Osoba person: osoba)
        {
            if (person instanceof Pracownik)
                ((Pracownik) person).pobierzOpis(); //RZUTOWANIE W DÓŁ
            else if (person instanceof Student)
                ((Student)person).pobierzOpis(); //RZUTOWANIE W DÓŁ

        }

//        {
//            if (person instanceof Osoba)
//                person.pobierzOpis();
//            else
//                break;
//        }
    }
}

abstract class Osoba
    {
        String imie;
        String nazwisko;

        Osoba(String imie, String nazwisko)
        {
            this.imie = imie;
            this.nazwisko = nazwisko;
        }

        abstract void pobierzOpis();

    }

    class Pracownik extends Osoba
    {
        double wynagrodzenie;

        Pracownik(String imie, String nazwisko, double wynagrodzenie)
        {
            super(imie, nazwisko);
            this.wynagrodzenie = wynagrodzenie;
        }

        @Override
        void pobierzOpis() {
            System.out.println("Jestem pracownikiem");
            System.out.println("Imię: " + imie);
            System.out.println("Nazwisko: " + nazwisko);
            System.out.println("Wynagrodzenie: " + wynagrodzenie);
        }
        void pracuj()
        {
            System.out.println("Ja pracuję");
        }
    }

    class Student extends Osoba
    {
        Student(String imie, String nazwisko)
        {
            super(imie, nazwisko);
        }

        @Override
        void pobierzOpis() {
            System.out.println("Jestem studentem");
            System.out.println("Imię: " + imie);
            System.out.println("Nazwisko: " + nazwisko);
        }
    }
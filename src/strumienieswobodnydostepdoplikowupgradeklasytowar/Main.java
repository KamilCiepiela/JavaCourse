package strumienieswobodnydostepdoplikowupgradeklasytowar;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main
{
    public static void main(String[] args)
    {

        Towar[] towar = new Towar[3];

        towar[0] = new Towar();
        towar[1] = new Towar(29.0, "Video Kurs Java");
        towar[2] = new Towar(39.0, "Video Kures C++", 2008, 11, 21);

        try
        {
            RandomAccessFile RAF = new RandomAccessFile("nowy2.txt", "rw");  //drugi parametr w postaci String - r - odczyt; w - zapis

//            towar[1].zapiszDane(RAF);  //zapis pojedynczego rekordu z tabeli

            Towar.zapiszDoPliku(towar, RAF); //zapis całej tabeli do pliku
            RAF.seek(0);  //dzięki temu cofamy się do początku

//            System.out.println(RAF.getFilePointer());

//            Towar a = new Towar();  // odczyt jednego rakordu z tablicy (bazy danych)
//            a.czytajDane(RAF);
//            System.out.println(a.pobierzCena());

            Towar[] towarki = Towar.odczytajZPliku(RAF);  // wczytanie wszystkich rekordów z tablicy

            for (int i = 0; i < towarki.length; i++)
            {
                System.out.println(towarki[i].pobierzCena());
                System.out.println(towarki[i].pobierzNazwa());
                System.out.println(towarki[i].pobierzDataWydania());
                System.out.println("------------------------------");
            }

            // odczytywanie pojedynczego rekordu
            /*
            int n = 2;  // nr rekordu
            RAF.seek((n-1)*Towar.DLUGOSC_REKORDU);  //n-1, bo liczba rekordów w tablicy zaczyna się od 0, nie od 1

            Towar a = new Towar();
            a.czytajDane(RAF);

            System.out.println(a);
            */

            try // instrukcja try-catch jest często lepsza niż if, bo nie wykona instrukcji późniejszej, znajdującej się po wyjątku, który przejmiemy
            {
                Towar b = new Towar();
                b.czytajRekord(RAF, 3);

                System.out.println(b);

                System.out.println("Jakaś dalsza operacja");
            }
            catch (BrakRekordu err)
            {
                System.out.println(err.getMessage());
            }

            RAF.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
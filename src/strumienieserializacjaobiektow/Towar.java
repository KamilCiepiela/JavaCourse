package strumienieserializacjaobiektow;

import java.io.*;
import java.util.*;

public class Towar implements Serializable  //trzeba zaimplementować intrefejs do serializacji, żeby dało się coś z pliku odczytać

// SERIALIZACJA POWODUJE ZWIĘKSZENIE PODATNOŚCI NA ATAKI HAKERÓW, DLATEGO NIE POWINNIŚMY DANYCH WRAŻLIWYCH, NP. HASEŁ !!!!!!!!!!!!!!!!!!!!!!!!!!!

{
    public Towar()
    {
        this.cena = 0.0;
        this.nazwa = " ";
        this.dataWydania = new GregorianCalendar().getTime();
    }

    public Towar(double cena, String nazwa)
    {
        this();  //zeruje wszystko z konstruktora domyślnego
        this.cena = cena;
        this.nazwa = nazwa;
    }

    public Towar(double cena, String nazwa, int rok, int m, int dz)
    {
        this(cena, nazwa);  //znowu wysyłamy do konstruktora wyżej, żeby znowu tego nie pisać
        GregorianCalendar kalendarz = new GregorianCalendar(rok, m-1, dz);  //m-1, bo miesiące liczone są od zera
        this.dataWydania = kalendarz.getTime();  //pobieramy datę ustawioną w kalendarzu powyżej
    }

    public double pobierzCena()
    {
        return this.cena;
    }

    public String pobierzNazwa()
    {
        return this.nazwa;
    }

    public Date pobierzDataWydania()
    {
        return dataWydania;
    }

    public void ustawCene(double cena)
    {
        this.cena = cena;
    }

    public void ustawCene(String nazwa)
    {
        this.nazwa = nazwa;
    }

    public void ustawDataWydania(int rok, int m, int dz)
    {
        GregorianCalendar kalendarz = new GregorianCalendar(rok, m-1, dz);
        this.dataWydania = kalendarz.getTime();
    }

    public void ustawDate(Date data)
    {
        this.dataWydania = data;
    }

    public String pobierzHaslo()
    {
        return this.haslo;
    }

    @Override
    public String toString()
    {
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        return this.cena + " zł; nazwa: " + this.nazwa + " " + kalendarz.get(Calendar.YEAR) + " rok " + (kalendarz.get(Calendar.MONTH)+1) + " miesiąc "+ kalendarz.get(Calendar.DAY_OF_MONTH) + " dzień";
    }

    // jeśli mamy odczytywanie strumieniowe to nie potrzebne są nam dodatkowe metody odczytu i zapisu!!!!!!!!!!!

    private void readObject (ObjectInputStream inS)  throws IOException, ClassNotFoundException  //zdefiniowana prywatna klasa do odczytu - zapobiega podmienianiu danych serializowanych
    {
        inS.defaultReadObject();
        if (haslo != null)
        if (!haslo.equals("tajne"))
            throw new IOException("Dane są nieprawidłowe");

//        System.out.println("Ja teraz wywołuję się z metody readObject");
    }

    private void writeObject (ObjectOutputStream outS)  throws IOException  //zdefiniowana prywatna klasa do odczytu - zapobiega podmienianiu danych serializowanych
    {
        outS.defaultWriteObject();

    }

    public static final int DLUGOSC_NAZWY = 30;  //ustalona z góry ilość znaków nazwy
    public static final int DLUGOSC_REKORDU = (Character.SIZE * DLUGOSC_NAZWY + Double.SIZE + 3 * Integer.SIZE)/8;  // długość rekurdu w bajtach
    private double cena;  // 8 bajtów
    private String nazwa;  // ustalamy z góry, tu DLUGOSC_NAZWY (30 znaków) * 2 = 60 bajtów
    private Date dataWydania;  //int ma 4 bajty, zatem 4 + 4 + 4 = 12 bajtów
    // zatem długość poszczególnej linii to 80 bajtów i co tyle trzeba skakać po pliku, żeby dojść do kolejnego rekordu

//    private transient String haslo = "lala";  //przy serializacji, żeby oznaczyć tajne/wrażliwe dane trzeba dopisać TRANSIENT - te dane nie zostaną zserializowane!!!!!!!!!!!!!!!
    private String haslo = "tajne";  //żeby obsłużyć wyjątek, trzeba usunąć transient (włączyć serializację)


}

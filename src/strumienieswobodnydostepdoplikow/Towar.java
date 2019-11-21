package strumienieswobodnydostepdoplikow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Towar
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

    @Override
    public String toString()
    {
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        return this.cena + " zł; nazwa: " + this.nazwa + " " + kalendarz.get(Calendar.YEAR) + " rok " + (kalendarz.get(Calendar.MONTH)+1) + " miesiąc "+ kalendarz.get(Calendar.DAY_OF_MONTH) + " dzień";
    }

    public static void zapiszDoPliku(Towar[] towar, PrintWriter outS) //przysysłanych informacji/strumieni sie nie zamyka, bo nie wiadomo, co jeszcze będzie dopisywane do pliku
    {
        outS.println(towar.length);

        GregorianCalendar kalendarz = new GregorianCalendar();  //zmienna tymczasowa, która będzie ustawiać czas od początku na czas towaru

        for(int i = 0; i < towar.length; i++)
        {
            kalendarz.setTime(towar[i].pobierzDataWydania());
            outS.println(towar[i].pobierzCena() + "|" + towar[i].pobierzNazwa() + "|" + kalendarz.get(Calendar.YEAR) + "|" + (kalendarz.get(Calendar.MONTH)+1) + "|"+ kalendarz.get(Calendar.DAY_OF_MONTH) + "|");
        }
    }

    public static Towar[] odczytajZPliku (BufferedReader inS) throws IOException
    {
        int dl = Integer.parseInt(inS.readLine());
        Towar[] towar = new Towar[dl];  //tworzymy dynamicznie nową tablicę i chcemy wiedzieć jaka jest długość tej tablicy

        for (int i = 0; i < dl; i++)
        {
            String linia = inS.readLine();
            StringTokenizer tokeny = new StringTokenizer(linia, "|");  //on odczytuje linie, potem podaje się znak podziału (w tym przypadku "|")
//            tokeny.nextToken();  //przekazuje tokeny po kolei

            double cena = Double.parseDouble(tokeny.nextToken());
            String nazwa = tokeny.nextToken();
            int rok = Integer.parseInt(tokeny.nextToken());
            int miesiac = Integer.parseInt(tokeny.nextToken());
            int dzien = Integer.parseInt(tokeny.nextToken());

            towar[i] = new Towar(cena, nazwa, rok, miesiac, dzien);
        }
            return towar;
    }

    public static final int DLUGOSC_NAZWY = 30;  //ustalona z góry ilość znaków nazwy
    private double cena;  // 8 bajtów
    private String nazwa;  // ustalamy z góry, tu DLUGOSC_NAZWY (30 znaków) * 2 = 60 bajtów
    private Date dataWydania;  //int ma 4 bajty, zatem 4 + 4 + 4 = 12 bajtów
    // zatem długość poszczególnej linii to 80 bajtów i co tyle trzeba skakać po pliku, żeby dojść do kolejnego rekordu


}

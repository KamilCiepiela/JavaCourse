package strumienieswobodnydostepdoplikowupgradeklasytowar;

import java.io.*;
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

    public static void zapiszDoPliku(Towar[] towar, DataOutput outS) throws IOException  // metoda służy teraz do zapisu całości pliku, a ta na końcu po pojedynczego rekordu z tabeli!!!
    //przysysłanych informacji/strumieni sie nie zamyka, bo nie wiadomo, co jeszcze będzie dopisywane do pliku
    {
//        outS.println(towar.length);
//        GregorianCalendar kalendarz = new GregorianCalendar();  //zmienna tymczasowa, która będzie ustawiać czas od początku na czas towaru

        for(int i = 0; i < towar.length; i++)
        {
//            kalendarz.setTime(towar[i].pobierzDataWydania());
//            outS.println(towar[i].pobierzCena() + "|" + towar[i].pobierzNazwa() + "|" + kalendarz.get(Calendar.YEAR) + "|" + (kalendarz.get(Calendar.MONTH)+1) + "|"+ kalendarz.get(Calendar.DAY_OF_MONTH) + "|");
        towar[i].zapiszDane(outS);
        }
    }

//    public static Towar[] odczytajZPliku (BufferedReader inS) throws IOException
    public static Towar[] odczytajZPliku (RandomAccessFile RAF) throws IOException
    {
//        int dlugoscTablicy = Integer.parseInt(inS.readLine());
        int iloscRekordow = (int)(RAF.length()/Towar.DLUGOSC_REKORDU);  //poda nam długość tablicy w bajtach, a my chcemy wiedzieć ile jest rekordów, dtaego dzieliny przez 80 - dł. rekordu
        Towar[] towar = new Towar[iloscRekordow];  //tworzymy dynamicznie nową tablicę i chcemy wiedzieć jaka jest długość tej tablicy

        for (int i = 0; i < iloscRekordow; i++)
        {
            towar[i] = new Towar();
            towar[i].czytajDane(RAF);

//            String linia = inS.readLine();
//            StringTokenizer tokeny = new StringTokenizer(linia, "|");  //on odczytuje linie, potem podaje się znak podziału (w tym przypadku "|")
////            tokeny.nextToken();  //przekazuje tokeny po kolei
//
//            double cena = Double.parseDouble(tokeny.nextToken());
//            String nazwa = tokeny.nextToken();
//            int rok = Integer.parseInt(tokeny.nextToken());
//            int miesiac = Integer.parseInt(tokeny.nextToken());
//            int dzien = Integer.parseInt(tokeny.nextToken());
//
//            towar[i] = new Towar(cena, nazwa, rok, miesiac, dzien);
        }

        return towar;
    }

    public void zapiszDane(DataOutput outS) throws IOException  //DataOutput może przyjąc RandomAccessFile potrzebną do zapisu w bajtach
    {
        outS.writeDouble(this.cena);

        StringBuffer stringB = new StringBuffer(Towar.DLUGOSC_NAZWY);  // ta klasa przechowuje w pamięci każdy String z osobna i na końcu każdego dodaje jakieś znaki, które sprawiają, że każdy jest tej samej (zadanej) długości

        stringB.append(this.nazwa);  //dzięki temu dodamy na początku całego Stringa, a reszta zostanie dopełniona do wymaganej długości
        stringB.setLength(Towar.DLUGOSC_NAZWY); //teraz już wszystkie Stringi będą takiej samej długości

        outS.writeChars(stringB.toString());

        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);

        outS.writeInt(kalendarz.get(Calendar.YEAR));
        outS.writeInt((kalendarz.get(Calendar.MONTH)+1));
        outS.writeInt(kalendarz.get(Calendar.DAY_OF_MONTH));

    }

    public void czytajDane(DataInput inS) throws IOException
    {
        this.cena = inS.readDouble();

        StringBuffer tString = new StringBuffer(Towar.DLUGOSC_NAZWY);  //wczytujemy po znaku aż do końca każdego Stringa

        for (int i = 0; i < Towar.DLUGOSC_NAZWY; i++)
        {
            char tCh = inS.readChar();

            if(tCh != '\0')
                tString.append(tCh);
//            else
//                break;  // jeśli tego nie usuniemy to się program wywali, bo nie przejdzie do kolejnej linii
        }

        this.nazwa = tString.toString();

        int rok = inS.readInt();
        int miesiac = inS.readInt();
        int dzien = inS.readInt();

        GregorianCalendar kalendarz = new GregorianCalendar(rok, miesiac-1, dzien);
        this.dataWydania = kalendarz.getTime();


    }

    public void czytajRekord(RandomAccessFile RAF, int n) throws IOException, BrakRekordu {
        if (n <= RAF.length()/DLUGOSC_REKORDU)
        {
            RAF.seek((n-1)*Towar.DLUGOSC_REKORDU);
            this.czytajDane(RAF);
        }
        else
//            System.out.println("Brak rekordu");
            throw new BrakRekordu("Niestety nie ma takiego rekordu");
    }

    public static final int DLUGOSC_NAZWY = 30;  //ustalona z góry ilość znaków nazwy
    public static final int DLUGOSC_REKORDU = (Character.SIZE * DLUGOSC_NAZWY + Double.SIZE + 3 * Integer.SIZE)/8;  // długość rekurdu w bajtach
    private double cena;  // 8 bajtów
    private String nazwa;  // ustalamy z góry, tu DLUGOSC_NAZWY (30 znaków) * 2 = 60 bajtów
    private Date dataWydania;  //int ma 4 bajty, zatem 4 + 4 + 4 = 12 bajtów
    // zatem długość poszczególnej linii to 80 bajtów i co tyle trzeba skakać po pliku, żeby dojść do kolejnego rekordu


}

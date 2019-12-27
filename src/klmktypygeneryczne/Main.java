package klmktypygeneryczne;


import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {

    /*
    * GENERIC - uogólniony, jakby szablon
    * dla ArrayList typem generycznym jest <E> - od element
     */

//        ArrayList a = new ArrayList();
        ArrayList<String> a = new ArrayList<String>();
        // tutaj za Element e podstawiamy String i wszystkie elemty listy od tej pory muszą być typu String
        // sprawdzanie poprawniści typu odbywa się podczas pisania, a nie w czasie kompilacji
        // przy tworzeniu nowego obiektu można jeszcze raz potwierdzić typ generyczny, żebyśmy byli pewni, że takiego chcemy

        a.add(new String("lala"));
        a.add(new String("lala2"));
        a.add(new String("lala3"));
        a.add(new String("lala4"));
        a.add(new String("lala5"));
        a.add(new String("lala6"));
//        a.add(new Integer(4));
        // po określieniu Stringa powyżej jako typu generycznego ArrayList, teraz wyskakuje błąd, bo typy się nie zgadają

        /*
        for (int i = 0; i < a.size(); i++)
            System.out.println((String)a.get(i));

        * wyrzuca błąd ClassCastException, bo próbujemy zrzutować Integer do Stringa, bo to jest drugi typ w liście
        * poniżej określenie typu elementu w liście z góry,
        * tj. TWORZYMY SZABLON, UOGÓLNIAMY JAKI TYP DANYCH BĘDZIE W NASZEJ LIŚCIE
        */

        // pętla enhanced for
        for (String stringus : a)
            System.out.println(stringus);  // tutaj nie musimy używać rzutowania na String, bo jesteśmy pewni, że tam są same Stringi, bo ArrayList nic innego nie przyjmie.

        Zwykła <String> nazwaZmiennej = new Zwykła<>();
        nazwaZmiennej.nadajWartosc("cosik");
        System.out.println(nazwaZmiennej.zwroc());
    }
}

    // ponięj szablon typu generycznego dla ArrayList
class Zwykła <COKOLWIEK>  // klasa tworzy typ uogólniony COKOLWIEK, którego mogę użyć w jej ciele
{
    public void nadajWartosc(COKOLWIEK wartosc)  //nadaje wartość elementowi takiego typu, jakiego jest Cokolwiek
    {
        this.nazawaZmiennejTypuCokolwiek = wartosc;
    }
    public COKOLWIEK zwroc()  // metoda, która zwraca przysłaną z Main zmienną typu Cokolwiek, tutaj String
    {
        return this.nazawaZmiennejTypuCokolwiek;
    }

    COKOLWIEK nazawaZmiennejTypuCokolwiek;
    //stworzyliśmy zmienną typu cokolwiek, którą możemy tu przysłać klasy Main/powyżej
    // zgodnie z powyższym, przysłaliśmy tutaj String z klasy głównej
}
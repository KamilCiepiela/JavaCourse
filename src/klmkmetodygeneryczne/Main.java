package klmkmetodygeneryczne;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Edytor
{
//    public static void wypisz(List<?> lista)
    public static void wypisz(List<? extends Figura> lista)  // jeśli użyję bounded wildcard tak jak tutaj, NIE będę mógł użyć metody ADD
    {
        for (Figura figura : lista)  // niekompatybilne typy, dlatego, że dopóki typ listy jest WILDCARD <?>, MUSI BYĆ <? extends Figura>
            System.out.println(figura.pobierzNazwe());

//        lista.add(new Kolo());  // tak nie mogę dodać, bo wyskakuje błąd - trzeba by rzutować na typ, który jest w liście <?> - czyli taki, który nie istnieje
        lista.add(null);  // jedyne, co możemy dodać w takiej sytuacji to NULL, ponieważ jest on podtypem typu nieznanego <?>

        System.out.println("--------------------");

        for (Figura figura : lista) {
            if (figura == null) {
                System.out.println("null");
                break;
            }
            System.out.println(figura.pobierzNazwe());
        }
    }

    // METODA GENERYCZNA W UŻYCIU
//    public static <T> void wypisz2(List<T> lista)  // <T> - własny, ougólniony typ danych w metodzie generycznej
    public static <T extends Figura> void wypisz2(List<T> lista)  // <T> - typ danych w metodzie generycznej może być rozszerzany/ ograniczany przez inne, znane typy - tu Figura
    // po rozszerzeniu - List<T> to lista, która przechowuje subklasy Figur
    {
        for (T figura : lista)
            System.out.println(figura.pobierzNazwe());  // nie możemy wykonywać żadnych operacji, bo <T> jest nieznanym typem, więc nie wiadomo jakie operacje są możliwe
            // po rozszerzeniu o znany typ <Figura>, wszystkie operacje dla tego typu generycznego są możliwe

        lista.add((T) new Kolo());  // teraz mogę dodawać do listy obiekty typu <Figura>, czyli subklasy typu <T> (nie tylko null, jak dla <?>)
        lista.add((T) new Kolo());  // teraz trzena je zrzutować na typ <T>, dla bezpieczeństwa ptogram tego wymaga program
        lista.add((T) new Kolo());
        lista.add((T) new Kolo());
//        lista.add(new Kolo());  // tak nie mogę dodać, bo wyskakuje błąd - trzeba by rzutować na typ, który jest w liście <?> - czyli taki, który nie istnieje
        lista.add(null);  // jedyne, co możemy dodać w takiej sytuacji to NULL, ponieważ jest on podtypem typu nieznanego <?>

        System.out.println("--------------------");

        for (T figura : lista) {
            if (figura == null) {
                System.out.println("null");
                break;
            }
            System.out.println(figura.pobierzNazwe());
        }
    }

    //nowa metoda
//    public static void przepiszTabliceDoKolekcji(Object[] tab, Collection<?> c) // kolekcja jest najogólniejszym typem zbioru, jest oczywiście wyżej niż lista

    public static <Type> void przepiszTabliceDoKolekcji(Type[] tab, Collection<Type> c) // METODA GENERYCZNA - przed tym, co zwraca funkcja wpisujemy zdefiniowany przez nas, własny typ danych
    // po stworzeniu typu Type możemy go używać w całym ciele metody
    // typów może być więcej niż jeden, oddziela się je przecinkami - jak przy interfejsach np. <Type, K, J>

    {
//        for (Object o : tab)
//            c.add(o);  //ywskakuje błąd, bo musimy to zrzutować do takiego typu, w jakim występuje kolekcja - unknown <?>, czyli do takiego typu, który teoretycznie nie istnieje

        //aby to obejść
        for (Type o : tab)
            c.add(o);
    }

}

//class Figura
class Figura <K>  // utworzyliśmy specjalny typ danych i już możemy go używać w tej metodzie!!!!
{
    K lala;  // tu utworzyliśmy zmienną lala typu K, który stworzyliśmy powyżej
    public String pobierzNazwe()
    {
        return nazwa;
    }
    String nazwa = "";
}

class Kolo extends Figura
{
    public Kolo()
    {
        super.nazwa = "Koło";
    }
}

class Kwardat extends Figura
{
    public Kwardat()
    {
        super.nazwa = "Kwardat";
    }
}

public class Main
{

    public static void main(String[] args)
    {
        Figura figura1 = new Kolo();  // mogę to zrobić, bo klasa Figura jest położona wyżej niż klasa Koło
        Figura figura2 = new Kwardat();  // mogę to zrobić, bo klasa Figura jest położona wyżej niż klasa Kwadrat

        Figura[] figury = new Figura[50];

        List<Figura> listaFigur = new ArrayList<Figura>();
        listaFigur.add(figura1);
        listaFigur.add(figura2);

//        Edytor.wypisz(listaFigur);

        Edytor.wypisz2(listaFigur);

        Float[] fl = new Float[50];  // subklasa Number
        Integer[] in = new Integer[50];  // subklasa Number
        Number[] nu = new Number[50];  // najbardziej ogólny typ liczbowy, jego podtypy to np. float i integer

        Collection<Number> cn = new ArrayList<Number>();  // cn od Collection Number

        Edytor.przepiszTabliceDoKolekcji(fl, cn);  //nastąpiło przepisanie tablicy typu Float do kolekcji typu Number
        Edytor.przepiszTabliceDoKolekcji(in, cn);  //nastąpiło przepisanie tablicy typu Integer do kolekcji typu Number
        Edytor.przepiszTabliceDoKolekcji(nu, cn);  //nastąpiło przepisanie tablicy typu Number do kolekcji typu Number
        // METODA GENERYCZNA AUTOMATYCZNIE RZUTUJE jeśli typ ogólny się zgadza (poziom wyżej, poziom niżej itp.)

//        Edytor.przepiszTabliceDoKolekcji(figury, cn);  //nastąpiło przepisanie tablicy typu Figura do kolekcji typu Number, ale napierw trzeba rzutować/ stworzyć nową metodę, bo się typy nie zgadają
    }
}
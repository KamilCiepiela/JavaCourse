package klmkwildcards;


import java.util.ArrayList;
import java.util.List;

class SuperClass
{
//    public static void tester(List lista)  // jak klasa jest statyczna, to możemy ją wywołać zawsze, NIE TWORZĄC ŻADNEGO OBIEKTU
//    public static void tester(List<Object> lista)  // przyjmuje listę obiektów (typu najbardziej ogólnego)
//    public static void tester(List<?> lista)  // przyjmuję WILDCARD, czyli mogę tu wysąłć cokolwiek
    public static void tester(List<? extends SuperClass> lista)  // przyjmuję BOUNDED WILDCARD, czyli mogę tu wysąłć cokolwiek, ale pod warunkiem, że jest z klasy SuperClass lub ją rozszerzających, tu SubClass
//    public static void tester(List<? extends Object> lista)  // pkażda klasa rozszerza Object, więc teraz mogę podstawić tu wszystko - to po co teraz robić ograniczenia
    {
     // będzie przyjmowała Listę
    }
}

class SubClass extends SuperClass
{

}

public class Main
{

    public static void main(String[] args)
    {
    /*
    * WILDCARD w informatycze oznacza ZNAK WIELOZNACZNOŚCI (?)
    * BOUNDED WILDCARD - ograniczony znak wieloznaczności, nadajmy mu pewien warunek
    *   jeśli chcemy ograniczyć wildcard do klasy SuperClass i klas ją rozszerzjących (? extends SuperClass)
    *
    * KAŻDA KLASA ROZSZERZA OBJECT, ALE OBJECT NIE!!! ROZSZERZA WSZYSTKICH KLAS
    *
    * MÓWIĘ, ŻE podkładam za "E" : "String" we wszystkich deklaracjach/definicjach metod
    * inaczej to jest Lista Stringów
     */

//        ArrayList<String> listaStringow;  // to jest tylko zmienna, która nie ma odwołania w pamięci
//        ArrayList<String> listaStrongow = new ArrayList<String>();  // stworzyliśmy obiekt, który już ma odwołanie w pamięci
        List<String> listaStringow = new ArrayList<String>();  // Skoro ArrayList implementuje List, to możemy stworzyć obiekt List, zamiast ArrayList

//        ArrayList<SuperClass> listaClass = new ArrayList<SuperClass>();
        ArrayList<SubClass> listaClass = new ArrayList<SubClass>();
//        listaClass.add(new SuperClass());  // mogę oczywiście dodać element z superklasy
        listaClass.add(new SubClass());  // ale mogę też dodać element z klasy rozszerzającej superklasę

//        SuperClass.tester(listaStringow);  // wysyłamy do góry np. listę klas, listę Stringów
        SuperClass.tester(listaClass);  // wysyłamy do góry np. listę klas, listę Stringów
        // jeśli w SuperClass będzie lista obiektów, program nie pozwoli zrobić listy Stringów
        // przy użyciu WILDCARD, możemy tu wstawić i listaStringów, i listaClass
        // jeśi chcemy mieć pewność, że będzie to obiekt z klasy SuperClass lub SubClass, która ją rozszerza, trzeba użyć BOUNDED WILDCARD (? extends SuperClass)

        /*
        ŹLE ŹLE ŹLE ŹLE ŹLE ŹLE ŹLE!!!!!!!!!!!!!!
        ArrayList<String> listaS = new ArrayList<String>();
        ArrayList<Object> listaO = listaS;  //to jest błąd, bo String rozszerza Object, ale Object nie rozszerza Stringa (bo jest bardziej ogólny)

        listaO.add(new Integer(4));
        String a = (String) listaO.get(0);  // musimy rzutować na String, czyli STRACILIŚMY WŁĄŚCIWOŚĆ TYPU GENERYCZNEGO!!!!
        */

    }
}
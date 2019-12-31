package klmkfocusonlinkedlist;

import com.sun.source.tree.WhileLoopTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/*
* Lista jest powiązana, bo poszczególne elemnty są ze sobą powiązane odwołaniami do elementu poprzedzającego i następującego!!!!!!!!!!
*
 */
public class Main
{

    public static void main(String[] args)
    {
        LinkedList<String> listaPowiazana = new LinkedList<String>();
        listaPowiazana.add("lala1");
        listaPowiazana.add("lala2");
        listaPowiazana.add("lala3");
        listaPowiazana.add("lala4");

        //TAK SIĘ TEGO NIE ROBI!!!!!
//        for (int i = 0; i < listaPowiazana.size(); i++)  // taka pętla dziaała, ale STRASZNIE WOLNO
//        {
//            System.out.println(listaPowiazana.get(i));  //dla takiego zapisu, przeszukowanie za każdym razem ZACZYNA SIĘ OD POCZĄTKU - DLATEGO TO JEST NIEEFEKTYWNE I WOLNE
//        }

        Main.wypiszElementyListy(listaPowiazana);

//        Iterator<String> iter = listaPowiazana.iterator();  // jeśli nie zaznaczymy typu String, to metoda next() poniżej zwróci nam Objecy, nie String
        // w tej metodzie nie można dodawć wpisów do LinkedList

        ListIterator<String> iter = listaPowiazana.listIterator(listaPowiazana.size());  // dopiero ta metoda pozwala na dodawanie wpisów
        // jeśli nie podamy indeksu, do dadny element listy zostanie dodany jako index 0
        // ta klasa ma dodatkowe metody, np. add, hasPrevious - umożliwia iterowanie do przodu, więc teraz można iterować w obydwie strony

        /*
        * | A B C D
        * A | B C D
        * A B | C D
        * A B C | D
        * A B C D |
        *
        * iteratorów jest zawsze n+1 pozycji w kolekcji
        *
         */



        while (iter.hasPrevious())
        {
            System.out.println(iter.previous());  // dzięki temu elementy zostały wypisane od tyłu
            iter.set("podmiana");  // w tym momencie podmienimy wszystkie wartości
        }

        System.out.println();

        iter = listaPowiazana.listIterator(); // teraz wyzerowaliśmy iterator

        iter.add("nowylala");  // teraz ten element zostanie dodany na samym początku, bo wyzerowaliśmy iterator
        // metoda add, ZAWSZE DODAJE PRZED ITERATOREM


//        iter.next();  // teraz zwraca nem tu na pewno Stringa i nic innego (bo powyżej określiliśmy to w typie generycznym)

//        iter.remove();  // metoda do usuwania elementóe listy, ITERATOR USUWA ZAWSZE POPRZEDNIKA!!!!!!!!!!!!!
        // jeśli metoda remove nie będzie poprzedzona metodą next, to będzie błąd, bo nie ma poprzednika

        Main.wypiszElementyListy(listaPowiazana);


    }
    // aby usprawnić przeszukiwanie LinkedList, stworzymy własną metodę prz pomocy ITERATORA (urządzenie do skakania między elementami)
    public static void wypiszElementyListy(LinkedList<?> lista)
    {
        Iterator iteratorListy = lista.iterator();

        while (iteratorListy.hasNext())
            // aby uniknąć sytuacji, że iterator dojdzie do końca listy i nie będzie wiedział co zrobić, robimy warunek z metodą hasNext (jeśli nie ma dalej elementów, iterator kończy swoje wykonywanie)
            System.out.println(iteratorListy.next());  // next zwraca nam obiekt typu lista

        System.out.println();
    }

}

/*
 * TU ZNAJDUJE SIĘ ITERATOR (na początku znajduje się przed całą listą)
 * ====
 * |  | - 0 (przejście do 0)
 * ====
 * INNE OBIEKTY
 * TERAZ TU ZNAJDUJE SIĘ ITERATOR (po wywołaniu iteratora metodą NEXT, iterator przeskakuje do następnego elementu listy i teraz znajduje się przed kolejnym elementem listy)
 * ====
 * |  | - 1 (zaczyna od 0, tam jest info, że następny jest 1)
 * ====
 * ====
 * |  | - 200 (zaczyna od 0, tam jest info, że następny jest 1 ... idzie do 199 i dopiero tam jest info, że następny jest 200)
 * ====
 * ====
 * |  | - 400
 * ====
 * ====
 * |  | - 1000 (kiedy przeliczanie dojdzie do połowy patrząc od początku, przechodzi na koniec i zacznyna szukać od końca do połowy!!!!!!!!!!!!!!!!!!!!!!!!)
 * ====
 */
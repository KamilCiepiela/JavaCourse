package klmkarrayorazlinkedlist;


import java.util.ArrayList;
import java.util.LinkedList;

/*
* Obydwie listy implementują List, a ta rozszerza Collection (pojemniki do przechowywania danych)
*           ARRAYLIST
* Poniżej jak wygląda ArrayList - 1 komórka = 1 element w tablicy
* Array to tablica, ale DYNAMICZNA, w pamięci komputera są przechowywane adresy, jeden po drugim
* PLUS: pozwala nam to bardzo szybko uzyakć dostęp do zawartości (JEŚLI CHCEMY DUŻO PRZEGLĄDAĆ KOLEKCJĘ, ALE NIEKONIECZNIE COŚ USUWAĆ LUB DODAWAĆ)
* MINUS: bardzo wolna przy dodawaniu nowych elementów oraz ich usuwaniu
* -----
* | 1 |
* |   |
* -----
* -----
* | 2 |
* |   |
* -----
* -----
* | 3 |
* |   |
* -----
* -----
* | 4 |
* |   |
* -----
* PRZY USUNIĘCIU ELEMENTÓW ZE ŚRODKA LISTY, znowu trzeba przepisać całą listę, żeby nie było dziur
* -----
* | 5 |
* |   |
* -----
* -----
* | 6 |
* |   |
* -----
*
* INNY OBIEKT
* Możliwe, że tu już pamięć została zarezerwowana przez inny obiekt, dlatego kolejne wpisy nie są możliwe, bo mogłyby nadpisać ten inny obiekt
*
* -----
* | 7 |
* |   |
* -----
*
* Jeśli przekroczymy ilosć wpisów w ArrayList, całość zostanie przepisana w inne miejsce w pamięci, gdzie będzie można zapisać np. 7 elementową listę, ALE WSZTSTKIE ELEMNTY BĘDĄ PO KOLEI!!!!!!!!!
* czyli program będzie musiał przepisać całą listę w inne miejsce w pamięcie, NIEZALEŻNIE OD DŁUGOŚCI LISTY
* Wcześniejsza lista jest zostawiana, by w przyszłości inny wpis wykorzystał to miejsce w pamięci
*
*/

/*
* Obydwie listy implementują List, a ta rozszerza Collection (pojemniki do przechowywania danych)
*           LINKEDLIST
* Poniżej jak wygląda LinkedList - 1 komórka = 1 element w tablicy
* Linked to tablica, gdzie w pamięci komputera są przechowywane adresy, ale NIE jeden po drugim, a Z ODNOŚNIKAMI DO POPRZEDNIKA I NASTĘPNIKA
* PLUS: bardzo szybka przy dodawaniu nowych elementów oraz ich usuwaniu (bo zapisuje je na każdym nowym miejscu w pamięci, a wpisy mogą, ale nie muszą być po kolei)
* - ŚWIETNA JEŚLI CHCEMY DUŻO I CZĘSTO MODYFIKOWAĆ KOLEKCJĘ
* MINUS: bardzo wolna do przeszukiwania (bo trzeba sprawdzać całą tablicę - następniki i/lub poprzedniki każdego rekordu, aż trafimy na ten, który nas interesuje)
*
* - przy dodawaniu i usuwaniu zmieniają się poprzednik wpisu następującego i następnik wpisu poprzedzającego!!!!!!!!!!!!!
* - jest to 10x szybsze niż tworzenie całej tablicy od początki jak przy ArrayList
* -----
* | 1 |
* |   |
* -----
* INNY OBIEKT (ZAREZERWOWANA PAMIĘĆ)
* INNY OBIEKT
 * -----
* | 1 |
* |   |
* -----
* INNY OBIEKT
 * -----
* | 1 |
* |   |
* -----
* -----
* | 1 |
* |   |
* -----
* INNY OBIEKT
* INNY OBIEK TINNY OBIEKT INNY OBIEKT INNY OBIEKT INNY OBIEKT INNY OBIEKT
* -----
* | 20|
* |   |
* -----
*
* INNE OBIEKTY, jest ich 400
*
* -----
* |420| - nr indeksu w adresie elemntu LinkedList
* |   |
* -----
*
 */

class ListaPolaczona
// w tej klasie została stworzona zmienna typu tej klasy (rekurencyjna), czyli w klasie stworzełem klasę, która znowu ma takie parametry jak wartosć i klasa rekurencyjna (i tak można w nieskończoeność)
{
    int wartosc;
    ListaPolaczona nastepna;  // w klasie stworzyłem ją samą (KLASA REKURENCYJNA)!!!!!!!!!!
    ListaPolaczona poprzedni;  //jeśli nie ma poprzednika, TO SIĘ DAJE NULL (czyli nie wskazuje na żadne miejsce w pamięci)
}

public class Main
{

    public static void main(String[] args)
    {
        // ArrayList i LinkedList TO SĄ KOLEKCJE!!!

        ArrayList listaTablicowa = new ArrayList(6);  // implementuje List, a ta rozszerza Collection (pojemniki do przechowywania danych)
        // Capacity (tu 6) przygotowuje miejsce w pamięci na 6 rekordów
        listaTablicowa.add(new Object());  //mamy zapełnioną pierwszą pozycję w liście (z 6)
        listaTablicowa.add(new Object());  //mamy zapełnioną drugą pozycję w liście (z 6) itd
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());

//        LinkedList listaPolaczona;  // implementuje List, a ta rozszerza Collection (pojemniki do przechowywania danych)

        ListaPolaczona listaPolaczona = new ListaPolaczona();
        listaPolaczona.wartosc = 10;  // teraz mam dostęp do nasępnej listy połacznej w środku (do klasy rekurencyjnej)

        listaPolaczona.nastepna = new ListaPolaczona(); // tworzę obiekt klasy rekurencyjnej
        listaPolaczona.nastepna.wartosc = 20;

        listaPolaczona.nastepna.nastepna = new ListaPolaczona(); // tworzę obiekt klasy rekurencyjnej w klasie rekurencyjnej (i tak można w nieskończoność)
        listaPolaczona.nastepna.nastepna.wartosc = 30;

        System.out.println(listaPolaczona.wartosc);
        System.out.println(listaPolaczona.nastepna.wartosc);
        System.out.println(listaPolaczona.nastepna.nastepna.wartosc);

    }
}
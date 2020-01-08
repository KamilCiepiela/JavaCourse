package klmkhashcode;

// hashcode to funkcja mieszająca, wyrażona w postaci liczby całkowitej
// hash musi być taki sam dla równych sobie obiektów

import java.util.Objects;

class Element
{
    public Element (int wartosc)  //konstruktor publiczny
    {
        this.wartosc = wartosc;
    }

    @Override
    public boolean equals(Object obj)  // taką metodę powinniśmy ZAWSZE nadpisywać, jeśli jej elementy będą używane później w innym celu niż default w zbiorze HASH
    {
//        if (obj == null) return false;  // zabezpieczamy się przed wpisaniem NULL

        if (obj == null || this.getClass() != obj.getClass()) return false;  // rónież jeśli klasa obiektu przysłanego jest różna niż klasa Element, to FALSE
        if (this == obj) return true;  //dla przyspieszenia działąnia metody - jeśli obiekt porównywany to to samo miejsce, zwróć TRUE
        return this.wartosc == ((Element)obj).wartosc;  // przy większej ilości parametrów dodajemy koninkcję (i w tym samym momencie spełnia warunek...)

//        if (this.wartosc == ((Element)obj).wartosc)  //ewentualnie tak można zapisać
//            return true;
//        else
//            return false;
    }

//    @Override
//    public boolean equals(Object obj)  // taką metodę powinniśmy ZAWSZE nadpisywać, jeśli jej elementy będą używane później w innym celu niż default w zbiorze HASH
//    {
////        if (obj == null) return false;  // zabezpieczamy się przed wpisaniem NULL
//
//        if (obj == null || this.getClass() != obj.getClass()) return false;  // rónież jeśli klasa obiektu przysłanego jest różna niż klasa Element, to FALSE
//        if (this == obj) return true;  //dla przyspieszenia działąnia metody - jeśli obiekt porównywany to to samo miejsce, zwróć TRUE
//        return this.wartosc == ((Element)obj).wartosc;  // przy większej ilości parametrów dodajemy koninkcję (i w tym samym momencie spełnia warunek...)
//
////        if (this.wartosc == ((Element)obj).wartosc)  //ewentualnie tak można zapisać
////            return true;
////        else
////            return false;
//    }

//    @Override  // metoda wygenerowana automatycznie przez Intellij
//    public int hashCode()
//    {
//        return Objects.hash(wartosc);
//    }

    @Override  // metoda zgodna z kursem, takie nadpisanie jest proste dla int, ale dla innych typów niekoniecznie
    public int hashCode()
    {
        int hash = 7;
        hash = 14 * hash + this.wartosc;  // jeśli dodajemy wartość do wyniku, to hashCode będzie równy, niezależnie od lokalizacji adresu w pamięci
        /*
        hash = 89 * hash + (int)(Double.doubleToLongBits(this.cos) ^ (Double.doubleToLongBits(this.cos) >>> 32));
                // rzutowanie na int, bo hash jest intem (liczbą całkowitą)!!
                // doubleToLingBits, żeby nie tracić precyzji przy rzutowaniu do inta
                // na koniec są zmieniane do 32 bitów, żeby się zmieściły w int (double ma 64 bity)
        hash = 89 * hash + (int) (this.cos2 ^ (this.cos2) >>> 32);  // typ long - podobnie jak double powyżej
        hash = 89 * hash + (this.cos3 != null ? this.cos3.hashCode() : 0);
                // typ String - jeśli nie jest nullem, to zwracamy hashCode Stringa (String ma własny hashCode)
        * TO POWYŻEJ JEST NADMIERNE!!!
        */
        return hash;
    }

    int wartosc;

    double cos;
    long cos2;
    String cos3;
}

public class Main
{

    public static void main(String[] args)
    {
        Element a = new Element(5);  // ta sama wartość, ale różne adresy w pamięci
        Element b = new Element(5);  // ta sama wartość, ale różne adresy w pamięci
//        Element b = a;  // TRUE, bo adresy są równe

        System.out.println(a==b);  // FLASE, bo sprawdza ADRESY, nie WARTOŚCI; jesli Element b = a, to byłoby TRUE

//        System.out.println(a.equals(b));  // również FLASE, bo sprawdza adresy w taki sam sposób jak poprzednio, nie wartości

        System.out.println(a.equals(b));  // po nadpisaniu metody powyżej - TRUE

        System.out.println("abc".hashCode());  // String automatycznie tworzy własny hachCode
        System.out.println("ac".hashCode());
        System.out.println();

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

    }
}
package klmkhashcode;

// hashcode - funkcja mieszająca

class Element
{
    public Element (int wartosc)
    {
        this.wartosc = wartosc;
    }

    @Override
    public boolean equals(Object obj)  // taką metodę powinniśmy ZAWSZE nadpisywać, jeśli jej elementy będą używane później w innym celu niż default
    {
//        if (obj == null) return false;  // zabezpieczamu się przed wpisaniem NULL

        if (obj == null || this.getClass() != obj.getClass()) return false;  // rónież jeśli klasa obiektu przysłanego jest różna niż klasa Element, to FALSE

        if (this == obj) return true;  //dla przyspieszenia działąnia metody - jeśli obiekt porównywany to to samo miejsce, zwróć TRUE

        return this.wartosc == ((Element)obj).wartosc;  // przy większej ilości parametrów dodajemy koninkcję (i w tym samym momencie spełnia warunek...)

//        if (this.wartosc == ((Element)obj).wartosc)  //ewentualnie tak można zapisać
//            return true;
//        else
//            return false;
    }

    int wartosc;
}

public class Main
{

    public static void main(String[] args)
    {
        Element a = new Element(5);  // ta sama wartość, ale różne adresy w pamięci
        Element b = new Element(5);  // ta sama wartość, ale różne adresy w pamięci

        System.out.println(a==b);  // FLASE, bo sprawdza adresy, nie wartości; jesli Element b = a, to byłoby TRUE

//        System.out.println(a.equals(b));  // również FLASE, bo sprawdza adresy w taki sam sposób jak poprzednio, nie wartości

        System.out.println(a.equals(b));  // po nadpisaniu metody powyżej - TRUE

    }
}
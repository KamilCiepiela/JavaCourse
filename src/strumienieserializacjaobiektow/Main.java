package strumienieserializacjaobiektow;

import java.io.*;


public class Main
{
    public static void main(String[] args)
    {

        Towar[] towar = new Towar[3];

        towar[0] = new Towar();
        towar[1] = new Towar(29.0, "Video Kurs Java");
        towar[2] = new Towar(39.0, "Video Kures C++", 2008, 11, 21);

        // SERIALIZACJA pomaga pamiętać o wszystkich odwołaniach do innych klas powiązanych

        try
        {
            ObjectOutputStream outS = new ObjectOutputStream(new FileOutputStream("nowy3.txt"));
            // klasa ObjectOutputStream pozwala nam serializować dane - podczas zapisu do pliku, danym zostaje nadany numer seryjny, do którego będziemy się odwoływać
            // klasa będzie sprawdzać za każdym razem, czy taki nr seryjny już istnieje, a jak nie to go nada
            // te dane nie są szyfrowane, dlatego trzeba sprawdzać, czy nie zostały podmienione w trakcie

//            outS.writeObject(towar[0]);
            outS.writeObject(towar);

            outS.close();

            ObjectInputStream inS = new ObjectInputStream(new FileInputStream("nowy3.txt"));

            //wczytywanie pojedynczej danej
//            Towar a = (Towar)inS.readObject();  //rzutowanie obiektu i przypisanie do zmiennej
//            System.out.println(a.pobierzHaslo());

            //wczytywanie całej tablicy
            Towar[] a = (Towar[])inS.readObject();  //rzutowanie obiektu i przypisanie do zmiennej

            for (int i = 0; i < a.length; i++)
                System.out.println(a[i].pobierzNazwa());

            inS.close();

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        catch (ClassNotFoundException e)  // wyjątek wyskakujący przy błędnym rzutowaniu
        {
            System.out.println(e.getMessage());
        }
    }
}
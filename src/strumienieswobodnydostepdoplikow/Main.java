package strumienieswobodnydostepdoplikow;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {

        Towar[] towar = new Towar[3];

//        towar[0] = null;
//        towar[1] = null;
//        towar[2] = null;

        towar[0] = new Towar();
        towar[1] = new Towar(29.0, "Video Kurs Java");
        towar[2] = new Towar(39.0, "Video Kures C++", 2008, 11, 21);

        try
        {
//            FileOutputStream outS = new FileOutputStream("nowy.txt'");  //trzeba by pisać po1 bicie, więc jest to strasznie wolna metoda
            /*
            DataOutputStream outS = new DataOutputStream(new FileOutputStream("nowy.txt"));

            outS.writeDouble(12412.123);  // jest 8 znaków = Double zajmuje 8 bajtów
            outS.close();

            DataInputStream inS = new DataInputStream(new FileInputStream("nowy.txt"));

            System.out.println(inS.readDouble());
            inS.close();
             */

            RandomAccessFile RAF = new RandomAccessFile("nowy.txt", "rw");  //drugi parametr w postaci String - r - odczyt; w - zapis

            RAF.writeDouble(123.42); // double - 8 bajtów
            RAF.writeDouble(41.23);
            RAF.writeChars("lalal  ");  //znaki - po 2 bajty na znak

            System.out.println(RAF.getFilePointer());  //pokazuje, na którym miejscu w bajtach jesteśmy w pliku
            // POINTER to wzkaźnik odwołania między adresami, dlatego jest bardzo szybki

            RAF.seek(0);  //skacze do wybranego miejsca w pliku (liczba w bajtach)
            RAF.seek(8);  // należy pamiętać o typie danych -> dalej w pliku jest String, nie Double
            RAF.seek(16);

            System.out.println(RAF.readDouble());
            System.out.println(RAF.readChar());  //czyta po jednym znaku na raz

            System.out.println(Double.SIZE/8 + Integer.SIZE/8);  //podane w bitach, dlatego trzeba podzielić na 8

            RAF.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
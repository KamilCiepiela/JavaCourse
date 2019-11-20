package strumieniezapisiodczyt;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try
        {
            // ZAPISYWANIE DO PLIKU
//            PrintWriter drukarz = new PrintWriter(new FileWriter("dane.txt", true));
            PrintWriter drukarz = new PrintWriter(new FileWriter("dane.txt"));
            // za każdym razem plik jest kasowany i tworzony od początku przy uruchomieniu
            // aby zapobiec kasowaniu za każdym razem, trzeba dodać 'true' jako drugi parametr - do naszago pliku będzie dodawana kopia zawartości przykażdym uruchomieniu

            drukarz.println(1234);
//            drukarz.flush();  //WYMUSZONE zpaisanie wszystkiego co jest w buforze
            drukarz.close();  // strumień trzeba zamykać, bo nic się nie zapisze

            drukarz = new PrintWriter(new FileWriter("dane.txt", true));  // drugi parametr true w PrintWriter oznacza autoFlush
            //ponowne otwarcie, jeśli chcemy DOpisać, a nie NADpisać, trzeba dodać true na końcu FlieWriter w powyższym zapisie

            drukarz.append("lala");  //dodaj do końca
            drukarz.println();
            drukarz.printf("On ma %d kg oraz %.2f %s wzrostu", 80, 180.4, "cm");  // formatowanie tekstu
            // podaje się tekst oraz ARGUMENTY, które mogą zostać podane lub przysłane z zwenątrz

            drukarz.close();

            //WCZYTYWANIE Z PLIKU
            BufferedReader reader = new BufferedReader(new FileReader("dane.txt"));

//            System.out.println((char)reader.read());
//            System.out.println(reader.readLine());
//            System.out.println(reader.readLine());
//            System.out.println(reader.readLine());
//            System.out.println(reader.readLine());  //jeśli nie ma już danych w pliku, system zwróci null

            BufferedWriter writer = new BufferedWriter(new FileWriter("baza.txt")); //przepiszemy zawartość pliku dane.txt do baza.txt

            String tresc = "";
            while ((tresc = reader.readLine()) != null) //rzutowanie do Stringa, żeby porównać z nullem
            {

                writer.write(tresc);  // przepianie jednego pliku do drugiego pliku
                writer.newLine();

//                System.out.println(tresc);
            }

            writer.close();
            reader.close();

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        //JAK DZIAŁĄ METODA PRINTF

//        Main.test(1,2,3,4,5,"lala", 'd');
    }

    static void test(Object... a )
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }
}

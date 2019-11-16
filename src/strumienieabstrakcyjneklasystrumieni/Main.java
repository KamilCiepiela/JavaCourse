package strumienieabstrakcyjneklasystrumieni;

import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inS;  //operuje na bajtach
        OutputStream outS;  //operuje na bajtach

        Reader reader;  //może czytać z formie znakowej
//        Writer writer;  //może zapisywać z formie znakowej

//        Writer writer = new FileWriter("nazwaPliku.txt");  //utworzenie pliku
//        Writer writer = new BufferedWriter(new FileWriter("nazwaPliku.txt"));

        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("nazwaPliku.txt")));
        //łączenie strumieni polega na łączzeniu jednego konstruktora w drugim konstruktorze
        // połaczenie strumieni powoduje połączenie własności jednego i drugiego
        // bufor gromadzi dane i wysyła wszystkie jako jeden pakunek (chyba, że się skonczy jego pojemność to wcześniej)
        // poprawia to szybkośc zapisu, bo zapis do pliku jest operacją systemową - długotrwałą, a zapis do bufora jest operacją na pamieci - dużo krótszą

//        writer.write("lala");  //zapis treści do pliku
        ((BufferedWriter)writer).write("lala");

        ((BufferedWriter)writer).newLine(); // metoda new line w klasie Writer nie istnieje - trzba ją rzutować na BufforedWriter, która tą metodę ma

        ((BufferedWriter)writer).write("następna linia");

//        writer.close();  //ZAWSZE NALEŻY ZAMYKAĆ STRUMIEŃ WEJŚCIA / WYJŚCIA!!!
        ((BufferedWriter)writer).close();


    }

    void nazwaF(InputStream inS){

    }
}

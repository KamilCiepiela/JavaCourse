package strumieniearchiwizacjadanychzip;

import java.io.*;
import java.util.zip.*;

public class Main {

    public static final int BUFFOR = 1024;  // jako bufor należy dawać wielokrotnosć 8 (1 bajt to 8 bitów)

    public static void main(String[] args)
    {
        String[] tab = new String[] {"build.xml", "manifest.mf", "inny.txt", "obrazek.jpeg"};
        byte tmpData[] = new byte[BUFFOR]; // wielkośc buforu, w którym będziemy przechowywać tymczasowe dane
        try {
            ZipOutputStream zOutS = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("nazwamojegozipa.zip"), BUFFOR));
            // dla szybszego wykonywania dajemy BufferedOutputStream, a do otwarcia pliku jest FileInputStream

            for (int i = 0; i < tab.length; i++) {
//                BufferedInputStream inS = new BufferedInputStream(new FileInputStream("inny.txt"), BUFFOR);  // będzie czytał plik i zapisywał go w buforze
                BufferedInputStream inS = new BufferedInputStream(new FileInputStream(tab[i]), BUFFOR);  // będzie czytał tablicę i zapisywał ją w buforze

//                zOutS.putNextEntry(new ZipEntry("inny.txt"));
                zOutS.putNextEntry(new ZipEntry(tab[i]));
                //wrzucamy plik w kolejkę do zipowania, ale on jest już otwarty poprzednią komendą
                // tutaj wykonujemy operacje na pliku, aż do zamknięcia - closeEntry

                int counter; // licznik, ile bajtów będzie odczytanych
                while ((counter = inS.read(tmpData, 0, BUFFOR)) != -1)
                    zOutS.write(tmpData, 0, counter);  // counter tutaj oznacza, że kolejny plik zostanie dopisany do końca ostatniego, niepełnego pliku, który został wcześniej odczytany

                zOutS.closeEntry();  //zamykamy wpis
                inS.close();  // zamykamy strumień wejściowy pliku
            }
            zOutS.close();  //zamykamy strumień całego zipu
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

/*
 * AAAAKKKLLLMMM - zapis oryginalny; to jest tedundancyjne (nadmiarowe)
 * 4A3K3L3M      - zapis po kompresji; to jest zoptymalizowane
 *
 */

package plikiorazkatalogi;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            File katalog = new File("video kursy" + File.separator + "php" + File.separator + "mysql");  // w ten sposób robi się podkatalogi uniwersalne

//            katalog.mkdir(); //do 1 katalogu
            katalog.mkdirs();  // do wielu katalogów

            File plik2 = new File("video kursy" + File.separator + "php" + File.separator + "mysql", "lekcja1.txt");
            if (!plik2.exists())
                plik2.createNewFile();

            File plik = new File("test.txt");

            if (!plik.exists())
            {
                plik.createNewFile();
            }

            System.out.println("--------------");
            System.out.println(plik.getPath());
            System.out.println(plik.getAbsolutePath()); //dosłowna ścieżna
            System.out.println(plik.getCanonicalPath()); // zawsze prawdziwa, zamienia separatory znaków - jest lepsza niż absolutna
            System.out.println("--------------");

            System.out.println("Czy mogę pisać? :" + plik.canWrite());
            System.out.println("Czy mogę uruchomić? :" + plik.canExecute());
            System.out.println("Czy mogę odczytać? :" + plik.canRead());
            System.out.println("Czy jest ukryty? :" + plik.isHidden());
            System.out.println("Czy jest plikiem? :" + plik.isFile());
            System.out.println("Ostatnio modyfkowany :" + new Date(plik.lastModified()));
            System.out.println("Długość pliku w bajtach (il znaków) :" + plik.length());

            System.out.println("--------------");
            Main.wypiszSciezki(new File(System.getProperty("user.dir")));
            System.out.println("--------------");
//                plik.delete();  // można usuwać dowolne pliki, ale katalogi TYLKO PUSTE

            }

            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

//        System.out.println(System.getProperty("user.dir"));  // aktualny katalog roboczy
        System.out.println(System.getProperty("user.home"));
    }

    static void wypiszSciezki(File nazwaSciezki) {
        String[] nazwyPlikowIKatalogow = nazwaSciezki.list();
        System.out.println(nazwaSciezki.getPath());

        for (int i = 0; i < nazwyPlikowIKatalogow.length; i++) {
            File p = new File(nazwaSciezki.getPath(), nazwyPlikowIKatalogow[i]);

//            if (p.isFile())  // dzięki temu znaleźliśmy tylko pliki, również w podktalogach, ale bez wtpisywania katalogów
            System.out.println(p);

            if (p.isDirectory()){
//                System.out.println(p); // to bez if wyżej znajdzie tylko katalogi, bez plików
                wypiszSciezki(new File(p.getPath()));  // wywołujemy metodę w metodzie - jeśli natrafi na folder to wypisze wszystkie pliki wewnątrz folderu
            }
        }
    }
}


package strumieniearchiwizacjadanych;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    public static final int BUFFOR = 1024;

    public static void main(String[] args)
    {
        File katalog = new File(System.getProperty("user.dir") + File.separator + "nazwamojegozipa");
        // "user.dir" - podaje ścieżke plilu na katalog użytkownia

        ZipEntry wpis = null;

        byte tmpData[] = new byte[BUFFOR];

        try {
            if(!katalog.exists())
                katalog.mkdir();  // tworzenie katalogu

            ZipInputStream zInS = new ZipInputStream(new BufferedInputStream(new FileInputStream("nazwamojegozipa.zip"), BUFFOR));

            while((wpis = zInS.getNextEntry()) != null)
            {
                BufferedOutputStream fOutS = new BufferedOutputStream(new FileOutputStream(katalog + File.separator + wpis.getName()), BUFFOR);  //stworzenie ścieżki do pliku w rozpakowywanym katalogu

                int counter;
                while ((counter = zInS.read(tmpData, 0, BUFFOR)) != -1)
                    fOutS.write(tmpData, 0, counter);

                fOutS.close();
                zInS.closeEntry();
            }

            zInS.close();

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
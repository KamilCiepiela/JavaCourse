package strumienieoknowyboruplikow;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main extends JFrame
{
    public Main()
    {
        this.setTitle("Okno wyboru plików");
        this.setBounds(250, 300, 300, 250);

        final JFileChooser wyborPlikow = new JFileChooser();
        wyborPlikow.setCurrentDirectory(new File(System.getProperty("user.dir"))); //ustawiamy, żeny domyślnie okno otwierało się w aktualnym folderze, a nie w dokumentach (z defaultu)
        wyborPlikow.setMultiSelectionEnabled(true);  // zaznaczanie wielu plików (ale nie folderów) do wyboru w oknie otwierania

        wyborPlikow.setAcceptAllFileFilterUsed(true);  //true domyślnie, false, jesli nie chcemy umożliwić możliwości wyboru wszytkich plików

        wyborPlikow.setFileFilter(new FiltrRozszerzen("Pola testowe", ROZSZERZENIA_TEKSTOWE));
        wyborPlikow.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Katalogi";
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tmp = wyborPlikow.showOpenDialog(rootPane);  //dodajemy wybór plików do buttonu, rootPane to stała, względem której będzie się wyświetlało okno wyboru plików.
                if (tmp == 0)
//                    System.out.println(tmp);  // 0 oznacza otworzenie, 1 - inną akcję
                    stworzPlikZip(wyborPlikow.getSelectedFiles());

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                wyborPlikow.showSaveDialog(rootPane);  //dodajemy wybór plików do buttonu, rootPane to stała, względem której będzie się wyświetlało okno wyboru plików.
                wyborPlikow.showDialog(rootPane, "ZIP in that place");  //pierwszy parametr, w którym miejscu ma się pojawić, drugie, jak ma się nazywać
            }
        });

        this.panelButtonow.add(button1);
        this.panelButtonow.add(button2);

        this.getContentPane().add(panelButtonow);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel panelButtonow = new JPanel();
    private JButton button1 = new JButton("Otwórz");
    private JButton button2 = new JButton("Zapisz");
    private final String[] ROZSZERZENIA_TEKSTOWE = new String[]{".txt", ".xml"};

    public void stworzPlikZip(File[] pliki){
        for (int i = 0; i < pliki.length; i++)
            System.out.println(pliki[i].getPath());
        }

    public static void main(String[] args) {

        new Main().setVisible(true);
    }

    private class FiltrRozszerzen extends FileFilter{

        public FiltrRozszerzen(String opis, String[] rozszerzenia)
        {
            this.opis = opis;
            this.rozszerznia = rozszerzenia;
        }

        @Override
        public boolean accept(File f) {
            for (int i = 0; i < rozszerznia.length; i++)
                if (f.getName().toLowerCase().endsWith(this.rozszerznia[i]) || f.isDirectory())
                    return true;

                return false;
        }

        @Override
        public String getDescription() {
            return opis;
        }

        private String opis;
        private String[] rozszerznia;
    }
}

package strumieniefilezipper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.lang.*;
import java.util.ArrayList;

public class FileZipper extends JFrame
{
    public FileZipper()
    {
        this.setTitle("Zipper");
        this.setBounds(275,300,250,250);
        this.setJMenuBar(pasekMenu);

        JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));

        Action akcjaDodawania = new Akcja("Dodaj", "Dodaj nowy wpis do archiwum", "ctrl D", new ImageIcon("dodaj.png")); // coś nie działa z ikonami
        Action akcjaUsuwania = new Akcja("Usuń", "Usuń zanzaczony/ zaznaczone wpisy do archiwum", "ctrl U", new ImageIcon("usun.png"));
        Action akcjaZipowania = new Akcja("Zip", "Zipuj", "ctrl Z");

        JMenuItem menuOtwórz = menuPlik.add(akcjaDodawania);
        JMenuItem menuUsun = menuPlik.add(akcjaUsuwania);
        JMenuItem menuZip = menuPlik.add(akcjaZipowania);

        bDodaj = new JButton(akcjaDodawania);
        bUsun = new JButton(akcjaUsuwania);
        bZip = new JButton(akcjaZipowania);
        JScrollPane scrollek = new JScrollPane(lista);

        lista.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout layout = new GroupLayout(this.getContentPane());

        layout.setAutoCreateContainerGaps(true);  //sprawia, że są odstępy od naszego kontenera
        layout.setAutoCreateGaps(true);  // sprawia, że są odstępy między komponentami w kontenerze
        layout.setHorizontalGroup(  // napierw patrzymy na świat poziomo, a później pionowo
                layout.createSequentialGroup()
                .addComponent(scrollek, 100, 150, Short.MAX_VALUE)  // wartości parametrów listy + może się rozszerzać w nieskończoność
                .addContainerGap(0, Short.MAX_VALUE)  //dodanie odstępu między buttonami, a polem tekstowym
                .addGroup(
                    layout.createParallelGroup().addComponent(bDodaj).addComponent(bUsun).addComponent(bZip))  // dodawanie buttonów równolegle od siebie, w kolejności od góry
        );

        layout.setVerticalGroup(
                layout.createParallelGroup()
                .addComponent(scrollek, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)  // wartości parametrów listy + może się rozszerzać w nieskończoność
                .addGroup(layout.createSequentialGroup().addComponent(bDodaj).addComponent(bUsun).addGap(5,40,Short.MAX_VALUE).addComponent(bZip))  // przerwa między buttonami dodana jako addGap w grupie
        );

        this.getContentPane().setLayout(layout);  // teraz będzie groupLayout na szybce
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();  //zmniejszy okno do wielkości komponentów w oknie
    }

    private DefaultListModel modelListy = new DefaultListModel()  // lista, do której dodajemy wszystkie ścieżki plików, które dodajemy do archiwum
    {
        @Override
        public void addElement(Object obj){
            lista.add(obj);
            super.addElement(((File)obj).getName());
        }

        @Override
        public Object get(int index){  // tu zwracamy ścieżkę z ArrayList powyżej
            return lista.get(index);  //podmieniemy Stringa ze ścieżki z addElement powyżej na obiekt File w tej metodzie
        }

        @Override
        public Object remove(int index) {  // tu usuwamy elementy z listy ścieżek do plików
            lista.remove(index);  //usuwa elementy z indeksu listy
            return super.remove(index);  //usuwa wpisy z listy standardowo
        }

            ArrayList lista = new ArrayList();  //lista do przechowywania całych ścieżek do plików

    };
    // możemy sobie rozszerzyć każdą klasę o klasę anonimową!!!!!!!!!!!!!
    // teraz mam rozszerzoną klasę ale nie posiadam do niej dodatkowego odwołania (dodatkowej nazwy)!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // teraz mogę nadpisywać wszystko, co znajduje się w DefaultListModel!!!!!!!!!!!!!!

    private JList lista = new JList(modelListy);  //tutaj wyświetla się ta lista zaznaczonych elementów
    private JButton bDodaj;
    private JButton bUsun;
    private JButton bZip;
    private JMenuBar pasekMenu = new JMenuBar();
    private JFileChooser wybieracz = new JFileChooser();


    public static void main(String[] args)
    {
        new FileZipper().setVisible(true);
    }

    private class Akcja extends AbstractAction {
        public Akcja(String nazwa, String opis, String klawiaturowySkrót){
            this.putValue(Action.NAME, nazwa);
            this.putValue(Action.SHORT_DESCRIPTION, opis);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(klawiaturowySkrót));
        }

        public Akcja(String nazwa, String opis, String klawiaturowySkrót, Icon ikona){
            this(nazwa, opis, klawiaturowySkrót);
            this.putValue(Action.SMALL_ICON, ikona);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Dodaj"))
                dodajWipsyDoArchiwum();
            else if (e.getActionCommand().equals("Usuń"))
                usunWpisZListy();
            else if (e.getActionCommand().equals("Zip"))
                System.out.println("Zipowanie");
        }


        private void dodajWipsyDoArchiwum()
        {
            wybieracz.setCurrentDirectory(new File(System.getProperty("user.dir")));  // ustawia początek wybierania w obecnym katalogu
            wybieracz.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  //umozliwia wybieranie plików i katalogów
            wybieracz.setMultiSelectionEnabled(true);  //pozwala wybierać wiecej niż 1 element

            int tmp = wybieracz.showDialog(rootPane, "Dodaj do archiwum");  // gdzie ma się pojawić i jak ma się nazywać

            if(tmp == JFileChooser.APPROVE_OPTION) {
                File[] sciezki = wybieracz.getSelectedFiles();  // miejsce do przechowywania wybranych plików po wciśnięciu Dodaj do archiwum

                for(int i = 0; i < sciezki.length; i++)
                    if (!czyWpisSiePowtarza(sciezki[i].getPath()))  // jeśli wpis sie nie powtarza, to go dodaj do listy
                    modelListy.addElement(sciezki[i]);
            }
        }

        private boolean czyWpisSiePowtarza(String testowanyWpis){  // sprawdzanie czy dodawane elementy się nie powtarzają
            for (int i = 0; i < modelListy.getSize(); i++)
                if(((File)modelListy.get(i)).getPath().equals(testowanyWpis))
                    return true;

            return false;
        }

        private void usunWpisZListy() {  //usuwanie zaznaczonych plików i katalogów z listy po dodaniu
            int[] tmp = lista.getSelectedIndices();
            for (int i = 0; i < tmp.length; i++)  //  zaznacza po nr indeksów z listy popdanych plików i katalogów
                modelListy.remove(tmp[i]-i);  // w Array List lista cofa indeks po usunięciu, więc po przejściu iteracji nie usuwało by ostatniego elementu w tablicy
        }  // usuwamy tą metodą tylko nazwy plików z listy, ale nie odświeżamy i usuwamy listy ścieżek do plików w ArrayList
    }
}
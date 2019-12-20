package strumieniefilezipper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.*;

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

        lista.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout layout = new GroupLayout(this.getContentPane());

        layout.setAutoCreateContainerGaps(true);  //sprawia, że są odstępy od naszego kontenera
        layout.setAutoCreateGaps(true);  // sprawia, że są odstępy między komponentami w kontenerze
        layout.setHorizontalGroup(  // napierw patrzymy na świat poziomo, a później pionowo
                layout.createSequentialGroup()
                .addComponent(lista, 100, 150, Short.MAX_VALUE)  // wartości parametrów listy + może się rozszerzać w nieskończoność
                .addContainerGap(0, Short.MAX_VALUE)  //dodanie odstępu między buttonami, a polem tekstowym
                .addGroup(
                    layout.createParallelGroup().addComponent(bDodaj).addComponent(bUsun).addComponent(bZip))  // dodawanie buttonów równolegle od siebie, w kolejności od góry
        );

        layout.setVerticalGroup(
                layout.createParallelGroup()
                .addComponent(lista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)  // wartości parametrów listy + może się rozszerzać w nieskończoność
                .addGroup(layout.createSequentialGroup().addComponent(bDodaj).addComponent(bUsun).addGap(5,40,Short.MAX_VALUE).addComponent(bZip))  // przerwa między buttonami dodana jako addGap w grupie
        );

        this.getContentPane().setLayout(layout);  // teraz będzie groupLayout na szybce
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();  //zmniejszy okno do wielkości komponentów w oknie
    }

    private JList lista = new JList();
    private JButton bDodaj;
    private JButton bUsun;
    private JButton bZip;
    private JMenuBar pasekMenu = new JMenuBar();


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
                System.out.println("Dodawanie");
            else if (e.getActionCommand().equals("Usuń"))
                System.out.println("Usuwanie");
            else if (e.getActionCommand().equals("Zip"))
                System.out.println("Zipowanie");
        }
    }
}
package ramkaakcje;

import org.w3c.dom.events.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Pasek menu");
        this.setBounds(300,300,300,200);
        this.setJMenuBar(pasekMenu);

//        pasekMenu.add(new JMenu("Plik")); // jeszcze inny sposób na dodanie
//        JMenu menuPlik = new JMenu("Plik"); // inny sposób dodawania przycisków do pliku
//        pasekMenu.add(menuPlik); // inny sposób dodawania przycisków do pliku cd.
        JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));
        menuPlik.setMnemonic('p');  //dodawanie HotKey (alt + p)

//        pasekMenu.add(new JMenu("Edycja")); // dodanie kolejnej pozycji w menu

        JMenuItem podMenuNowy = menuPlik.add(new JMenuItem("Nowy")); // == menuPlik.add("Nowy");
        podMenuNowy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tu jest kod, który tworzy nowy plik");
            }
        });

        menuPlik.addSeparator();
        //
        Action actionSave = new ActionSave("Zapisz", "Zapisujemy na dysku", "ctrl S", new ImageIcon("Zapisz.jpeg"), KeyEvent.VK_Z);
//        final JMenuItem podMenuZapisz = menuPlik.add(new JMenuItem("Zapisz"));  // stara wersja bez klasy Action
        final JMenuItem podMenuZapisz = menuPlik.add(actionSave);
        buttonZapisz = new JButton(actionSave);

//        podMenuZapisz.setEnabled(false); // zmiana po dodakniu Akcji
        actionSave.setEnabled(false);

        /*
        podMenuZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ZAPISUJEMY NA DYSKU!");
                podMenuZapisz.setEnabled(flagaObszaruTekstowego = false);
            }
        });

        podMenuZapisz.setToolTipText("Zapisanie pliku na dysku");
        podMenuZapisz.setMnemonic('z'); //dodawanie HotKey (alt + z)
        podMenuZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
//        podMenuZapisz.setAccelerator(KeyStroke.getKeyStroke(String.valueOf(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK)))); // druga wersja sposobu szybkiego zapisu
        */

        menuPlik.add(new JMenuItem("Wczytaj"));
        menuPlik.addSeparator();
//        menuPlik.add(new JMenu("Opcje")); // tworzy kolejne menu w podmenu, które możemy rozwijać
        JMenu menuOpcje = new JMenu("Opcje");
        menuPlik.add(menuOpcje);

        menuOpcje.add(new JMenuItem("Opcja 1"));
        menuOpcje.add(new JMenuItem("Opcja 2"));
        menuOpcje.add(new JMenuItem("Opcja 3"));
        menuOpcje.add(tylkoDoOdczytu);

        tylkoDoOdczytu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tylkoDoOdczytu.isSelected())
//                    podMenuZapisz.setEnabled(false); // zmiana po dodaniu Akcji; actionSave musi być finalne, żeby użyć w wewnętrznej klasie
                    actionSave.setEnabled(false);
                else
//                    podMenuZapisz.setEnabled(flagaObszaruTekstowego); // zmiana po dodaniu Akcji;
                    actionSave.setEnabled(flagaObszaruTekstowego);
            }
        });

        JMenu menuPomoc = pasekMenu.add(new JMenu("Pomoc")); // dodanie kolejnej pozycji na pasku głównym menu

        menuPomoc.add(new JMenuItem("FAQ"));

        obszarTekstowy.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (tylkoDoOdczytu.isSelected())
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_V && tylkoDoOdczytu.isSelected()) // CTRL + V + tylkoDoOdczytu zaznaczony
                if (tylkoDoOdczytu.isSelected()) // pisać można, nie można kopiować
                    e.consume();
                else if (!(obszarTekstowy.getText() + e.getKeyChar()).equals(przedZmianaObszaruTekstowego) && czyToAscii((e.getKeyChar())))
                {
                    przedZmianaObszaruTekstowego = obszarTekstowy.getText() + e.getKeyChar();
//                    podMenuZapisz.setEnabled(flagaObszaruTekstowego = true); // zmiana po dodaniu Akcji;
                    actionSave.setEnabled(flagaObszaruTekstowego = true);
                }
//                System.out.println(obszarTekstowy.getText() + e.getKeyChar()); //bez grtKeyChar pokazywało na konsoli 1 znak do tyłu; można usunąć po dodaniu do Akcji
            }
        });

        this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().add(obszarTekstowy);
        this.getContentPane().add(buttonZapisz);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JMenuBar pasekMenu = new JMenuBar();
    private JCheckBoxMenuItem tylkoDoOdczytu = new JCheckBoxMenuItem("Tylko do odczytu");
    private JTextArea obszarTekstowy = new JTextArea();
    private boolean flagaObszaruTekstowego = false; //stan początkowy - fałsz, flaga ma sprawdzać czy były zmiany w obszarze tekstowym
    private String przedZmianaObszaruTekstowego = "";
//    private JButton buttonZapisz = new JButton("Zapisz");
    private JButton buttonZapisz; //zmiana, po dodaniu Action; nowy button jest tworzony w związku z akcją

    private class ActionSave extends AbstractAction
    {
        public ActionSave (String nazwa, String podpowiedz, String kalwiaturowySkrot, Icon ikona, int mnemonicKey)
        {
            this.putValue(Action.NAME, nazwa);
            this.putValue(Action.SHORT_DESCRIPTION, podpowiedz);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(kalwiaturowySkrot));
            this.putValue(Action.SMALL_ICON, ikona);
            this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ZAPISUJEMY NA DYSKU!");
            this.setEnabled(flagaObszaruTekstowego = false);
        }
    }

    private boolean czyToAscii (char zn)
    {
        for (int i = 0; i < 256; i++)  //sprawdzanie czy wprowadzony znak jest znakiem Ascii, a nie np. F1
            if (zn == i)
                return true;

        return false;
    }


    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
package ramkaakcje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

//        pasekMenu.add(new JMenu("Edycja")); // dodanie kolejnej pozycji w menu

        JMenuItem podMenuNowy = menuPlik.add(new JMenuItem("Nowy")); // == menuPlik.add("Nowy");
        podMenuNowy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tu jest kod, który tworzy nowy plik");
            }
        });

        menuPlik.addSeparator();
        final JMenuItem podMenuZapisz = menuPlik.add(new JMenuItem("Zapisz"));
        //
        podMenuZapisz.setEnabled(false);
        podMenuZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ZAPISUJEMY NA DYSKU!");
                podMenuZapisz.setEnabled(flagaObszaruTekstowego = false);
            }
        });
        //
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
                    podMenuZapisz.setEnabled(false);
                else
                    podMenuZapisz.setEnabled(true);
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
                else if (!(obszarTekstowy.getText() + e.getKeyChar()).equals(przedZmianaObszaruTekstowego))
                {
                    przedZmianaObszaruTekstowego = obszarTekstowy.getText();
                    podMenuZapisz.setEnabled(flagaObszaruTekstowego = true);
                }

                System.out.println(obszarTekstowy.getText() + e.getKeyChar()); //bez grtKeyChar pokazywało na konsoli 1 znak do tyłu

            }
        });

        this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().add(obszarTekstowy);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JMenuBar pasekMenu = new JMenuBar();
    private JCheckBoxMenuItem tylkoDoOdczytu = new JCheckBoxMenuItem("Tylko do odczytu");
    private JTextArea obszarTekstowy = new JTextArea();
    private boolean flagaObszaruTekstowego = false; //stan początkowy - fałsz, flaga ma sprawdzać czy były zmiany w obszarze tekstowym
    private String przedZmianaObszaruTekstowego = "";


    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
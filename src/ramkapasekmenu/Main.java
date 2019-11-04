package ramkapasekmenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JMenuItem podMenuZapisz = menuPlik.add(new JMenuItem("Zapisz"));
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


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JMenuBar pasekMenu = new JMenuBar();
    private JCheckBoxMenuItem tylkoDoOdczytu = new JCheckBoxMenuItem("Tylko do odczytu");


    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
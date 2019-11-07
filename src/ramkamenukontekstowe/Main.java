package ramkamenukontekstowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Menu kontekstowe");
        this.setBounds(300,300,300,200);

        JPopupMenu menuKontekstowe = new JPopupMenu();

//        menuKontekstowe.add(new JMenuItem("Zamknij"));
        menuKontekstowe.add(new JMenuItem(new AbstractAction("Zamknij") {  // stworzymy pozycję menu kontekstowego przy pomocy klasy anonimowej
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }));
        menuKontekstowe.add(new JMenuItem("Kopiuj"));
        menuKontekstowe.add(new JMenuItem("Wklej"));

//        this.getContentPane().addMouseListener(new MouseListener() {  // dodałem tego Listenera do szybki, ale mogę dodać również do buttona, obszaru tekstowego itp.
        this.getContentPane().addMouseListener(new MouseAdapter() {  // klasa abstrakcyjna, pozwalająca dodawać wybrane metody tej klasy
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("released");

                if (e.getClickCount() == 3 && e.getButton() == MouseEvent.BUTTON1 && e.isShiftDown())
                    JOptionPane.showMessageDialog(rootPane, "Aleś się naklikał:) lewym przyciskiem myszy");

//                if (e.getButton() == MouseEvent.BUTTON3) // prostsza metoda, ale nie stosowana często
                if (e.isPopupTrigger()) // stosowana najczęściej, ale trzeba o niej wiedzieć
                    menuKontekstowe.show(e.getComponent(), e.getX(), e.getY());  // dzięki temu menu kontekstowe pojawi się w dowolnym miejscu na ekranie
            }
        });

        this.getContentPane().add(testowiec, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

        private JButton testowiec = new JButton("test");

    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
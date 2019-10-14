package ramkazdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame {
    public Main() {
        super("Zdarzenia");
        this.setBounds(300, 300, 300, 200);

        initComponents();

        this.setDefaultCloseOperation(3);

    }

    public void initComponents() {
        kolorCzerwony = new JButton("Czerwony");

        kolorCzerwony.addActionListener(new sluchaczKolorow(Color.RED));

        panel.add(kolorCzerwony);

        this.getContentPane().add(panel);
    }

    JPanel panel = new JPanel();
    JButton kolorCzerwony;  //to jest komponent, a komponemty są źródłami zdarzeń

    private class sluchaczKolorow implements ActionListener  //gdyby klasa nie była wewnętrzna, nie miałby dostępu do wszystkich składowych pól klasy MAin, która rozszerza ramkę JFrame
    {

        public sluchaczKolorow(Color k)
        {
            this.kolor = k;


        }
        @Override
        public void actionPerformed(ActionEvent e)
        {

        }

        Color kolor;
    }

    public static void main(String[] args) {
        new Main().setVisible(true);

    }


}

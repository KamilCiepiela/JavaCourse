package ramkazdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame implements ActionListener//można też tu od razu zaimplementować interfejs ActionListener, ale trzeba dodać wszystkie abstrakcyjne metody (na końcu)
{
    public Main() {
        super("Zdarzenia");
        this.setBounds(300, 300, 300, 200);

        initComponents();

        this.setDefaultCloseOperation(3);

    }

    public void initComponents() {
        kolorCzerwony = new JButton("Czerwony");
        kolorCzarny = new JButton("Czarny");
        kolorNiebieski = new JButton("Niebieski");

        kolorCzerwony.addActionListener(new sluchaczKolorow(Color.RED));
//        kolorCzarny.addActionListener(new sluchaczKolorow(Color.BLACK));

        kolorNiebieski.addActionListener(this);

        panel.add(kolorCzerwony);
        panel.add(kolorCzarny);
        panel.add(kolorNiebieski);

        kolorCzarny.addActionListener(new ActionListener() { //jak chcemy coś zrobić na szybko i tylko raz to można skorzystać z takiej metody
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.BLACK);
            }
        });


        budujButton("Zielony", Color.GREEN); //użycie metody szybkiego budowania przycisków

        this.getContentPane().add(panel);
    }

    JPanel panel = new JPanel();
    JButton kolorCzerwony;  //to jest komponent, a komponemty są źródłami zdarzeń
    JButton kolorCzarny;
    JButton kolorNiebieski;

    public void budujButton(String nazwa, Color k)
    /*metoda do szybkiego dodawania przycisków!!!
    przy drugiej metodzie Color K powinien być FINAL
    ta KLASA ANONIMOWA pozwala na szybsze budowanie wielu przycisków - nie musisz budować klasy wewnętrznej poniżej
     */ {
        JButton przycisk = new JButton(nazwa);
//        przycisk.addActionListener(new sluchaczKolorow(k)); //musisz mieć klasę słuchacza
        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(k);
            }
        }); //jeszcze szybsza metoda tworzenia


        panel.add(przycisk);
    }

    @Override
    public void actionPerformed(ActionEvent e) //wykorzystany do stworzena przycisku Niebieskiego
    {
        if (e.getSource() == kolorNiebieski)
            panel.setBackground(Color.BLUE);
    }

    private class sluchaczKolorow implements ActionListener  //gdyby klasa nie była wewnętrzna, nie miałby dostępu do wszystkich składowych pól klasy MAin, która rozszerza ramkę JFrame
    {

        public sluchaczKolorow(Color k) {
            this.kolor = k;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(kolor);
        }

        Color kolor;
    }

    public static void main(String[] args) {
        new Main().setVisible(true);

    }


}

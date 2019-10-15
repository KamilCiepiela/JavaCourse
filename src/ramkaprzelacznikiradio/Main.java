package ramkaprzelacznikiradio;

import javax.swing.*;
import java.awt.*;
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
        this.setTitle("Grupy Przełączników Radio");
        this.setBounds(300,300,300,200);
        panel2.add(etykieta);

//        JRadioButton malyPrzelacznik = new JRadioButton("Mały"); //domyślnie jest FALSE
//        JRadioButton serdniPrzelacznik = new JRadioButton("Średni"); //domyślnie jest FALSE
//
//        malyPrzelacznik.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                etykieta.setFont(new Font("Monospaced", Font.BOLD, 25));
//            }
//        });
//
//        groupSize.add(malyPrzelacznik); //dodawanie przełaczników do grupy
//        groupSize.add(serdniPrzelacznik);
//
//        panel.add(malyPrzelacznik);
//        panel.add(serdniPrzelacznik);

        zbudujPrzelacznikRozmiar("Mały", 15);
        zbudujPrzelacznikRozmiar("Średni", 25);
        zbudujPrzelacznikRozmiar("Duży", 35);

        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.getContentPane().add(panel3, BorderLayout.CENTER);
        this.getContentPane().add(panel2, BorderLayout.SOUTH);


        this.setDefaultCloseOperation(3);
    }

    public void zbudujPrzelacznikRozmiar(String nazwa, final int rozmiar)  //wartość rozmiaru musi być finalna
    {
        JRadioButton przelacznik = new JRadioButton(nazwa);

        przelacznik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etykieta.setFont(new Font("Monospaced", Font.PLAIN, rozmiar));
            }
        });

        groupSize.add(przelacznik);
        panel3.add(przelacznik);
    }

    public void zbudujPrzelacznikKolor(String nazwa, final Color k)  //wartość rozmiaru musi być finalna
    {
        JRadioButton przelacznik = new JRadioButton(nazwa);

        przelacznik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etykieta.setForeground(k);
            }
        });

        groupColor.add(przelacznik);
        panel.add(przelacznik);
    }

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel etykieta = new JLabel("Coś");
    ButtonGroup groupSize = new ButtonGroup(); //nie można mieć 2 wartości true w grupie (można zaznaczyć tylko jedną opcję w grupie)
    ButtonGroup groupColor = new ButtonGroup(); //nie można mieć 2 wartości true w grupie (można zaznaczyć tylko jedną opcję w grupie)



    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }



}

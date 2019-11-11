package ramkalista;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Lista");
        this.setBounds(300,300,300,200);

//        String[] nazwa = new String[] {"lala", "hmm"};
        listaPrzedmiotow.setVisibleRowCount(4);
//        listaPrzedmiotow.setPrototypeCellValue("");  // ustawia szerokość widzianej listy na xxx znaków
//        listaPrzedmiotow.setFixedCellHeight(40);
//        listaPrzedmiotow.setFixedCellWidth(100);
//        listaPrzedmiotow.setBackground(Color.PINK);
        listaPrzedmiotow.setSelectionBackground(Color.BLUE);
        listaPrzedmiotow.setSelectionForeground(Color.GREEN);

//        listaPrzedmiotow.setLayoutOrientation(JList.VERTICAL_WRAP);  // zwija listę, odpowiednio poziomo lub pionowo; nie ma scrolla
        listaPrzedmiotow.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        listaPrzedmiotow.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Zmieniłem się " + (++i) + " razy.");

                if (e.getValueIsAdjusting())
                    System.out.println("Trzymam button myszy");
                else
                    System.out.println("Puściłem button myszy");

                if (!e.getValueIsAdjusting())
                {
//                    String zawartosc = (String)((JList)e.getSource()).getSelectedValue();  //zwraca 1 obiekt, ten który kliknęliśmy pierwszy przy zaznaczeniu wielu pozycji z listy
                   Object[] wartosciWLiscie = ((JList)e.getSource()).getSelectedValues();

                   String przedmioty = "";

                   for (int i = 0; i < wartosciWLiscie.length; i++)
                       przedmioty += (String)wartosciWLiscie[i] + " ";

                    System.out.println(przedmioty);

                    komunikat.setText("Nie lubię następujących przedniotów: " + przedmioty);
                }

            }
        });

        DefaultListModel modelListy = new DefaultListModel();

        String[] tekst = new String[] {"Matematyka", "Fizyka", "Informatyka", "Biologia", "Chemia", "WOS", "PO", "Historia"};

        for (int i = 0 ; i < tekst.length; i++)
            modelListy.addElement(tekst[i]);

        modelListy.addElement("k");
        modelListy.addElement("g");
        modelListy.addElement("h");

        JList lista2 = new JList(modelListy);  // nowa lista tworzona z modelu listy
//        JList lista2 = new JList(new String[] {"k", "g", "h"});  // nowa lista, do której będziemy dodawać pozycje

        modelListy.addElement("lala"); // możemy dodawać elementy listy gdziekolwiek w klasie, BARDZO WAŻNE!!!
//        modelListy.removeAllElements();  // usuniemy wszystkie elementy z listy

        lista2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                modelListy.removeAllElements();  // usuwa wszystkie elemnty po kliknięciu w listę
            }
        });


//        panelListy.add(listaPrzedmiotow);
        panelListy.add(strollListy);
        panelKomunikatu.add(komunikat);


//        this.getContentPane().add(listaPrzedmiotow);
        this.getContentPane().add(panelListy, BorderLayout.NORTH);
        this.getContentPane().add(panelKomunikatu, BorderLayout.CENTER);
        this.getContentPane().add(lista2, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private int i = 0;
    private JList listaPrzedmiotow = new JList(new String[] {"Matematyka", "Fizyka", "Informatyka", "Biologia", "Chemia", "WOS", "PO", "Historia"});
    private JScrollPane strollListy = new JScrollPane(listaPrzedmiotow);
    private JPanel panelListy = new JPanel();
    private JPanel panelKomunikatu = new JPanel();
    private JLabel komunikat = new JLabel();

    public static void main(String[] args)
    {
        new Main().setVisible(true);
    }
}

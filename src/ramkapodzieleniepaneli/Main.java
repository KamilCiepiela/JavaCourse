package ramkapodzieleniepaneli;

import javax.print.event.PrintJobAttributeListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Podzielenie paneli");
        this.setBounds(300,300,300,200);

        panelListy.add(lista);
        panelObrazka.add(obrazek);
        panelOpisu.add(opis);

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // służy do ograniczenia wyboru do jednej pozycji na raz
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               if (!e.getValueIsAdjusting()){
                   Obrazek img = (Obrazek)((JList)e.getSource()).getSelectedValue();

                    obrazek.setIcon(img.getImage());
                    opis.setText(img.getDescription());
               }
            }
        });

        JSplitPane podzielenie = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelListy, panelObrazka);
        JSplitPane podzielenieGlowne = new JSplitPane(JSplitPane.VERTICAL_SPLIT, podzielenie, panelOpisu);

        this.getContentPane().add(podzielenieGlowne);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JPanel panelListy = new JPanel();
    JPanel panelObrazka = new JPanel();
    JPanel panelOpisu = new JPanel();
//    JList lista = new JList(new String[]{"a", "b"});  // wprowadzenie do listy info z tablicy
    JList lista = new JList( // wprowadzenie do listy info z nazwy obrazka
        new Obrazek[] {
                new Obrazek("niebieski", "piekny kolorek niebieski"),
                new Obrazek("czerwony", "piekny kolorek czerwony"),
                new Obrazek("zielony", "piekny kolorek zielony"),
        });

    JLabel obrazek = new JLabel();
    JLabel opis = new JLabel();

    private class Obrazek
    {
        public Obrazek(String nazwa, String opis)
        {
            this.nazwa = nazwa;
            this.opis = opis;

            obrazek = new ImageIcon(nazwa + ".gif");
        }
        public String toString()
        {
            return nazwa;
        }
        public ImageIcon getImage()
        {
            return obrazek;
        }
        public String getDescription()
        {
            return opis;
        }

        String nazwa, opis;
        ImageIcon obrazek;
    }

    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
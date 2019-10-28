package ramkalistykombinowane;

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
        this.setTitle("Własne menu");
        this.setBounds(300,300,300,200);

        kombinacja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(((JComboBox) e.getSource()).getSelectedItem());
//                        kombinacja.getSelectedItem();  // tak też można się dostać do wywoływanego elementu
                // pierwsza metoda
                ColorHandler handler = (ColorHandler)(((JComboBox) e.getSource()).getSelectedItem());
                ((JComboBox)e.getSource()).setBackground(handler.getColor());

                // druga metoda
                ((JComboBox)e.getSource()).setBackground(((ColorHandler)(((JComboBox) e.getSource()).getSelectedItem())).getColor());


            }
        });
        panel.add(kombinacja);

//        kombinacja.addItem("Czarny");
//        kombinacja.addItem(new String("Czarny"));
//        kombinacja.addItem(new String("Zielony"));
        kombinacja.addItem(new ColorHandler("Czarny", Color.BLACK));
        kombinacja.addItem(new ColorHandler("Zielony", Color.GREEN));
        kombinacja.addItem(new ColorHandler("Niebieski", Color.BLUE));
        kombinacja.addItem(new ColorHandler("Żółty", Color.YELLOW));




        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(3);
    }

    private class ColorHandler{
        public ColorHandler(String colorName, Color kolor)
        {
            this.kolor = kolor;
            this.colorName = colorName;
        }

        @Override
        public String toString(){
            return this.colorName;
        }

        public Color getColor() {
            return this.kolor;
        }

        private Color kolor;
        private String colorName;
    }

    private JPanel panel = new JPanel();
    private JComboBox kombinacja = new JComboBox();

    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
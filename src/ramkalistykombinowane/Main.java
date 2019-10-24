package ramkalistykombinowane;

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
        this.setTitle("Własne menu");
        this.setBounds(300,300,300,200);

        kombinacja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(((JComboBox) e.getSource()).getSelectedItem());
//                        kombinacja.getSelectedItem();  // tak też można się dostać do wywoływanego elementu
            }
        });
        panel.add(kombinacja);

//        kombinacja.addItem("Czarny");
//        kombinacja.addItem(new String("Czarny"));
//        kombinacja.addItem(new String("Zielony"));
        kombinacja.addItem(new ColorHandler());



        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(3);
    }

    private class ColorHandler{

    }

    private JPanel panel = new JPanel();
    private JComboBox kombinacja = new JComboBox();

    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
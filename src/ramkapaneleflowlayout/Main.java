package ramkapaneleflowlayout;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame
{
    public Main()
    {
        this.setBounds(750, 300, 300, 200);

        initComponents();

        this.setDefaultCloseOperation(3);

    }

    public void initComponents()
    {
//        Container kontener = getContentPane();

        button1.setPreferredSize(new Dimension(100,100)); //panel odczytuje przeferowaną wielkość przycisków
        button2.setPreferredSize(button2.getPreferredSize());

        panel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);

//        this.getContentPane().add(new JButton("la"), BorderLayout.PAGE_START);
//        this.getContentPane().add(button1, BorderLayout.PAGE_START);
        this.getContentPane().add(panel1, BorderLayout.CENTER);
    }

    JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.TRAILING));  //dla paneli FlowLayout jest ustawieniem domyślnym!!!

    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");
    JButton button4 = new JButton("Button 4");

    public static void main(String[] args)
    {
        new Main().setVisible(true);
    }
}

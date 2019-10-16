package ramkatemplate;

import javax.swing.*;

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

        this.setDefaultCloseOperation(3);
    }

    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
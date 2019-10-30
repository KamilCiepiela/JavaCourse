package ramkawieleramek;

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
        this.setTitle("Aplikacja w wieloma ramkami");
        this.setBounds(300,300,300,200);

        nowaRamka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new NowaRamka(taRamka).setVisible(true);
                new Dialog(taRamka).setVisible(true);

            }
        });
        this.getContentPane().add(nowaRamka);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JFrame taRamka = this;
    JButton nowaRamka = new JButton("Stwórz ramkę");
    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
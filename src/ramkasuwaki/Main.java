package ramkasuwaki;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Suwaki");
        this.setBounds(300,300,300,200);

        wartoscSuwaka.setEditable(false);
        suwak.setMajorTickSpacing(10);  //wywoływanie podziałki głównej
        suwak.setMinorTickSpacing(1);  //wywoływanie podziałki pośredniej
        suwak.setPaintTicks(true);  //"malowanie" podziałki, bo wcześniej jej nie było widać
        suwak.setPaintLabels(true);  //widoczne podpisy głównych linii podziałki
        suwak.setSnapToTicks(true);  // suwak skacze do pełnych wartości, a nie ciągle

        suwak.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wartoscSuwaka.setText("" + ((JSlider)e.getSource()).getValue());

                tekst.setFont(new Font(tekst.getFont().getFontName(), tekst.getFont().getStyle(), ((JSlider)e.getSource()).getValue()));
            }
        });
        this.getContentPane().add(suwak, BorderLayout.NORTH);
        this.getContentPane().add(tekst, BorderLayout.CENTER);
        this.getContentPane().add(wartoscSuwaka, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JSlider suwak = new JSlider(JSlider.HORIZONTAL, 0 ,30, 15);
    JTextField wartoscSuwaka = new JTextField("" + suwak.getValue());
    JLabel tekst = new JLabel("coś");

    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
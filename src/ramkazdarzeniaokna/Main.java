package ramkazdarzeniaokna;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main extends JFrame implements WindowListener
{
    public Main()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Pola wyboru");
        this.setBounds(300,300,300,200);

//        this.addWindowListener(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                JOptionPane.showMessageDialog(rootPane, "Witaj :-)");
            }
        });

//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }

    @Override
    public void windowOpened(WindowEvent e) {
        JOptionPane.showMessageDialog(rootPane, "Witaj :-)");
    }

    @Override
    public void windowClosing(WindowEvent e) {
            int opcja = JOptionPane.showConfirmDialog(rootPane, "Czy na pewno chcesz zamknąć ten super ekstra program? :(");
            if (opcja == 0)
                this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Zapisujemy dane na dysku.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Jestem minimalizowany.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Jestem maksymalizowany.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Jestem aktywny.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Jestem nieaktywny.");
    }
}
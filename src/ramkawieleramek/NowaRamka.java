package ramkawieleramek;

import javax.swing.*;
import java.awt.*;

public class NowaRamka extends JFrame
{
    public NowaRamka(JFrame parent)
    {
        initComponents();

        int szerokosc = (int)parent.getBounds().getWidth();
        int wysokosc = (int)parent.getBounds().getHeight();

        int szerokoscRamki = this.getSize().width;
        int wysokoscRamki = this.getSize().height;
        this.setLocation(parent.getBounds().x + (szerokosc-szerokoscRamki)/2, parent.getBounds().y +(wysokosc-wysokoscRamki)/2);

    }

    public void initComponents(){
    this.setTitle("To jest ramka nr " + (++i));
    this.setBounds(400, 400, 350, 75);

        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel.add(zamknijMnie);
        panel.add(wylaczProgram);
        this.getContentPane().add(panel, BorderLayout.CENTER);
//    this.getContentPane().add(zamknijMnie);
//    this.getContentPane().add(wylaczProgram);


    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //inna metoda zamykania tylko tego okna
    }

//    private void ActionPerformed(ActionEvent e) {
//        this.dispose();
//    };

    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton zamknijMnie = new JButton("Zamknij mnie");
    JButton wylaczProgram = new JButton("Wyłącz program");

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    static int i = 0;

}

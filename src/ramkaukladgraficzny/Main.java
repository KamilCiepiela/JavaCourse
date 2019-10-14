package ramkaukladgraficzny;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        super("Układ graficzny (Layout)");
        setBounds(700, 430, 300, 200);

        initComponents();
//        this.pack(); //bardzo ważne, dzięki temu okno zostanie dopasowane do wielkości buttonów
        setDefaultCloseOperation(3);
    }

    public void initComponents() {

//        centrum = new JButton("Jestem w centrum");
        centrum = new JButton("Anuluj");
        gora = new JButton("Jestem na górze");
        dol = new JButton("Jestem na dole");
        poLewej = new JButton("Jestem po lewej");
        poPrawej = new JButton("Jestem po prawej");

        Container kontener = this.getContentPane();

//gora.setSize(100,400);

//        kontener.add(centrum, BorderLayout.CENTER);
//        kontener.add(gora, BorderLayout.PAGE_START);
//        kontener.add(dol, BorderLayout.PAGE_END);
//        kontener.add(poLewej, BorderLayout.LINE_START);
//        kontener.add(poPrawej, BorderLayout.LINE_END);

//        centrum.setLocation(20, 20);
        centrum.setLocation(200, 130);
//        centrum.setSize(150, 20);
        centrum.setSize(centrum.getPreferredSize());
        kontener.setLayout(null);  //null - usuwa domyślny układ przycisków
        kontener.add(centrum);

    }

    JButton centrum;
    JButton gora;
    JButton dol;
    JButton poLewej;
    JButton poPrawej;

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

}

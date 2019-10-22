package ramkaprzeszukiwacztekstu;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Przeszukiwacz tekstu");
        this.setBounds(300, 300, 300, 200);

//        obszarTekstowy.selectAll(); // zaznacza cały tekst
//        obszarTekstowy.select(0,2);  // zaznacza tekst od - do; jeśli jest to np. 2,2, to karetka stoi na pozycji 2 i nic nie zaznacza
//        obszarTekstowy.replaceSelection("lala");  // podmienia zaznaczony wyżej tekst
//        obszarTekstowy.replaceRange("lala", 0,2);  // suma select i replaceSelection



//        this.getContentPane().add(obszarTekstowy);
        this.getContentPane().add(obszarPrewijania, BorderLayout.NORTH);

        this.setDefaultCloseOperation(3);
    }

    private JTextArea obszarTekstowy = new JTextArea("To jest testowy tekst o testowym charakterze;)", 7, 10);
    private JScrollPane obszarPrewijania = new JScrollPane(obszarTekstowy);

    public static void main(String[] args) {
        new Main().setVisible(true);

    }
}
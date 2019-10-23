package ramkaprzeszukiwacztekstu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public Main() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Przeszukiwacz tekstu");
        this.setBounds(300, 300, 300, 200);

        panelSzukania.add(znajdz);
        panelSzukania.add(szukany);
        panelSzukania.add(etykietaI);
        panelSzukania.add(zamien);
        panelSzukania.add(etykietaNa);
        panelSzukania.add(nowyTekst);

//        obszarTekstowy.selectAll(); // zaznacza cały tekst
//        obszarTekstowy.select(0,2);  // zaznacza tekst od - do; jeśli jest to np. 2,2, to karetka stoi na pozycji 2 i nic nie zaznacza
//        obszarTekstowy.replaceSelection("lala");  // podmienia zaznaczony wyżej tekst
//        obszarTekstowy.replaceRange("lala", 0,2);  // suma select i replaceSelection
//        obszarTekstowy.insert("jakiś string: ", 18);
//        obszarTekstowy.append("dołączone do końca");  // dołaczone do końca stringa bez wycinania
//        obszarTekstowy.select(obszarTekstowy.getText().indexOf("test"), obszarTekstowy.getText().indexOf("test") + "test".length());



//        this.getContentPane().add(obszarTekstowy);

        znajdz.addActionListener(new znajdowanieHandler());
        zamien.addActionListener(new zamienianieHandler());

        this.getContentPane().add(obszarPrewijania, BorderLayout.NORTH);
        this.getContentPane().add(panelSzukania, BorderLayout.CENTER);

        this.setDefaultCloseOperation(3);
    }

    private class znajdowanieHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            początekSzukanego = obszarTekstowy.getText().indexOf(szukany.getText(), początekSzukanego + szukany.getText().length());

            System.out.println(początekSzukanego);

            if (początekSzukanego == -1)
                początekSzukanego = obszarTekstowy.getText().indexOf(szukany.getText());

            if (początekSzukanego >= 0 && szukany.getText().length() > 0)
            {
                obszarTekstowy.requestFocus();
                obszarTekstowy.select(początekSzukanego, początekSzukanego + szukany.getText().length());
            }
        }
        private int początekSzukanego = 0;
    }

    private class zamienianieHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd()) {
                zamienTekst();
            }
            else {
                znajdz.doClick(0);
                if (obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd())
                zamienTekst();
            }
        }
        private void zamienTekst()
        {
            obszarTekstowy.requestFocus();
            int opcja = JOptionPane.showConfirmDialog(rootPane, "Czy chcesz zamienić \"" + szukany.getText() + "\" na \"" + nowyTekst.getText() + "\"?", "Uwaga, nastąpi zmiana!", JOptionPane.YES_NO_OPTION);
            if (opcja == 0)
                obszarTekstowy.replaceRange(nowyTekst.getText(), obszarTekstowy.getSelectionStart(), obszarTekstowy.getSelectionEnd());
        }

    }


    private JTextArea obszarTekstowy = new JTextArea("To jest testowy tekst o testowym charakterze;)", 7, 10);
    private JScrollPane obszarPrewijania = new JScrollPane(obszarTekstowy);

    private JPanel panelSzukania = new JPanel();
    private JButton znajdz = new JButton("Znajdź");
    private JLabel etykietaI = new JLabel("i");
    private JButton zamien = new JButton("Zamień");
    private JLabel etykietaNa = new JLabel("na");

    private JTextField szukany = new JTextField(4);
    private JTextField nowyTekst = new JTextField(4);

    public static void main(String[] args) {
        new Main().setVisible(true);

    }
}
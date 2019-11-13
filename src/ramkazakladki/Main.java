package ramkazakladki;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Zakładki");
        this.setBounds(300,300,300,200);

        zakładki.addTab("Tab 1", new JLabel("To jest pierwszy"));
        zakładki.setMnemonicAt(0, KeyEvent.VK_T); //skrót klawiszony; "0" oznacza pierwszą zakładkę, "1" - drugą itd; stosuje się jako ALT + T

        JPanel panel = new JPanel();
        panel.add(new JButton("tescior"));
        zakładki.addTab("To jest drugi tab", new ImageIcon("zapisz.jpeg"), panel, "Testowy test");

        zakładki.addTab("Videokurs", panelTworzenia);
        panelTworzenia.add(new JLabel("Stwórz nowy plik o nazwie: "));
        JTextField nazwaNowejZakladaki = new JTextField(7);
        panelTworzenia.add(nazwaNowejZakladaki);
        JButton stworzZakladke = new JButton("Stwórz");
        panelTworzenia.add(stworzZakladke);

        stworzZakladke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel paneTekstowy = new JPanel();
                JTextArea obszarTekstowy
                zakładki.addTab(nazwaNowejZakladaki.getText() + ".txt", );
            }
        });


        this.getContentPane().add(zakładki);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JTabbedPane zakładki = new JTabbedPane();
    private JPanel panelTworzenia = new JPanel();

    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
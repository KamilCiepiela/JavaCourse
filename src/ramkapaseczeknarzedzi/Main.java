package ramkapaseczeknarzedzi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Pasek narzędzi");
        this.setBounds(300,300,300,200);

        pasekNarzedzi.add(new KolorowyButton(new ActionColor("Zmieniam kolor na zielony", new ImageIcon("green1.jpg"), Color.GREEN)));
        pasekNarzedzi.add(new KolorowyButton(new ActionColor("Zmieniam kolor na niebieski", new ImageIcon("blue1.jpg"), Color.BLUE)));
        pasekNarzedzi.add(new KolorowyButton(new ActionColor("Zmieniam kolor na czerwony", new ImageIcon("red1.jpg"), Color.RED)));
        pasekNarzedzi.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                aktywny = null;
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                panel.setBackground(Color.BLACK);  // zaznacza tło na czarno, niezależnie od tego, który kolor mam zaznczony i czy w ogóle
                if(aktywny != null)
                    panel.setBackground((Color) aktywny.getAction().getValue("kolor"));
            }
        });
        this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().add(pasekNarzedzi, BorderLayout.NORTH);
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JToolBar pasekNarzedzi = new JToolBar("Nazwa Nowej Ramki");
    private JButton button = new JButton("Wyłącz malowanie");
    private JPanel panel = new JPanel();
    private KolorowyButton aktywny = null;

    private class ActionColor extends AbstractAction
    {
        public ActionColor (String toolTip, Icon icon, Color colour){
            this.putValue(Action.SHORT_DESCRIPTION, toolTip);
            this.putValue(Action.SMALL_ICON, icon);
            this.putValue("kolor", colour);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            aktywny = (KolorowyButton) e.getSource();
        }
    }

    private  class KolorowyButton extends JButton
    {
        public KolorowyButton(ActionColor actionColor) {
            super(actionColor);

            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < pasekNarzedzi.getComponentCount(); i++)
                    {
                        if (pasekNarzedzi.getComponent(i) instanceof KolorowyButton) {
                            KolorowyButton tmp = (KolorowyButton) pasekNarzedzi.getComponent(i);
                            tmp.setBackground((Color.WHITE));
                            tmp.setZaznaczony(false);
//                            rootPane.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR)); // zmiana kursora na krzyżyk po kliknięciu w którykolwiek przycisk, zmiana stała
                            panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("paint1.jpg").getImage(), new Point(0,0), "Nasz kursorek")); // zmiana kursora na krzyżyk po kliknięciu w którykolwiek przycisk, zmiana stała
                            // new Point (0,0) oznacza, że "kliknięcie" odnosi się do lewego górnego rogu obrazka/ikony
                        }
                    }
                    ten.setBackground((Color)actionColor.getValue("kolor"));
                    ten.setZaznaczony(true);
                }
            });

        }

        public void setZaznaczony(boolean zazn)
        {
            this.zaznaczony = zazn;
        }
        KolorowyButton ten = this;
        boolean zaznaczony = false;
    }
    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
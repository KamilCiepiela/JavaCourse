package ramkawlasnemenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

        panelMenu.setLayout(new GridLayout(3,1));

        panelMenu.add(menu1);
        panelMenu.add(menu2);
        panelMenu.add(menu3);

        kontener.add(panelMenu);
        this.setDefaultCloseOperation(3);
    }

    private Container kontener = this.getContentPane();
    private JPanel panelMenu = new JPanel();
    MenuButton menu1 = new MenuButton("1. Dodaj");
    MenuButton menu2 = new MenuButton("2. Usuń");
    MenuButton menu3 = new MenuButton("3. Zmień");

    private class MenuButton extends JButton implements FocusListener
    {
        public MenuButton(String nazwa)
        {
            super(nazwa);
            this.addFocusListener(this);
            this.addKeyListener(new KeyListener() {
                /*gdy kliknę np. literę a to wywpłuwane są w kolejności:
                - keyPressed,
                - keyTyped (tylko dla tych, które zostały wydrukowane, np. strzałki nie są wydrukowane i nie zostawiają "śladu" na ekranie,
                - keyRelease
                */
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
            this.setBackground(kDefault);
        }

        @Override
        public void focusGained(FocusEvent e) {
            this.setBackground(kFocusGained);
        }

        @Override
        public void focusLost(FocusEvent e) {
            this.setBackground(kDefault);
        }
        private Color kFocusGained = Color.RED;
        private Color kDefault = Color.BLUE;
    }


    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}

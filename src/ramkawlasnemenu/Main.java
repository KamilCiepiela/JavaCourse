package ramkawlasnemenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    private int i = 0;

    private class MenuButton extends JButton implements FocusListener, ActionListener
    {
        public MenuButton(String nazwa)
        {
            super(nazwa);
            this.addFocusListener(this);
//            this.addKeyListener(new KeyListener() { // KeyListener to interfejs

                /*gdy kliknę np. literę a to wywoływane są w kolejności:
                - keyPressed
                - keyTyped (tylko dla tych, które zostały wydrukowane, np. strzałki nie są wydrukowane i nie zostawiają "śladu" na ekranie,
                - keyRelease
                */
            this.addActionListener(this);
            this.addKeyListener(new KeyAdapter() {
                //klasa adaptacyjna - zadaptowała wszystkie klasy interfejsu, dzięki czemu nie muszę implementować tych wszystkich klas, tylko wybrane, i mogę je nadpisywać
                @Override
                public void keyPressed(KeyEvent e) {
                    keyPressedHandler(e);
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

        private void keyPressedHandler(KeyEvent e){
            int dlMenu = panelMenu.getComponentCount();

            if (i==0) i = dlMenu; //dzięki temu rozwiązaniu zapętliliśmy i, którę nie osiągnie wartości ujemnych (wyatrczy samo "dlMenu")
            if (e.getKeyCode() == KeyEvent.VK_DOWN){
//                System.out.println(++i); //może być tak lub tak jak poniżej
                panelMenu.getComponent(++i % dlMenu).requestFocus();
            }

            else if (e.getKeyCode() == KeyEvent.VK_UP){
//                System.out.println(--i); //może być tak lub tak jak poniżej
                panelMenu.getComponent(--i % dlMenu).requestFocus();
            }

            else if (e.getKeyCode() == KeyEvent.VK_ENTER){
                MenuButton tmp = (MenuButton)e.getSource();  //źródło jest zwracane jako tryb obiektowy, dlategotrzeba je rzutować na MenuButton
                //to wyrażenie daje dostęp do obiektu, który wywołał obiekt keyPressedHandler
//                tmp.doClick();
                ((MenuButton)e.getSource()).doClick(); //można to zrobić szybciej, WARTO TO ZAPAMIĘTAĆ!!!

            }

        }

        private Color kFocusGained = Color.RED;
        private Color kDefault = Color.BLUE;

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(this, ((MenuButton)e.getSource()).getText());
        }

    }


    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}

package ramkawewnetrzneramki;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Wewnętrzne ramki");
        this.setBounds(300,300,300,200);

        JInternalFrame wewnRamka = new JInternalFrame("Tytuł rameczki", true, true, true, true);
        wewnRamka.add(new JButton("Teścior"), BorderLayout.NORTH);
        wewnRamka.setVisible(true);
        wewnRamka.pack();

        JInternalFrame wewnRamka2 = new JInternalFrame("Tytuł rameczki", true, true, true, true);
        wewnRamka2.add(new JLabel("Inny teścior"), BorderLayout.NORTH);
        wewnRamka2.setVisible(true);
        wewnRamka2.pack();  //wewnRamka będzie dostosowana do wielkości komponentów
//        wewnRamka.setFrameIcon(new ImageIcon("zapisz.jpeg")); // ustawia ikonę ramki

        wewnRamka.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);

        wewnRamka.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
                System.out.println("Otwarte");
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
//                System.out.println("Zamykanie");
                String odp = JOptionPane.showInternalInputDialog(e.getInternalFrame(), "Wpisz 'wyjście, by wyjść z programu lub 'zamknij', by zamknąc tylko ramkę.");

                if (odp != null)
                    if (odp.equals("wyjście"))
                        System.exit(0);
                    else if (odp.equals("zamknij"))
                        e.getInternalFrame().dispose();
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                System.out.println("Zamkniete");
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
                System.out.println("Zmniejszone");
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
                System.out.println("Powiększone");
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                System.out.println("Aktywowane");
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
                System.out.println("Dezaktywowane");
            }
        });

        desktopPane.add(wewnRamka);
        desktopPane.add(wewnRamka2);

        this.getContentPane().add(desktopPane, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JDesktopPane desktopPane = new JDesktopPane();
    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
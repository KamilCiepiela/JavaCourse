package ramkamenukontekstowe;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Menu kontekstowe");
        this.setBounds(300,300,300,200);

        this.getContentPane().addMouseListener(new MouseListener() {  // dodałem tego Listenera do szybki, ale mogę dodać również do buttona, obszaru tekstowego itp.
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("released");

                if (e.getClickCount() == 3 && e.getButton() == MouseEvent.BUTTON1 )
                    JOptionPane.showMessageDialog(rootPane, "Aleś się naklikał:) lewym przyciskiem myszy");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("exited");
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
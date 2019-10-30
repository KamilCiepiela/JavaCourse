package ramkacentrowanie;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame
{
    public Main()
    {
        int szerokosc = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wysokosc = Toolkit.getDefaultToolkit().getScreenSize().height;

        System.out.println(szerokosc);
        System.out.println(wysokosc);

        this.setSize(szerokosc/2, wysokosc/2);

//        this.setLocation(szerokosc/4, wysokosc/4);
        int szerokoscRamki = this.getSize().width;
        int wysokoscRamki = this.getSize().height;
        this.setLocation((szerokosc-szerokoscRamki)/2, (wysokosc-wysokoscRamki)/2); //wyrażenie uniwaersalne, niezależne od wielkości ramki i rozdzielczości


        this.setDefaultCloseOperation(3);
    }

    public static void main(String[] args)
    {

        new Main().setVisible(true);
    }
}

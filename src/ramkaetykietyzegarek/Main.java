package ramkaetykietyzegarek;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main extends JFrame {
    public Main() {
        super("Zegarek");
        this.setBounds(300, 300, 300, 200);

        initComponents();

        this.setDefaultCloseOperation(3);

    }

    public void initComponents() {
//        panel.add(etykieta);
        panel.add(czas);

        ActionListener stoper = new Zegar();

        Timer zegar = new Timer(1000, stoper);

        zegar.start();

        this.getContentPane().add(panel);

        pack();
    }

    JPanel panel = new JPanel();
    JLabel etykieta = new JLabel("Czas: ");
    JLabel czas = new JLabel(pobierzCzas());

    private class Zegar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e)
        {
//            System.out.println(i++);

            czas.setText(pobierzCzas());

        }
    }

//    static int i = 1;  //stworzona poza klasą wewnętrzną, bo w klasach wewnętrznych nie możemy tworzyć zmiennych statycznych

    public String pobierzCzas()
    {
        GregorianCalendar kalendarzyk = new GregorianCalendar();

        String h = ""+kalendarzyk.get(Calendar.HOUR_OF_DAY);
        String min = ""+kalendarzyk.get(Calendar.MINUTE);
        String sek = ""+kalendarzyk.get(Calendar.SECOND);

        if (Integer.parseInt(h) < 10)
            h = "0" + h;
        if (Integer.parseInt(min) < 10)
            min = "0" + min;
        if (Integer.parseInt(sek) < 10)
            sek = "0" + sek;

        return h + " : " + min + " : " + sek;
    }

    public static void main(String[] args) {
        new Main().setVisible(true);

    }


}

package ramkatworzenie;

import javax.swing.*;

public class Main extends JFrame {

    public Main() {
/*        JFrame frame = new JFrame("Tytuł ramki"); //w taki sposób raczej nie robi się ramek
//        frame.setTitle("Tytuł ramki");

        frame.setSize(100,100);
//        frame.setSize(new Dimension(100,100));

        frame.setLocation(100, 100);
//        frame.setLocation(new Point(100, 100));

        frame.setBounds(100,100,100,100);

//        frame.setResizable(false); // brak możliwości zmiany rozmiaru okna

        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("ikona.jpg"));


        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setDefaultCloseOperation(WindowConstans.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(2);
*/

        super("Tytuł ramki");

        this.setBounds(500, 500, 200, 200);
        this.setDefaultCloseOperation(3);
//        this.pack();  //pozwala szybciej się załadować komponenetom i dlatego powinno się dawać to na koniec przy tworzeniu ramki


    }

    public static void main(String[] args) {

        new Main().setVisible(true);

    }
}

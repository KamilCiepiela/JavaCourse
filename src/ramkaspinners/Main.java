package ramkaspinners;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Spinners");
        this.setBounds(300,300,300,200);

        String[] miesiace = new DateFormatSymbols().getMonths();

        //        System.out.println(miesiace.length); // pokazuje liczbę miesięcy
//        for (int i = 0; i < miesiace.length; i++)
//            System.out.println(miesiace[i]);  // wypisuje wszystkie miesiące z listy


//        SpinnerListModel modelMiesiecy = new SpinnerListModel(miesiace); // przed dodaniem klasy MySpinnerLisyModel
//        MySpinnerListModel modelMiesiecy = new MySpinnerListModel(miesiace); // po dodaniu klasy MySpinnerListModel
        MySpinnerListModel modelMiesiecy = new MySpinnerListModel(obetnijArray(miesiace, 0, 11)); // odkąd obciąć miesiące


        JSpinner spinner = new JSpinner(modelMiesiecy);
//        spinner.setEditor(new JTextArea("lala")); // tworzy własny tekst w zadanym obszarze tekstowym

        SpinnerNumberModel modelLiczb = new SpinnerNumberModel(1, 1, 5, 2);  // pozwala na możliwość edytowania
        JSpinner spinner2 = new JSpinner(modelLiczb);

        Calendar kalendarz = Calendar.getInstance();  //stworzyliśmy nowy kalendarz z pewnymi parametrami

//        System.out.println(kalendarz);  //pokazuje warość toString
        Date poczatkowaWartosc = kalendarz.getTime(); //pobraliśmy datę aktualną
        kalendarz.add(Calendar.DAY_OF_MONTH, -20); // minimalna wartość - 20 dni do tyłu
        Date minimalnaWartosc = kalendarz.getTime();
        kalendarz.add(Calendar.DAY_OF_MONTH, 40);  // maksymalna wartość 20 dni do przodu (od 20 dni do tyłu)
        Date maksymalnaWartosc = kalendarz.getTime();

        SpinnerDateModel modelDat = new SpinnerDateModel(poczatkowaWartosc, minimalnaWartosc, maksymalnaWartosc, Calendar.DAY_OF_MONTH);
        //umozliwia zmianę daty w zakresie +/- 20 dni od dnia dzisiejszego

        JSpinner spinner3 = new JSpinner(modelDat);

        JPanel panel = new JPanel();
        panel.add(spinner);
        panel.add(spinner2);
        panel.add(spinner3);

        this.getContentPane().add(panel, BorderLayout.NORTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class MySpinnerListModel extends SpinnerListModel{
        public MySpinnerListModel(Object[] values){ //ten konstruktor robi teraz to samo co pierwotny SpinnerListModel
            super(values); //wysyłamy do klasy wyżej
            firstValue = values[0];
            lastValue = values[values.length - 1]; //
        }

        @Override
        public Object getNextValue()
        {
            if(super.getNextValue() == null)
                return firstValue;
            else
                return super.getNextValue();
        }

        @Override
        public Object getPreviousValue()
        {
            if(super.getPreviousValue() == null)
                return lastValue;
            else
                return super.getPreviousValue();
        }

        Object firstValue, lastValue;
    }

    /**
     * Funkacja obcina tablicę od <code>poczatek</code> do <code>koniec</code>
     * @param operowany tablica, na której będa przeprowadzane operacje
     * @param poczatek indeks, odkąd zacząć obcinanie
     * @param koniec indeks, gdzie zakończyć obcinanie
     * @return Zwraca obciętą tablicę (tmp)
     */
    private Object[] obetnijArray(Object[] operowany, int poczatek, int koniec)
    {
        koniec = koniec > operowany.length - 1 || koniec <= 0 ? operowany.length - 1 : koniec; //zabezpieczenie jeśli "koniec" będzie większy niż liczba miesięcy
        poczatek = poczatek < 0 || poczatek > koniec ? 0 : poczatek;

        Object[] tmp = new Object[koniec + 1 - poczatek]; // dodaje się 1, bo indeks idzie od 0, nie od 1

        for (int i = poczatek, j = 0; i < koniec + 1; i++, j++)
            tmp[j] = operowany[i];

        return operowany;
    }

    public static void main(String[] args)
    {
        new Main().setVisible(true);

    }
}
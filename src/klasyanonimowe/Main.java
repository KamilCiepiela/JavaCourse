package klasyanonimowe;

public class Main {
    public static void main(String[] args) {
//        ZachowaniePoWcisnieciu z = new Przycisk1();
//        z.akcja();

//        ZachowaniePoWcisnieciu z = new ZachowaniePoWcisnieciu() {
//            @Override
//            public void akcja() {
//                System.out.println("Jestem z klasy anonimowej");
//            }
////            void inneMetody() {} //można wywołać poniżej, ale tylko poprzez rzutowanie; tylko WEWNTRZNA akcja
//        };

//        z.akcja();

//        Przycisk p = new Przycisk();
//        p.dodajAkcje(z);

        //lub jeszcze inaczej

        Przycisk p = new Przycisk();
        p.dodajAkcje(new ZachowaniePoWcisnieciu() {
            @Override
            public void akcja() {
                System.out.println("Jestem z klasy anonimowej");
            }
        });
    }
}

interface ZachowaniePoWcisnieciu {
    void akcja();
}

class Przycisk //nie trzeba implementować interfejsu
{
    void dodajAkcje(ZachowaniePoWcisnieciu z)
    {
        z.akcja();
    }
}

//class Przycisk1 implements ZachowaniePoWcisnieciu {
//
//    @Override
//    public void akcja() {
//        System.out.println("Jestem z przycisku 1");
//    }
//}

//class Przycisk2 implements ZachowaniePoWcisnieciu {
//
//    @Override
//    public void akcja() {
//        System.out.println("Jestem z przycisku 2");
//    }
//}

/*
    JButton
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            // do something.
        }
    });

*/
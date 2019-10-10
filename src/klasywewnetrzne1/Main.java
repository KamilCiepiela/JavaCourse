package klasywewnetrzne1;

public class Main {

    public static void main(String[] args) {

        KontoBankowe kontoBankowe = new KontoBankowe(1000);

        System.out.println(kontoBankowe.getStanKonta());

        kontoBankowe.utworzKonto(5);

        System.out.println(kontoBankowe.getStanKonta());

    }
}

class KontoBankowe {

    public KontoBankowe(double stanKonta) {
        this.stanKonta = stanKonta;
    }

    private double stanKonta;

    double getStanKonta() {
        return this.stanKonta;
    }

    void utworzKonto(double stopa) //jeśli w tym miejscu zrobisz ją FINAL, to od tego miejsca jest dostępna również w poniższej klasie lokalnej.
    {
        Odsetki odsetki = new Odsetki(stopa);
//        odsetki.zmienStanKonta(stopa);

        /*
        Klasa Odsetki może być wewnątrz metody i wtedy jest nazywana klasą lokalną
         */

//        class Odsetki {
//            public Odsetki(double stopaProcentowa)
//            {
//                this.stopaProcentowa = stopaProcentowa;
//                this.zmienStanKonta(); //jeśli zmienna STOPA będzie FINAL, można tu usunąć parametr
//            }
//            void zmienStanKonta()  //jeśli zmienna STOPA będzie FINAL, można tu usunąć parametr
//            {
//                double odsetki = (stanKonta * stopa) / 100;
//                stanKonta += odsetki;
//            }

    }


    class Odsetki {
        public Odsetki(double stopaProcentowa)
        {
            this.stopaProcentowa = stopaProcentowa;
            this.zmienStanKonta(stopaProcentowa);
        }
        void zmienStanKonta(double stopa)
        {
            double odsetki = (stanKonta * stopa) / 100;
            stanKonta += odsetki;
        }

        private double stopaProcentowa;

    }
}

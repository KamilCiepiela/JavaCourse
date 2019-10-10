package agregacja;

public class Agregacja {
    public static void main(String[] args) {
        Pracownik p = new Pracownik("Mira", new Adres("Marynarska", 15, "03-100", "Warszawa"));

        System.out.println(p);
    }
}

class Pracownik {
    String imie;
    Adres adres; //w tym przypadku jest to agregacja

    //Praca praca; //w tym przypadku jest to kompozycja

    public Pracownik(String imie, Adres adres) {
        this.imie = imie;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return this.imie + ", adres: " + adres.ulica + " " + adres.nrDomu + ", " + adres.kodPocztowy + " " + adres.miasto;
    }
}

class Adres {
    String ulica;
    int nrDomu;
    String kodPocztowy;
    String miasto;


    public Adres(String ulica, int nrDomu, String kodPocztowy, String miasto) {
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
    }
}

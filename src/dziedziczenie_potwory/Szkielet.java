package dziedziczenie_potwory;

public class Szkielet extends Potwor
{
    @Override
    public void atakuj()
    {
        super.atakuj();
        /*
        Dodatkowe instrukcje ataku.
         */

        System.out.println("To jest metoda ataku z klasy Szkielet");
    }

    @Override
    protected void opis() {

    }

    String typBroni = "Armata";

    public Szkielet(){
        System.out.println("Domyślny konstruktor z klasy Szkielet");
    }

    public Szkielet(double predkoscChodzenia, double zywotnosc) {
        super(predkoscChodzenia, zywotnosc);
        System.out.println("Niedomyślny konstruktor z klasy Szkielet z dwoma argumentami");
    }

    public Szkielet(double predkoscChodzenia, double zywotnosc, String typBroni) {
        super(predkoscChodzenia, zywotnosc);
        this.typBroni = typBroni;
        System.out.println("Niedomyślny konstruktor z klasy Szkielet z trzema argumentami");
    }
}

package dziedziczenie_potwory;

public abstract class Potwor {
    protected double predkoscChodzenia = 10;
    private double zywotnosc = 200;

    public Potwor(){
        System.out.println("Domyślny konstruktor z klasy Potwor");
    }

    public Potwor(double predkoscChodzenia, double zywotnosc){
        this.predkoscChodzenia = predkoscChodzenia;
        this.zywotnosc = zywotnosc;
        System.out.println("Niedomyślny konstruktor z klasy Potwor");
    }

    public double getPredkoscChodzenia(){
        return predkoscChodzenia;
    }

    public double getZywotnosc(){
        return zywotnosc;
    }

    public void atakuj(){
        /*
        Domyślna implementacja ataku.
         */

        System.out.println("To jest metoda ataku z klasy Potwor");
    }

    abstract protected void opis();

    public String toString()
    {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

}

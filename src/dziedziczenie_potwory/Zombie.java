package dziedziczenie_potwory;

public class Zombie extends Potwor
{

    public Zombie(){
        System.out.println("Domyślny konstruktor z klasy Zombie");
    }
    public Zombie(double predkoscChodzenia, double zywotnosc){
        super(predkoscChodzenia,zywotnosc);
        System.out.println("Niedomyślny konstruktor z klasy Zombie");
    }

    @Override
    protected void opis() {

    }


}

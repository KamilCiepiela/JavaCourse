package bottle;

class NotEnoughWater extends Exception  //Dobrze jest stworzyć własną klasę samoopisujących się wyjątków!!!
{
    public NotEnoughWater(String message)
    {
        super(message);
    }
}

public class Bottle1 {

    private double capacity;

    Bottle1(double capacity) {
        this.capacity = capacity;
    }

    double getCapacity() {
        return capacity;
    }

    boolean pourIn(double amount) {
        if (amount >= capacity)
            this.capacity += amount;
        else
            return false;

        return true;
    }

    void pourOut(double amount) throws NotEnoughWater
    {
        if (amount <= capacity)
            this.capacity -= amount;
        else
            throw new NotEnoughWater("Not enough of water");

    }

    void transfer(double amount, Bottle1 whereToTransfer) throws NotEnoughWater {
        if (whereToTransfer.getCapacity() <= amount) {
            whereToTransfer.pourIn(amount);
            System.out.println("The amount of " + amount + "l has been transfered. \n" +
                    "The capacity of " + toString(whereToTransfer) + " that is left is " + (whereToTransfer.capacity - amount) + "l.");
        } else
            System.out.println("Too much to transfer.");

        this.pourOut(amount);
        whereToTransfer.pourIn(amount);

    }

    private String toString(Bottle1 whereToTransfer)
    {
       return getClass().getName(); //DO POPRAWIENIA!!!!!
    }

    public static void main(String[] args) //możesz tutaj dać throws Exception i wtedy nie potrzebujesz bloku try-catch!!!!!!!!!!!!!
    {
//        Bottle1[] bottle = new Bottle1[3]; //NULL
//
//        for (int i = 0; i < bottle.length; i++){
//            double a = 3;
//            double b = i+a;
//            bottle[i] = new Bottle1(b);
////            System.out.println(bottle[i]);
//        }
//
////        bottle[0].pourIn(4);
//
//        bottle[1].transfer(4, bottle[2]);
////        double checkTransfer = bottle[2];
////        System.out.println(checkTransfer);
//
//        for (int i = 0; i < bottle.length; i++) {
//            System.out.println(bottle[i].getCapacity());
//        }

        Bottle1 k = new Bottle1(5);
        Bottle1 k2 = new Bottle1(10);

        try
        {
            k.transfer(20, k2);
        }
        catch (NotEnoughWater ex)
        {
            System.out.println(ex.getMessage());
        }


//PRZYKŁAD TEORETYCZNY:
        int a = 10;
        try {
            System.out.println(5 / 0);

            if (a == 10)
                throw new NaszWyjatek("a jest równe 10, grzeszysz");
        } catch (NaszWyjatek naszWyjatek) {
            System.out.println(naszWyjatek.getMessage());
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }


        try {
            System.out.println("haha");  //instrukcje przed wyjątkiem zostaną wykonane

            System.out.println(5 / 0);

            System.out.println("HAHA");  //instrukcje po wyjątku nie zostaną wykonane
        } catch (ArithmeticException ex)  //jak nie znasz nazwy wyjątku, możesz napisać Exception i też będzie działać, bo wszystkie wyjątki dziedziczą z klasy Exception
        {
            System.out.println("Powstał wyjątek: " + ex.getMessage());
        } finally {
            System.out.println("COŚ CO ZAWSZE ZOSTANIE WYWOŁANE");
        }

        System.out.println("Cokolwiek");

        /*
        try
        {
            //INSTRUKCJE, KTÓRE POTENCJALNIE MOGĄ SPOWODOWAĆ BŁĄD, CHOĆ NIE MUSZĄ
        }
        catch(NazwaZwróconegoWyjątku, nazwaZmiennej)
        {
            //INSTRUKCJE OBSŁUGUJĄCE ZŁAPANY WYJĄTEK
        }
        finally
        {
            //INSTRUKCJE, KTÓRE ZAWSZE ZOSTANĄ WYWOŁANE
        }
         */

    }

}

class NaszWyjatek extends Exception {
    public NaszWyjatek(String string) {
        super(string);
    }

}
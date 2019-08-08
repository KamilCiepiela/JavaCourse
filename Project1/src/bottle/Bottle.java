package bottle;

public class Bottle {
    private double capacity;

    Bottle(double capacity)
    {
        this.capacity = capacity;
    }

    double getCapacity()
    {
        return capacity;
    }
    void pourIn(double amount)
    {
        this.capacity += amount;
    }
    boolean pourOut(double amount)
    {
        if (amount < capacity)
            this.capacity -= amount;
        else
            return false;

        return true;
    }

    void transfer(double amount, Bottle whereToTransfer)
    {
        if (this.pourOut(amount))
        {
            whereToTransfer.pourIn(amount);
        }
        else
            System.out.println("Too little to transfer");
    }

    public static void main(String[] args) {
        Bottle[] bottle = new Bottle[50]; //NULL

        for (int i = 0; i < 50; i++){
            double a = 0.5;

            System.out.println(bottle[i]);
        }
//        butelka[0] = new Butelka(5);
//        butelka[1] = new Butelka(8);
//        butelka[2] = new Butelka(10);

        bottle[0].pourIn(4);

        bottle[0].transfer(25, bottle[1]);

        for (int i = 0; i < 50; i++) {
            System.out.println(bottle[0].getCapacity());
        }

    }

}
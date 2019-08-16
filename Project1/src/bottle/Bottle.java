package bottle;

public class Bottle {
    private double capacity;

    Bottle(){}

    Bottle(double capacity)
    {
        this.capacity = capacity;
    }

    double getCapacity()
    {
        return capacity;
    }

    boolean pourIn(double amount)
    {
        if (amount >= capacity)
            this.capacity += amount;
        else
            return false;

        return true;
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

        if (whereToTransfer.getCapacity() <= capacity){
            whereToTransfer.pourIn(amount);
        }
        else
            System.out.println("Too much to transfer. The " + amount + "l has been transfered.");
    }

    public static void main(String[] args) {
        Bottle[] bottle = new Bottle[3]; //NULL

        for (int i = 0; i < bottle.length; i++){
            double a = 3;
            double b = i+a;
            bottle[i] = new Bottle(b);
//            System.out.println(bottle[i]);
        }
//        bottle[0] = new Bottle(5);
//        bottle[1] = new Bottle(8);
//        bottle[2] = new Bottle(10);

//        bottle[0].pourIn(4);

//        bottle[1].transfer(1, bottle[2]);

        for (int i = 0; i < bottle.length; i++) {
            System.out.println(bottle[i].getCapacity());
        }

    }

}
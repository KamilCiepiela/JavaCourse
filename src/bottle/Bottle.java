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
        if (amount <= capacity)
            this.capacity -= amount;
        else
            return false;

        return true;
    }

    void transfer(double amount, Bottle whereToTransfer)
    {
        if (whereToTransfer.getCapacity() <= amount){
            whereToTransfer.pourIn(amount);
            System.out.println("The amount of " + amount + "l has been transfered. \n" +
                    "The capacity of " + whereToTransfer + " that is left is " + (whereToTransfer.capacity - amount) + "l.");
        }
        else
            System.out.println("Too much to transfer.");

        if (this.pourOut(amount))
        {
            whereToTransfer.pourIn(amount);
        }
        else
            System.out.println("Too little to transfer");
    }

    public static void main(String[] args) {
        Bottle[] bottle = new Bottle[3]; //NULL

        for (int i = 0; i < bottle.length; i++){
            double a = 3;
            double b = i+a;
            bottle[i] = new Bottle(b);
//            System.out.println(bottle[i]);
        }

//        bottle[0].pourIn(4);

        bottle[1].transfer(4, bottle[2]);
//        double checkTransfer = bottle[2];
//        System.out.println(checkTransfer);

        for (int i = 0; i < bottle.length; i++) {
            System.out.println(bottle[i].getCapacity());
        }

    }

}
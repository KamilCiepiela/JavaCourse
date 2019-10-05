package klasaobject;

public class Main
{
    public static void main(String[] args) {

//        Object a = new Punkt(4,50);
//
//        Punkt p = new Punkt(4, 10); //adres, nie wartość
//        Punkt p2 = new Punkt(4, 10); //adres, nie wartość
//
//        System.out.println(p.getClass());
//
//        if (p == p2)
//            System.out.println("Są sobie równe");
//
//        if (p.equals(p2))
//        {
//            System.out.println("Są sobie równe");
//        }
//
//        System.out.println(p);

        Object[] punkty = new Punkt[4];

        punkty[0] = new Punkt(2, 8);
        punkty[1] = new Punkt(5, 21);
        punkty[2] = new Punkt(7, 38);
        punkty[3] = new Punkt(9, 88);

        for(Object punkt: punkty)
        {
            System.out.println(punkt);
        }


    }
}

class Punkt extends Object  // rozszerza kalsę domyślną Object
{
    private int x;
    private int y;

    Punkt()
    {}


        Punkt( int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        int getX ()
        {
            return x;
        }

        int getY ()
        {
            return y;
        }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (this.getClass() != obj.getClass())
            return false;

        Punkt przysłany = (Punkt)obj;
        return this.x == przysłany.x && this.y == przysłany.y;
    }

//    public String toString() {
//        return getClass().getName() + "@" + Integer.toHexString(hashCode());
//    }

    @Override
    public String toString()
    {
        return "X = " + getX() + "; " + "Y = " + getY();
    }

        
}



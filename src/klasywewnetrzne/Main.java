package klasywewnetrzne;

public class Main
{

    public static void main(String[] args)
    {

        A zewnetrzna = new A();

        A.B tmp = zewnetrzna.new B(); //aby stworzyć obiekt klasy WEW, musimy wcześniej stworzyć obiekt klasy ZEW

        A.C tmp2 = new A.C(); //Jeśli klasa WEW jest STATYCZNA, można pominąć konieczność stworzenia obiektu klasy ZEW!!!

    }
}

class A //kasa zewnętrzna NIE MOŻE być STATIC
{
    A()
    {
        System.out.println("jestem z klasy zewnętrznej A");
    }

    class B //klasa zagnieżdzona/wewnętrzna
    {
        B()
        {
            System.out.println("jestem z klasy zagnieżdzonej B");
        }
        void cos()
        {
            test = 5;
            /*
            NIE ma dostępu do metod w klasach WEW przez słowo THIS
            This dałby dostęp do wszystkiego wewnątrz klasy B
            MOGĘ wywoływać metody z klasy zewnętrznej
            WEW klasa niestatyczna nie może tworzyć zmiennych STATYCZNYCH !!!
             */
        }

        private int tmp;
    }

    static class C
            /*
            WEW klasa statyczna może istnieć bez klasy ZEW!!!
            WEW klasa statyczna nie na dostępu do pól klasy ZEW
             */
    {
        static int cosik; //WEW klasa statyczna może tworzyć STATYCZNE zmienne
        C()
        {

            System.out.println("jestem z klasy zagnieżdzonej C");
        }
    }

    void cos2()
    {
//        tmp = 2;
        /*
        klasa ZEWNĘTRZNA nie ma dostępu do metod PRIVATE klasy WEWNĘTRZNEJ, ale klasa WEW ma dostęp do pół klasy ZEW
        (jak krew wewnątrz człowieka)
        NIE mogę wywołać metod z klasy wewntrznej
        */
        B obj = new B(); //MOGĘ w klasie ZEW ztworzyć obiekt klasy WEW
    }

    private int test;

}

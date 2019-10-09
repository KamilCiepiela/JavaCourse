import java.sql.SQLOutput;

public class MultiplicationTable {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++)
        {
            if (i % 2 != 0)
            {
                for (int j = 1; j <= 10; j++)
                {
                    System.out.print(i * j + " ");
                }
                System.out.println();
            }
        }
    }
}

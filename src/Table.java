public class Table {

    public static void main(String[] args) {

        int[] tab = new int[10];
        int i = 0;
        while (i < tab.length){
            tab[i] = 10 * (i + 1);
            System.out.println(tab[i]);
            i++;
        }

        for (int j = 0; j < tab.length; j++){
            tab[j] = 10 * (j + 1);
            System.out.println(tab[j]);
        }

    }

}

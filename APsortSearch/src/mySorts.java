import java.util.Arrays;

public class mySorts {

    public static void selectionSort(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, -10, 2, 5, 4, 6, 1000, 435};

        System.out.println("b4: " + Arrays.toString(a));

        selectionSort(a);

        System.out.println("After: " + Arrays.toString(a));
    }
}

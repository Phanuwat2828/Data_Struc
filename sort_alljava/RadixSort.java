import java.util.ArrayList;
import java.util.List;

public class RadixSort {

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        int exp = 1;
        while (max / exp > 0) {
            countingSort(arr, exp);
            exp *= 10;
        }
    }

    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };

        System.out.println("ก่อนการเรียงลำดับ:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        radixSort(arr);

        System.out.println("หลังการเรียงลำดับ:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

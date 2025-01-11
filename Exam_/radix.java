package Exam_;

import java.util.Scanner;

public class radix {
    public static void show(int[] data, int n) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d", data[i]);
            if (i < data.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

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

            show(arr, arr.length);
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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        radixSort(arr);
        show(arr, n);
        sc.close();
    }
}

package Exam_;

import java.util.Scanner;

public class bubble {
    public static void show(int[] data, int n) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d", data[i]);
            if (i < data.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void bubble_sort(int data[], int size) {
        for (int step = 0; step < size - 1; ++step) {
            int swapped = 0;
            for (int i = 0; i < size - step - 1; ++i) {
                if (data[i] < data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    swapped = 1;
                }
            }
            show(data, size);
            if (swapped == 0) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 7;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();
        bubble_sort(arr, n);
        show(arr, n);

    }
}

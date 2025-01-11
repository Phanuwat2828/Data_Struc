package Exam_;

import java.util.Scanner;

public class select {
    public static void show(int[] data, int n) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d", data[i]);
            if (i < data.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void select(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            show(arr, minIndex);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        select(arr, n);
        show(arr, n);
    }
}
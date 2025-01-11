package Exam_;

import java.util.Scanner;

public class quick {
    public static void show(int[] data, int n) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d", data[i]);
            if (i < data.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void swap_array(int data[], int swap1, int swap2) {
        int temp = data[swap1];
        data[swap1] = data[swap2];
        data[swap2] = temp;
    }

    public static void quick_sort(int data[], int start, int end) {
        int f = start;
        int r = end;
        if (end > start) {
            int pivot = data[end];
            while (r > f) {
                while (data[f] < pivot && f < end && r > f) {
                    f++;
                }
                while (data[r] >= pivot && r > start && r >= f) {
                    r--;
                }
                if (r > f) {
                    swap_array(data, f, r);
                }
            }

            swap_array(data, f, end);
            show(data, end);
            // =========== Recursive function ============
            quick_sort(data, start, f - 1);
            quick_sort(data, f + 1, end);
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
        quick_sort(arr, 0, n - 1);
    }
}

package sort_alljava;

import java.util.Scanner;

public class quicksort {
    public void swap_array(int data[], int swap1, int swap2) {
        int temp = data[swap1];
        data[swap1] = data[swap2];
        data[swap2] = temp;
    }

    public void quick_sort(int data[], int start, int end) {
        int f = start;
        int r = end;
        if (end > start) {
            int pivot = data[start];
            while (r > f) {
                while (data[f] < pivot && f <= end && r > f) {
                    f++;
                }
                while (data[r] >= pivot && r >= start && r >= f) {
                    r--;
                }
                if (r > f) {
                    swap_array(data, f, r);
                }
            }
            swap_array(data, start, r);
            // =========== Recursive function ============
            quick_sort(data, start, r - 1);
            quick_sort(data, r + 1, end);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 34, 10, 39, 49, 24, 42, 9, 0, 999, 1 };
        quicksort ts = new quicksort();
        ts.quick_sort(arr, 0, arr.length - 1);
        for (int value : arr) {
            System.out.println(value);
        }

    }
}

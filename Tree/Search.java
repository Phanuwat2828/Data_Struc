package Tree;

import java.util.Scanner;

class quick {
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
            quick_sort(data, start, f - 1);
            quick_sort(data, f + 1, end);
        }

    }

}

public class Search {
    public void binarySearch(int data[], int target) {
        int lower = 0, upper = data.length - 1, mid;
        boolean found = false;

        while (lower <= upper && found == false) {
            mid = (lower + upper) / 2;
            if (target < data[mid])
                upper = mid - 1;
            else if (target > data[mid])
                lower = mid + 1;
            else
                found = true;
        }

        if (found == true)
            System.out.println(target + " is found");
        else
            System.out.println("Not found");
    }

    public static void main(String[] args) {
        int data[] = { 37, 40, 49, 55, 2, 6, 13, 16, 23, 25, };
        quick q = new quick();
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        q.quick_sort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        Search se = new Search();
        se.binarySearch(data, 200);
    }
}

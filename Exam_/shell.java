package Exam_;

import java.util.Scanner;

public class shell {
    public static void show(int[] data, int n) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d", data[i]);
            if (i < data.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void shell_sort(int data[], int N) {
        int K = N / 2;
        while (K >= 1) {
            int i = K;
            while (i <= N - 1) {
                int temp = data[i];
                int j = i;
                while (j > K - 1 && data[j - K] < temp) {
                    data[j] = data[j - K];
                    j = j - K;
                    data[j] = temp;
                }
                i++;
            }
            show(data, N);
            K = K / 2;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        shell_sort(arr, n);

        sc.close();
    }
}

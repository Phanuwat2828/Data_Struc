
public class shell_Sort {
    public void shell_Sort_(int data[], int N) {
        int K = N / 2;
        while (K >= 1) {
            int i = K;
            while (i <= N - 1) {
                int temp = data[i];
                int j = i;
                while (j > K - 1 && data[j - K] > temp) {
                    data[j] = data[j - K];
                    j = j - K;
                    data[j] = temp;
                }
                i++;
            }
            K = K / 2;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 34, 10, 39, 49, 24, 42, 9, 0, 999, 1 };
        shell_Sort ts = new shell_Sort();
        ts.shell_Sort_(arr, arr.length);
        for (int value : arr) {
            System.out.println(value);
        }
    }
}

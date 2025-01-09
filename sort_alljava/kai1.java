package sort_alljava;

public class kai1 {
    public void insertion(int[] data, int n) {
        for (int i = 1; i < n; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(data[i]);
        }

    }

    public static void main(String[] args) {
        int data[] = { 1, 4, 6, 8, 0, 23 };
        kai1 ob = new kai1();
        ob.insertion(data, 6);
    }
}

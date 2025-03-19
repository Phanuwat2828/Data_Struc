
package Tree;

public class HashTable_1 {
    private Integer[] table;
    private int size;
    private int probeType; // 1 = Linear, 2 = Quadratic, 3 = Double Hashing

    public HashTable_1(int size, int probeType) {
        this.size = size;
        this.probeType = probeType;
        table = new Integer[size];
    }

    private int hash1(int key) {
        return key % size;
    }

    private int hash2(int key) {
        return 7 - (key % 7);
    }

    private int getProbeIndex(int index, int i, int key) {
        if (probeType == 1) { // Linear Probing
            return (index + i) % size;
        } else if (probeType == 2) { // Quadratic Probing
            return (index + i * i) % size;
        } else { // Double Hashing
            return (index + i * hash2(key)) % size;
        }
    }

    public void insert(int key) {
        int index = hash1(key);
        int i = 0;
        while (table[getProbeIndex(index, i, key)] != null) {
            i++;
            if (i == size)
                return; // Table เต็ม
        }
        table[getProbeIndex(index, i, key)] = key;
    }

    public boolean search(int key) {
        int index = hash1(key);
        int i = 0;
        while (table[getProbeIndex(index, i, key)] != null) {
            if (table[getProbeIndex(index, i, key)] == key)
                return true;
            i++;
            if (i == size)
                return false;
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < size; i++)
            System.out.println("Index " + i + ": " + table[i]);
    }

    public static void main(String[] args) {
        System.out.println("Linear Probing:");
        HashTable_1 ht1 = new HashTable_1(7, 1);
        ht1.insert(10);
        ht1.insert(20);
        ht1.insert(30);
        ht1.display();
        System.out.println(ht1.search(10));
        System.out.println("Quadratic Probing:");
        HashTable_1 ht2 = new HashTable_1(7, 2);
        ht2.insert(10);
        ht2.insert(20);
        ht2.insert(30);
        ht2.display();
        System.out.println(ht2.search(10));
        System.out.println("Double Hashing:");
        HashTable_1 ht3 = new HashTable_1(7, 3);
        ht3.insert(10);
        ht3.insert(20);
        ht3.insert(30);
        ht3.display();
        System.out.println(ht3.search(10));
    }
}

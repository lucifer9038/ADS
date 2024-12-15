import java.util.Arrays;

class HashTable {
    private static final int SIZE = 10;
    private int[] hashTable;

    public HashTable() {
        hashTable = new int[SIZE];
        Arrays.fill(hashTable, -1); // Initialize all slots to -1
    }

    public void insert(int key, int digitPosition) {
        int numDigits = (int) (Math.log10(key) + 1);
        if (digitPosition > numDigits || digitPosition <= 0) {
            System.out.println("Invalid digit position!");
            return;
        }
        int index = (key / (int) Math.pow(10, numDigits - digitPosition)) % 10;
        while (hashTable[index] != -1) {
            System.out.println("\nCollision found at address " + index + " for " + key);
            System.out.println("Searching next empty slot using linear probing\n");
            index = (index + 1) % SIZE;
        }
        System.out.println("\n\nNo collision at address " + index + " for " + key);
        hashTable[index] = key;
    }

    public void display() {
        System.out.println("\n");
        for (int i = 0; i < SIZE; i++) {
            if (hashTable[i] != -1)
                System.out.println("Index" + i + ":" + hashTable[i]);
            else
                System.out.println("index" + i + ": NULL");
        }
    }
}

public class HashingDigitPosition {
    public static void main(String[] args) {
        int[] keys = {12345, 67890, 12579, 98765, 43210, 56789, 10234};
        int digitPosition = 3;
        int key;
        int n = keys.length;

        for (int i = 0; i < n; i++) {
            System.out.print(" " + keys[i]);
        }

        HashTable ht = new HashTable();
        for (int i = 0; i < n; i++) {
            key = keys[i];
            ht.insert(key, digitPosition);
        }
        ht.display();
    }
}

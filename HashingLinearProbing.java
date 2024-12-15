import java.util.Arrays;

class HashTable {
    private static final int SIZE = 10;
    private int[] hashTable;

    public HashTable() {
        hashTable = new int[SIZE];
        Arrays.fill(hashTable, -1); // Initialize all slots to -1
    }

    // Hash function to calculate index
    private int hashFunction(int key) {
        return key % SIZE;
    }

    // Method for inserting using Linear Probing
    public void insertLinearProbing(int key) {
        int index = hashFunction(key);
        while (hashTable[index] != -1) {
            System.out.println("\nCollision found at address " + index + " for " + key);
            System.out.println("Searching next empty slot using linear probing");
            index = (index + 1) % SIZE;
        }
        System.out.println("\nNo collision at address " + index + " for " + key);
        hashTable[index] = key;
    }

    // Display method
    public void displayProbing() {
        System.out.println("");
        for (int i = 0; i < SIZE; i++) {
            if (hashTable[i] != -1)
                System.out.println("Index" + i + ":" + hashTable[i]);
            else
                System.out.println("index" + i + ": NULL");
        }
    }
}

public class HashingLinearProbing {
    public static void main(String[] args) {
        int[] keys = {25, 36, 48, 37, 63, 75, 84, 92};
        int n = keys.length;
        int key;
        HashTable ht = new HashTable();
        System.out.println("Hashing using Linear Probing:");
        for (int i = 0; i < n; i++) {
            key = keys[i];
            ht.insertLinearProbing(key);
        }
        ht.displayProbing();
    }
}

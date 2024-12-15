package ads;

import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] list) {
        int n = list.length;
        for (int key = 1; key < n; key++) {
            int walker = key - 1;
            int hold = list[key];
            while (walker >= 0 && hold < list[walker]) {
                list[walker + 1] = list[walker];
                walker--;
            }
            list[walker + 1] = hold;
            System.out.print("\nPass : " + key + "  ");
            for (int i = 0; i < n; i++) {
                System.out.print(list[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of array: ");
        int n = scanner.nextInt();
        
        int[] num = new int[n];
        
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        
        System.out.print("\nUnsorted Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(num[i] + " ");
        }
        
        System.out.println("\n");
        insertionSort(num);
        
        System.out.print("\nSorted Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(num[i] + " ");
        }
        
        scanner.close();
    }
}
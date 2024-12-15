package ads;

import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int[] list) {
        int n = list.length;
        for (int hold = 0; hold < n - 1; hold++) {
            int pos = hold;
            boolean flag = false;
            
            // Finding smallest element index
            for (int walker = hold + 1; walker < n; walker++) {
                if (list[walker] < list[pos]) {
                    pos = walker; // min element index
                }
            }
            
            // Swapping the smallest element with hold
            if (hold != pos) {
                int t = list[pos];
                list[pos] = list[hold];
                list[hold] = t;
                flag = true;
            }
            
            if (!flag)
                break;
            
            System.out.print("\nPass : " + (hold + 1) + "  ");
            for (int i = 0; i < n; i++)
                System.out.print(list[i] + " ");
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
        for (int i = 0; i < n; i++)
            System.out.print(num[i] + " ");

        selectionSort(num);

        System.out.print("\n\nSorted Array: ");
        for (int i = 0; i < n; i++)
            System.out.print(num[i] + " ");

        scanner.close();
    }
}
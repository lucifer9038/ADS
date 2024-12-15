package ads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        int pass = 1;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            System.out.print("\nGap=" + gap + "\nPass" + pass + " : ");
            for (int i = 0; i < n; i++) {
                System.out.print(" " + arr[i]);
            }
            pass++;
        }
    }

    public static void main(String[] args) {
        int size = 5;
        int[] myArray = new int[size];

        try {
            File file = new File("D:\\MCA\\java\\ads\\src\\ads\\num.txt");
            Scanner scanner = new Scanner(file);
            
            for (int i = 0; i < size; i++) {
                if (scanner.hasNextInt()) {
                    myArray[i] = scanner.nextInt();
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open file for reading");
            e.printStackTrace();
            return;
        }

        System.out.print("\n\nUnsorted Array: ");
        for (int i = 0; i < size; i++)
            System.out.print(myArray[i] + " ");

        shellSort(myArray);

        System.out.print("\n\nSorted Array: ");
        for (int i = 0; i < size; i++)
            System.out.print(myArray[i] + " ");
    }
}

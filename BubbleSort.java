package ads;

import java.util.Scanner;

public class BubbleSort {
	 public static void bubbleSort(long[] list) {
	        int size = list.length;
	        for (int hold = 0; hold < size - 1; hold++) {
	            boolean flag = false; // no swap
	            for (int walker = 0; walker < size - hold - 1; walker++) {
	                if (list[walker] > list[walker + 1]) {
	                    long t = list[walker];
	                    list[walker] = list[walker + 1];
	                    list[walker + 1] = t;
	                    flag = true; // done swapping
	                }
	            }
	            if (!flag)
	                break;
	            System.out.print("\n\nPass:" + (hold + 1) + " : ");
	            for (int i = 0; i < size; i++) {
	                System.out.print(list[i] + " ");
	            }
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the size of array: ");
	        int size = scanner.nextInt();

	        long[] num = new long[size];

	        System.out.print("Enter the elements: ");
	        for (int i = 0; i < size; i++) {
	            num[i] = scanner.nextLong();
	        }

	        System.out.print("\n\nUnsorted Array: ");
	        for (int i = 0; i < size; i++)
	            System.out.print(num[i] + " ");

	        bubbleSort(num);

	        System.out.print("\n\nSorted Array: ");
	        for (int i = 0; i < size; i++)
	            System.out.print(num[i] + " ");

	        scanner.close();
	    }
	}

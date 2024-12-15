package ads;

import java.util.Scanner;

public class LinerarSearch {
		public static int linearSearch(int[] num, int key)		
		{
			for (int i = 0; i < num.length; i++)
			{
				if (num[i]==key) 
				{
					return i;
				}
				
			}
			return -1;
			
		}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size=scanner.nextInt();
        int[] num = new int[size];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < size; i++) {
            num[i] = scanner.nextInt();
        }

        System.out.print("Enter an element to search: ");
        int key = scanner.nextInt();

        int result = linearSearch(num, key);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in array");
        }

        scanner.close();
    }


	}



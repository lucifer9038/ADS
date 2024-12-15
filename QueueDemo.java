import java.util.Scanner;

class MyQueue
{
	int queueSize;int arr[];
	int q_front,q_rear;
	public MyQueue(int size)
	{
		queueSize=size;
		arr=new int[queueSize];
		q_front=0;
		q_rear=-1;
	}
	void enqueue(int val)
	{
		q_rear=q_rear+1;
		arr[q_rear]=val;
	}
	public int dequeue() 
	{
		int q_element=arr[q_front];
		q_front=q_front+1;
		return q_element;
	}
	public boolean isEmpty()
	{
		if (q_rear==-1 ||q_front>q_rear) 
			return true;
		else 
			return false;	
		
	}
	public boolean isFull() 
	{
		if (q_rear==queueSize-1)
			return true;
		else 
			return false;
	}
	public int size() 
	{
		return q_rear+1;
	}
	public void displayAllElement() 
	{
		if (isEmpty()) 
		{
			System.out.println("\nQueue is Empty!! No element Display");
		}else 
		{
			System.out.println("Element in the queue are:  ");
			for(int i=q_front;i<=q_rear;i++)
			{
				System.out.print(arr[i]+" ");
			}
			System.out.println(" ");
		}
	}
	
}

public class QueueDemo {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        MyQueue queue = new MyQueue(5);
	        int val;
	        int choice;

	        do {
	            System.out.println("\n1. Enqueue");
	            System.out.println("2. Dequeue");
	            System.out.println("3. Check if Queue is Empty");
	            System.out.println("4. Check if Queue is Full");
	            System.out.println("5. Display All Elements");
	            System.out.println("6. Exit");
	            System.out.print("Enter Your Choice: ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("\nEnter Value to be Enqueued: ");
	                    val = sc.nextInt();
	                    queue.enqueue(val);
	                    break;
	                case 2:
	                    val = queue.dequeue();
	                    System.out.println("\nDequeued element is: " + val);
	                    break;
	                case 3:
	                    System.out.println("Queue is " + (queue.isEmpty()?"Empty":"Not Empty"));
	                    break;
	                case 4:
	                    System.out.println("Queue is " + (queue.isFull() ? "Full" : "Not Full"));
	                    break;
	                case 5:
	                    queue.displayAllElement();
	                    break;
	                case 6:
	                    System.out.println("Exiting the program.");
	                    break;
	                default:
	                    System.out.println("\nWrong Choice\n");
	            }
	        } while (choice != 6);

	        sc.close();
	    }
	}
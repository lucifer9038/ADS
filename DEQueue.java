package DQueue;

import java.util.Scanner;

class Node {
    int data;
    Node next,prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev=null;
    }
}

public class DEQueue
{
	Node front;
	Node rear;
	int Size;
	public DEQueue()
	{
		front=rear=null;
		Size=0;
	}
	public boolean isEmpty() {
		return (front==null);
	}
	public int size() {return Size;}
	
	public void insertFront(int data)
	{
		Node newNode=new Node(data);
		if (newNode==null)
			System.out.print("Overflow!\n");
		else {
			if (front==null) {
				rear=front=newNode;
			}
			else {
				newNode.next=front;
				front.prev=newNode;
				front=newNode;
			}
			Size++;
		}
	}
	public void insertRear(int data)
	{
		Node newNode=new Node(data);
		if (newNode==null) 
		{
			System.out.print("OverFlow!\n");
		}
		else {
			if (rear==null)
			{
				front=rear=newNode;
			}
			else {
				newNode.prev=rear;
				rear.next=newNode;
				rear=newNode;
			}
			Size++;
		}
	}
	public void deleteFront()
	{
		if (isEmpty()) {
			System.out.println("UnderFlow - Deque is Empty!\n");
		}
		else {
			Node tempNode = front;
			front=front.next;
			if (front==null)
			{
				rear=null;
			}
			else {
				front.prev=null;
			}
			Size--;
		}
	}
	void deleteRear()
	{
		if (isEmpty())
		{
			System.out.print("quot;UnderFlow - Deque is empty!\n");
		}
		else {
			Node tempNode=rear;
			rear=rear.prev;
			
			if (rear==null)
			{
				front=null;
			}
			else {
				rear.next=null;
			}
			Size--;
		}
	}
	public int getFront()
	{
		if (isEmpty())
		{
			return -1;
			
		}
		return front.data;
	}
	public int getRear() {
		if (isEmpty()) 
		{
			return -1;
		}
		return rear.data;
	}
	public void display()
	{
		Node currentNode=front;
		if (front==null) 
		{
			System.out.println("The double ended queue is empty!");
			return;
		}
		System.out.println("The data are Double Ended Queue are: ");
		System.out.println("NULL<--");
		while (currentNode!=null)
		{
			System.out.println(currentNode.data+"<->");
			currentNode=currentNode.next;
		}
		System.out.println("Null-->");
		System.out.println();
	}
	public void deleteAllNodes() 
	{
		rear=null;
		while (front!=null)
		{
			Node tempNode=front;
			front=front.next;
		}
		Size=0;
	}
	public static void main(String[] args) {
		DEQueue dq = new DEQueue();
		Scanner sc = new Scanner(System.in);

		int data;
		int choice;
		do
		{
		System.out.print("\n1.Insert At Front\n");
		System.out.print("2.Insert At Rear\n");
		System.out.print("3.Delete At Front\n");
		System.out.print("4.Delete At Rear\n");
		System.out.print("5.Delete all nodes\n");
		System.out.print("6.Display List\n");
		System.out.print("7.Exit\n");
		System.out.print("Enter your choice :" );
		choice = sc.nextInt();
		switch (choice)
		{
		case 1: System.out.print("\nInsert at Front - Enter data :");
		data= sc.nextInt();
		dq.insertFront(data);
		dq.display();
		break;
		case 2: System.out.print("\nInsert at Rear - Enter data: ");
		data= sc.nextInt();
		dq.insertRear(data);
		dq.display();

		break;
		case 3: System.out.print("\nDelete at Front: ");
		dq.deleteFront();
		dq.display();
		break;
		case 4: System.out.print("\nDelete at Rear: ");
		dq.deleteRear();
		dq.display();
		break;
		case 5: System.out.print("\nDelete all nodes : ");
		dq.deleteAllNodes();
		dq.display();
		break;
		case 6: System.out.print("\nDisplay List : ");
		dq.display();
		break;
		case 7: System.out.println("Exiting the program.");
		break;
		default:
		System.out.print("\nWrong choice! \n");
		} /*End of switch*/
		}while(choice!=7); /*End of while*/
		sc.close();
		}

		}

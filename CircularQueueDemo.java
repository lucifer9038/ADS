import java.util.Scanner;

class MyCircularQueue {
    int queueSize;
    int arr[];
    int q_front, q_rear;

    public MyCircularQueue(int size) {
        queueSize = size;
        arr = new int[queueSize];
        q_front = -1;
        q_rear = -1;
    }

    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("\nQueue is Full!! Cannot Enqueue.");
            return;
        }

        if (isEmpty()) {
            q_rear = 0;
            q_front = 0;
        } else {
            q_rear = (q_rear + 1) % queueSize;
        }
        arr[q_rear] = val;
        System.out.println(val + " enqueued.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("\nQueue is Empty!! Cannot Dequeue.");
            return -1;
        }

        int q_element = arr[q_front];

        if (q_front == q_rear) {
            q_front = -1;
            q_rear = -1;
        } else {
            q_front = (q_front + 1) % queueSize;
        }

        return q_element;
    }

    public boolean isEmpty() {
        return q_rear == -1;
    }

    public boolean isFull() {
        return (q_rear + 1) % queueSize == q_front;
    }

    public int size() {
        if (q_front == -1) return 0;
        if (q_rear >= q_front) return q_rear - q_front + 1;
        else return queueSize - (q_front - q_rear - 1);
    }

    public void displayAllElements() {
        if (isEmpty()) {
            System.out.println("\nNo elements to display.");
            return;
        }

        System.out.print("Elements in the queue are: ");
        for (int i = q_front; i != q_rear; i = (i + 1) % queueSize) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[q_rear]);
    }
}

public class CircularQueueDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyCircularQueue queue = new MyCircularQueue(5); // Queue of size 5
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
                    if (val != -1)
                        System.out.println("\nDequeued element is: " + val);
                    break;
                case 3:
                    System.out.println("Queue is " + (queue.isEmpty() ? "Empty" : "Not Empty"));
                    break;
                case 4:
                    System.out.println("Queue is " + (queue.isFull() ? "Full" : "Not Full"));
                    break;
                case 5:
                    queue.displayAllElements();
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

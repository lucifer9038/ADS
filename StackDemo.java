import java.util.Scanner;

class MyStack {
    int maxSize;
    int top;
    int[] stackArray;

    public MyStack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    // PUSH
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is Full! Cannot push element!");
        } else {
            stackArray[++top] = value;
        }
    }

    // POP
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty! Cannot pop element!!");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    // PEEK
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty! Cannot peek element.");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    void displayAll() {
        if (isEmpty()) {
            System.out.println("\nStack is Empty! No elements to display!!");
        } else {
            System.out.println("Elements in the stack are: ");
            for (int i = top; i >= 0; i--) // Changed to i >= 0
                System.out.println(stackArray[i]);
            System.out.println("");
        }
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack stack = new MyStack(5);
        int val;
        int choice;

        do {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter Value to be Pushed: ");
                    val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    val = stack.pop();
                    System.out.println("\nPopped element is: " + val);
                    break;
                case 3:
                    System.out.println("Top element is: " + stack.peek());
                    break;
                case 4:
                    stack.displayAll();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("\nWrong Choice\n");
            }
        } while (choice != 5);

        sc.close();
    }
}

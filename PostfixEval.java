import java.util.Scanner;
import java.lang.Math;

class MyStack2 {
    private int maxSize;
    private int top;
    private int[] stackArray;

    // Constructor to initialize the stack
    public MyStack2(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    // Push operation
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full! Cannot push element!");
        } else {
            stackArray[++top] = value;
        }
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop element!");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // Check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    public void displayAll() {
        if (top == -1) {
            System.out.println("\nStack is empty! No elements to display!\n");
        } else {
            System.out.println("Elements in the stack are: ");
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i] + " ");
            }
            System.out.println("");
        }
    }
}

public class PostfixEval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack2 st = new MyStack2(5);
        System.out.println("Please enter postfix expression: ");
        String exp = sc.nextLine();

        // Scan all characters one by one
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the scanned character is an operand (number here), push it to the stack
            if (Character.isDigit(c)) {
                st.push(c - '0'); // Convert char to integer
            }
            // If the scanned character is an operator, pop two elements from the stack and apply the operator
            else {
                int val1 = st.pop();
                int val2 = st.pop();
                System.out.println(val2 + " " + c + " " + val1);

                switch (c) {
                    case '+':
                        st.push(val2 + val1);
                        break;
                    case '-':
                        st.push(val2 - val1);
                        break;
                    case '/':
                        st.push(val2 / val1);
                        break;
                    case '*':
                        st.push(val2 * val1);
                        break;
                    case '^':
                        int power = (int) Math.pow(val2, val1);
                        st.push(power);
                        break;
                    default:
                        System.out.println("Invalid operator found!");
                }
            }
        }

        System.out.println("Answer = " + st.pop());
        sc.close();
    }
}

package stack;

class Node {
    int data;
    Node next;

    public Node(int d) {
        data = d;
        this.next = null;
    }
}

class Stack {
    Node head;

    public Stack() {
        this.head = null;
    }

    Boolean isEmpty() {
        return head == null;
    }

    void push(int d) {
        Node newNode = new Node(d);
        if (newNode == null) {
            System.out.println("\nStack Overflow!");
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("\nStack underflow");
            return;
        } else {
            Node temp = head;
            head = head.next;  // Move the head to the next node
            temp = null;  // Free the old head
        }
    }

    int peek() {
        if (!isEmpty()) {
            return head.data;
        } else {
            System.out.println("\nStack is Empty!!");
            return Integer.MIN_VALUE;
        }
    }

    public void displayStack() {
        Node currentNode = head;
        if (head == null) {
            System.out.println("\nStack is empty");
            return;
        }
        System.out.println("\nThe data in Stack: ");
        while (currentNode != null) {
            System.out.print(currentNode.data + "--->");
            currentNode = currentNode.next;
        }
        System.out.print("null");
        System.out.println();
    }
}

public class StackSLL {

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.displayStack();
        System.out.println("Top element is " + st.peek());
        st.pop();
        st.displayStack();
        System.out.println("Top element is " + st.peek());
    }
}

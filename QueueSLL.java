package queue;

class Node {
    int data;
    Node next;

    public Node(int d) {
        data = d;
        this.next = null;
    }
}

class Queue {
    Node frontNode, rearNode;

    public Queue() {
        frontNode = rearNode = null;
    }

    Boolean isEmpty() {
        return frontNode == null && rearNode == null;
    }

    void enqueue(int d) {
        Node newNode = new Node(d);
        if (rearNode == null) {
            frontNode = rearNode = newNode;
            return;
        }
        rearNode.next = newNode;
        rearNode = newNode;
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("\nQueue underflow");
            return;
        }
        frontNode = frontNode.next;
        if (frontNode == null)
            rearNode = null;
    }

    int getFrontNode() {
        if (!isEmpty()) {
            return frontNode.data;
        } else {
            System.out.println("\nQueue is empty!");
            return Integer.MIN_VALUE;
        }
    }

    int getRearNode() {
        if (!isEmpty()) {
            return rearNode.data;
        } else {
            System.out.println("\nQueue is empty!");
            return Integer.MIN_VALUE;
        }
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("\nQueue is empty!");
            return;
        }

        Node currentNode = frontNode;
        System.out.println("\nThe data in Queue: ");
        while (currentNode != null) {
            System.out.print(currentNode.data + " ---> ");
            currentNode = currentNode.next;
        }
        System.out.print("null\n");
    }
}

public class QueueSLL {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.displayQueue();
        System.out.println("Front element is: " + queue.getFrontNode());
        System.out.println("Rear element is: " + queue.getRearNode());

        queue.dequeue();
        System.out.println("\nAfter dequeue:");
        queue.displayQueue();
        System.out.println("Front element is: " + queue.getFrontNode());
        System.out.println("Rear element is: " + queue.getRearNode());
    }
}

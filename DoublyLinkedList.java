public class DoublyLinkedList {
    class Node {
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head, tail = null;

    // Add node to the end of the list
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    // Display the list from the head to the tail
    public void display() {
        Node currentNode = head;
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        System.out.println("Nodes of doubly linked list: ");
        while (currentNode != null) {
            System.out.print(currentNode.data + " ---> ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // Reverse the doubly linked list
    public void reverseList() {
        Node currentNode = head;
        Node temp = null;

        // Traverse the list and swap the next and previous pointers
        while (currentNode != null) {
            // Swap previous and next pointers for the current node
            temp = currentNode.previous;
            currentNode.previous = currentNode.next;
            currentNode.next = temp;
            
            // Move to the next node (which is actually the previous node after swapping)
            currentNode = currentNode.previous;
        }

        // After reversing, reset the head and tail pointers
        if (temp != null) {
            head = temp.previous; // Update head to the new first node
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.addNode(1);
        dList.addNode(2);
        dList.addNode(3);
        dList.addNode(4);
        dList.addNode(5);

        // Display the original list
        dList.display();

        // Reverse the list
        dList.reverseList();

        // Display the reversed list
        System.out.println("Reversed list: ");
        dList.display();
    }
}

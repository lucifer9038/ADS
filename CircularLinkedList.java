package cll;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    Node head;
    Node tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
        	newNode.next=newNode;
            head = tail = newNode;
        } else {
        	newNode.next=head;
            tail.next = newNode;
            tail=newNode;
        }
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
        	newNode.next=newNode;
            head = tail = newNode;
   
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; 
        }
    }

    public void insertAtTail(int data) {
        insert(data);
    }

    public void insertAtPosition(int pos, int data) 
    {
        Node newNode = new Node(data);
        int totalNodes = countNodes();

        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
        } else if (pos == 1) {
            insertAtHead(data);
        } else if (pos > 1 && pos <= totalNodes + 1) {
            Node current = head, prev = null;
            for (int i = 1; i < pos; i++) {
                prev = current;
                current = current.next;
            }
            newNode.next = current;
            if (prev != null) {
                prev.next = newNode;
            }
            if (pos == totalNodes + 1) { 
                tail = newNode;
            }
            tail.next = head; 
        } else {
            System.out.println("Invalid Node Position!!!");
        }
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            System.out.println("Circular Linked List is empty!!!");
        } else if (head == tail) { 
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head; 
        }
    }

    public void deleteAtTail() {
        if (isEmpty()) {
            System.out.println("Circular Linked List is empty!!!");
        } else if (head == tail) { 
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = head;
            tail = current;
        }
    }

    public void deleteAtPosition(int pos) {
        int totalNodes = countNodes();
        if (isEmpty()) {
            System.out.println("Circular Linked List is empty!");
        } else if (pos == 1) {
            deleteAtHead();
        } else if (pos > 1 && pos <= totalNodes) {
            Node current = head, prev = null;
            for (int i = 1; i < pos; i++) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
            if (current == tail) { 
                tail = prev;
                tail.next = head; 
            }
        } else {
            System.out.println("Invalid Node Position!!!");
        }
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("The Circular Linked List is Empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " --> ");
            current = current.next;
        } while (current != head);
        System.out.println("(Back to Head)");
    }

    public int countNodes() {
        if (isEmpty()) {
            return 0;
        }
        int count = 0;
        Node current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    
    public void search(int key) {
        if (isEmpty()) {
            System.out.println("Circular Linked List is empty!");
            return;
        }
        Node current = head;
        int pos = 1; boolean found=false;
        do {
            if (current.data == key) {
                System.out.println(key + " found at position " + pos);
                found=true;
            }
            current = current.next;
            pos++;
        } while (current != head);
        if (!found) {
            System.out.println(key + " not found!!");
        }
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice, data, pos;

        do {
            System.out.println("\n---- Circular Linked List Operations ----");
            System.out.println("1. Insert");
            System.out.println("2. Insert At Head");
            System.out.println("3. Insert At Tail");
            System.out.println("4. Insert At Position");
            System.out.println("5. Delete At Head");
            System.out.println("6. Delete At Tail");
            System.out.println("7. Delete At Position");
            System.out.println("8. Search for Key");
            System.out.println("9. Total Nodes");
            System.out.println("10. Display List");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a data: ");
                    data = scanner.nextInt();
                    cll.insert(data);
                    cll.displayList();
                    break;
                case 2:
                    System.out.print("Enter a data: ");
                    data = scanner.nextInt();
                    cll.insertAtHead(data);
                    cll.displayList();
                    break;
                case 3:
                    System.out.print("Enter a data: ");
                    data = scanner.nextInt();
                    cll.insertAtTail(data);
                    cll.displayList();
                    break;
                case 4:
                    System.out.print("Enter the position: ");
                    pos = scanner.nextInt();
                    System.out.print("Enter a data: ");
                    data = scanner.nextInt();
                    cll.insertAtPosition(pos, data);
                    cll.displayList();
                    break;
                case 5:
                    cll.deleteAtHead();
                    cll.displayList();
                    break;
                case 6:
                    cll.deleteAtTail();
                    cll.displayList();
                    break;
                case 7:
                    System.out.print("Enter the position to delete: ");
                    pos = scanner.nextInt();
                    cll.deleteAtPosition(pos);
                    cll.displayList();
                    break;
                case 8:
                    System.out.print("Enter the key to search: ");
                    data = scanner.nextInt();
                    cll.search(data);
                    break;
                case 9:
                    System.out.println("Total Nodes: " + cll.countNodes());
                    break;
                case 10:
                    cll.displayList();
                    break;
                case 11:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 11);
        scanner.close();
    }
}
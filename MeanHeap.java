package mean;

class Node {
    int data;
    Node next, prev;

    public Node(int val) {
        this.data = val;
        this.next = null;
        this.prev = null;
    }
}

public class MeanHeap {
    Node head, tail;

    public MeanHeap() {
        this.head = null;
        this.tail = null;
    }

    private void reheapUp(Node node) {
        Node parent = getParent(node);
        while (parent != null && node.data < parent.data) {
            int temp = node.data;
            node.data = parent.data;
            parent.data = temp;
            node = parent;
            parent = getParent(node);
        }
    }

    private void reheapDown(Node node) {
        while (node != null) {
            Node leftChildNode = node.next;
            Node rightChildNode = (leftChildNode != null) ? leftChildNode.next : null;

            if (leftChildNode == null) {
                break;
            }
            Node minNode = leftChildNode;
            if (rightChildNode != null && rightChildNode.data < leftChildNode.data) {
                minNode = rightChildNode;
            }
            if (node.data <= minNode.data) {
                break;
            }
            int temp = node.data;
            node.data = minNode.data;
            minNode.data = temp;
            node = minNode;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

            reheapUp(newNode);
        }
    }

    public void delete() {
        if (head == null) {
            System.out.println("Heap is empty!!");
            return;
        }
        Node lastNode = tail;
        head.data = lastNode.data;

        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = null;
        }
        reheapDown(head);
    }

    private Node getParent(Node node) {
        return node.prev;
    }

    public void printHeap() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + "  ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MeanHeap minHeap = new MeanHeap();
        System.out.println("\nInserting values into MinHeap");
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(8);
        minHeap.printHeap();

        System.out.println("\nDeleting root node from MinHeap");
        minHeap.delete();
        minHeap.printHeap();
    }
}

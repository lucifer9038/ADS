package pqueue;

import java.security.PublicKey;

class Node{
	int data,priority;
	Node nextNode;
	public Node(int d, int p) {
		data = d;
		priority = p;
		nextNode=null;
	}
}

public class PriorityQueue {
	Node headNode;
	public PriorityQueue() {
		headNode=null;
	}
	public void add(int d,int p) {
		Node startNode=headNode;
		Node newNode=new Node(d, p);
		if (headNode==null) {
			headNode=newNode;
			return;
		}
		if (headNode.priority>p) 
		{
			newNode.nextNode=headNode;
			headNode=newNode;
		}
		else {
			while (startNode.nextNode!=null && startNode.nextNode.priority<p) 
			{
				startNode=startNode.nextNode;
			}
			newNode.nextNode=startNode.nextNode;
			startNode.nextNode=newNode;
		}
	}
	public Node removeNode()
	{
		Node tempNode=headNode;
		headNode=headNode.nextNode;
		tempNode=null;
		return headNode;
	}
	int getHeadData()
	{
		return headNode.data;
	}
	boolean isEmpty()
	{
		return headNode==null;
		
	}
	public void displayStack() {
        Node currentNode = headNode;
        if (headNode == null) {
            System.out.println("\nPriority Queue  is empty");
            return;
        }
        System.out.println("\nThe data in Priority Queue: ");
        while (currentNode != null) {
            System.out.print(currentNode.data + "--->");
            currentNode = currentNode.nextNode;
        }
        System.out.print("null");
        System.out.println();
    }

	public static void main(String[] args) 
	{
		PriorityQueue pQueue=new PriorityQueue();
		pQueue.add(10, 1);
		pQueue.add(5, 2);
		pQueue.add(6, 0);
		pQueue.add(8,-1);
		pQueue.displayStack();
		System.out.println("The deleted data is "+ pQueue.removeNode().data);
		System.out.println("Head node data "+pQueue.getHeadData());
		while (!pQueue.isEmpty()) {
			System.out.print("remvoing nodes is ="+pQueue.getHeadData()+",");
			pQueue.removeNode();
		}
		pQueue.displayStack();
	}

}

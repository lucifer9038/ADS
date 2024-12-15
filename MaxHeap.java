package max;


class Node{
	int data;
	Node next,prev;
	
	public Node( int val) {
		this.data=val;
		this.next=null;
		this.prev=null;
	}
}
public class MaxHeap {
	Node head,tail;
	public MaxHeap() {
		this.head=null;
		this.tail=null;
	}
	private void reheapUp(Node node) 
	{
		Node parent=getParent(node);
		while (parent!=null && node.data>parent.data)
		{
			int temp=node.data;
			node.data=parent.data;
			parent.data=temp;
			node=parent;
			parent=getParent(node);
		}
	}
	private void reheapDown(Node node) 
	{
		while (node!=null)
		{
			Node leftChiledNode=node.next;
			Node rightChildNode=(leftChiledNode!=null)? leftChiledNode.next:null;
			
			if (leftChiledNode==null) 
			{
				break;
			}
			Node maxChildNode=leftChiledNode;
			if (rightChildNode!=null && rightChildNode.data>leftChiledNode.data) 
			{
				maxChildNode=rightChildNode;
			}
			if (node.data>=maxChildNode.data) {
				break;
			}
			int temp=node.data;
			node.data=maxChildNode.data;
			maxChildNode.data=temp;
			node=maxChildNode;
		}
	}
	public void insert(int data)
	{
		Node newNode=new Node(data);
		if (head==null) 
		{
			head=newNode;
			tail=newNode;
		}
		else 
		{
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
			
			reheapUp(newNode);
		}
	}
	public void delete()
	{
		if (head==null)
		{
			System.out.println("Heap is empty!!");
			return;
		}
		Node lastNode=tail;
		head.data=lastNode.data;
		
		if (tail.prev!=null)
		{
			tail=tail.prev;
			tail.next=null;
		}
		else {
			head=null;
		}
		reheapDown(head);
	}

	private Node getParent(Node node) {
		
		return node.prev;
	}
	public void printHeap() 
	{
		Node tempNode=head;
		while (tempNode!=null) 
		{
			System.out.println(tempNode.data+"  ");
			tempNode=tempNode.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		MaxHeap maxHeap=new MaxHeap();
		System.out.println("\n Isnertin g value in MaxHeap");
		maxHeap.insert(10);
		maxHeap.insert(20);
		maxHeap.insert(5);
		maxHeap.insert(8);
		maxHeap.printHeap();
		
		System.out.println("Deleteinh=g root node from MaxHeap");
		maxHeap.delete();
		maxHeap.printHeap();
	}

}

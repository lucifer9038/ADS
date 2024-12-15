package BST;

import java.util.Scanner;

class Node{
	int data;
	Node left,right;
	
	public Node( int val) {
		this.data=val;
		this.left=null;
		this.right=null;
	}
}
public class BinarySearchTree {
	private Node rootNode;
	static int count=0;
	
	public BinarySearchTree()
	{
		this.rootNode=null;
	}
	public static int nodeCounts()
	{
		return count;
	}
	public void insertNode(int val)
	{
		Node newNode=new Node(val);
		if (rootNode==null)
		{
			rootNode=newNode;
			count++;
		}
		else {
			Node travNode=rootNode;
			Node holdNode=null;
			while (travNode!=null)
			{
				holdNode=travNode;
				if (val>travNode.data)
				{
					travNode=travNode.right;
				}
				else if (val<travNode.data) 
				{
					travNode=travNode.left;
				}
				else {
					System.out.println("Duplicate Data");
					return;
				}
			}
			if (val>holdNode.data)
			{
				holdNode.right=newNode;
			}
			else {
				holdNode.left=newNode;
			}
			count++;
		}
	}
	public void inorder(Node root)
	{
		if (root!=null)
		{
			inorder(root.left);
			System.out.println(root.data+" ");
			inorder(root.right);
		}
	}
	public void inorder() 
	{
		inorder(rootNode);
	}
	public void preorder(Node root) 
	{
		if (root!=null) 
		{
			System.out.println(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	public void preorder() 
	{
		preorder(rootNode);
	}
	public void postorder(Node root) 
    {
        if (root != null) 
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void postorder() {
        postorder(rootNode);
    }
	public void smallest() 
	{
		Node trav=rootNode;
		if (trav==null) 
		{
			System.out.println("Tree is empty");
			return;
		}
		while (trav.left!=null) 
		{
			trav=trav.left;
		}
		System.out.println("Smallest Node is : " + trav.data);
	}
	public void largest()
	{
		Node trav=rootNode;
		if (trav==null) 
		{
			System.out.println("Tree is empty");
			return;
		}
		while (trav.right!=null) 
		{
			trav=trav.right;
		}
		System.out.println("Smallest Node is : " + trav.data);
	}
	public void search(int val) 
	{
		Node travNode=rootNode;
		while (travNode!=null)
		{
			if (val>travNode.data)
			{
				travNode=travNode.right;
			}
			else if (val>travNode.data) 
			{
				travNode=travNode.left;
			}
			else {
				System.out.println("Node with data "+val+" is  found");
				return;
			}
		}
		System.out.println("Node with data "+ val+" is not found!!");
	}
	public void removeNode(int val) 
	{
		rootNode=removeNodeRecusrsive(rootNode,val);
		if (rootNode!=null) 
		{
			count--;
		}
	}
	public Node removeNodeRecusrsive(Node rootNode,int val) 
	{
		if (rootNode==null) 
		{
			System.out.println("Node Not found!!!");
			return rootNode;
		}
		if (val<rootNode.data)
		{
			rootNode.left=removeNodeRecusrsive(rootNode.left, val);
		}
		else if (val>rootNode.data) 
		{
			rootNode.right=removeNodeRecusrsive(rootNode.right, val);
		}
		else {
			if (rootNode.left==null) 
			{
				return rootNode.right;
			}
			else if (rootNode.right==null)
			{
				return rootNode.left;
			}
			Node travNode=rootNode.left;
			while (travNode.right!=null) 
			{
				travNode=travNode.right;
			}
			rootNode.data=travNode.data;
			rootNode.left=removeNodeRecusrsive(rootNode.left, rootNode.data);
		}
		return rootNode;
	}
	
	public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        //45,39,56,12,34,78,32,10,89,54,67,81
        
        Scanner sc = new Scanner(System.in);

    	int data;
        
        int choice;

        System.out.print("\nBinary Search Tree\n\n");
    	do
    	{
    		System.out.print("\n1.Insert Node\n");
    		System.out.print("2.InOrder Traversal\n");
    		System.out.print("3.PreOrder Traversal\n");
    		System.out.print("4.PostOrder Traversal\n");
    		System.out.print("5.Smallest Node\n");
    		System.out.print("6.Largest Node\n");
    		System.out.print("7.Count Nodes\n");
    		System.out.print("8.Remove Node\n");
    		System.out.print("9.Search Node\n");
    		System.out.print("10.Exit\n");
    		System.out.print("Enter your choice : ");
    		choice = sc.nextInt();
    		switch (choice)
    		{
    		case 1: System.out.print("\nInsert Node - Enter data : ");
    				data= sc.nextInt();
    				bt.insertNode(data);
    				break;
    		case 2: System.out.print("\nInOrder Traversal : ");
					bt.inorder();
					break;
    		case 3: System.out.print("\nPreOrder Traversal : ");
					bt.preorder();
    				break;
    		case 4: System.out.print("\nPostOrder Traversal : ");
					bt.postorder();
					break;
    		case 5: System.out.print("\nSmallest node is : ");
    				bt.smallest();
					break;
    		case 6: System.out.print("\nLargest node is : ");
					bt.largest();
					break;  
    		case 7: System.out.print("\nTotal node count : " + nodeCounts());
					break;
    		case 8: System.out.print("\nRemove node - Enter key : ");
					data=sc.nextInt();
    				bt.removeNode(data);
					break;
    		case 9: System.out.print("\nSearch node - Enter Data : ");
    				data=sc.nextInt();
    				bt.search(data);
					break;
    		case 10: System.out.println("Exiting the program.");  
    				break;
    		default:
    			System.out.print("\nWrong choice! \n");
    			
    		} /*End of switch*/
    	}while(choice!=10); /*End of while*/
    	sc.close();
    }
}

package poly;
class Node{
	int coeff,pow;
	Node nextNode;
	public Node(int c, int p) {
		coeff = c;
		pow = p;
		nextNode=null;
	}
}

public class PolyAdd {
	static Node addPolynomial(Node head1,Node head2)
	{
		if (head1==null) return head2;
		if(head2==null) return head1;
		
		if(head1.pow>head2.pow)
		{
			Node nextPtrNode =addPolynomial(head1.nextNode, head2);
			head1.nextNode=nextPtrNode;
			return head1;
		}
		else if (head1.pow<head2.pow) {
			Node nextPtrNode=addPolynomial(head1, head2.nextNode);
			head2.nextNode=nextPtrNode;
			return head2;
		}
		Node nextPtrNode=addPolynomial(head1.nextNode, head2.nextNode);
		head1.coeff=head1.coeff+head2.coeff;
		return head1;
	}
	static void printList(Node head)
	{
		Node currNode=head;
		while (currNode!=null)
		{
			System.out.print(currNode.coeff+"x^"+currNode.pow+"-->");
			currNode=currNode.nextNode;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		//1st equation 
		Node head1=new Node(4,3);
		head1.nextNode=new Node(3,2);
		head1.nextNode.nextNode=new Node(3, 0);
		
		//2ND EQUATION
		Node head2=new Node(2 ,3);
		head2.nextNode=new Node(-7,0);
		
		Node head=addPolynomial(head1, head2);
		printList(head);
		
		
		

	}

}

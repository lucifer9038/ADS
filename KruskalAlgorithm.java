package graph;

import java.util.Scanner;

class Edge{
	int src,dest,weight;
	
	public Edge(int src,int dest, int weight)
	{
		this.src=src;
		this.dest=dest;
		this.weight=weight;
	}
}

public class KruskalAlgorithm {
	private int V;
	private int E;
	private Edge[] edges;
	private int edgeCount=0;
	
	
	public KruskalAlgorithm(int verices,int edgeCount) 
	{
		this.V=verices;
		this.E=edgeCount;
		edges=new Edge[edgeCount];
	}

	public void addEdge(int src,int dest,int weight)
	{
		edges[edgeCount++]=new Edge(src, dest, weight);
	}
	private int findParent(int[] parent,int vertex)
	{
		if (parent[vertex]!=vertex) 
		{
			parent[vertex]=findParent(parent, parent[vertex]);
		}
		return parent[vertex];
		
	}
	private void union(int[] parent,int[] rank,int x,int y)
	{
		int rootX=findParent(parent, x);
		int rootY=findParent(parent, y);
		
		if (rootX!=rootY) 
		{
			if (rank[rootX]<rank[rootY]) 
			{
				parent[rootX]=rootY;
			}else if (rank[rootX]>rank[rootY]) 
			{
				parent[rootY]=rootX;
			}else {
				parent[rootY]=rootX;
				rank[rootX]++;
			}
		}
	}
	private void sortEdges()
	{
		for(int i=0;i<E-1;i++)
		{
			for(int j=0;j<E-i-1;j++)
			{
				if (edges[j].weight>edges[j+1].weight) 
				{
					Edge tempEdge=edges[j];
					edges[j]=edges[j+1];
					edges[j+1]=tempEdge;
				}
			}
		}
	}
	public void kruskalMST() 
	{
		sortEdges();
		
		int[] parent=new int[V];
		int[] rank=new int[V];
		
		for(int i=0;i<V;i++)
		{
			parent[i]=i;
			rank[i]=0;
		}
		Edge[] mstEdges=new Edge[V-1];
		int mstIndex=0;
		int mstWeight=0;
		
		for(int i=0;i<E;i++)
		{
			if (mstIndex==V-1)break;
			
			Edge edge=edges[i];
			int srcParent=findParent(parent, edge.src);
			int destParent=findParent(parent, edge.dest);
			
			if (srcParent!=destParent)
			{
				mstEdges[mstIndex++]=edge;
				mstWeight+=edge.weight;
				union(parent, rank, srcParent, destParent);
			}
		}
		System.out.println("Edge in the MST: ");
		System.out.println("src des weight");
		
		for(int i=0;i<mstIndex;i++)
		{
			System.out.println(mstEdges[i].src+"--"+mstEdges[i].dest+"=="+mstEdges[i].weight);
		}
		System.out.println("Total Wieght of MST: "+mstWeight);
	}
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Ente rthe number of vertices");
		int V=scanner.nextInt();
		
		System.out.println("Enter the number of edge: ");
		int E=scanner.nextInt();
		
		KruskalAlgorithm graph=new KruskalAlgorithm(V, E);
		
		System.out.println("Enter the Edge in the format:src dest weight");
		for(int i=0;i<E;i++)
		{
			int src=scanner.nextInt();
			int dest=scanner.nextInt();
			int weight=scanner.nextInt();
			graph.addEdge(src, dest, weight);
		}
		graph.kruskalMST();
		scanner.close();
	}
	
}

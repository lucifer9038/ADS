package graph;

import java.util.Iterator;
import java.util.Scanner;

public class Graph {
	private int[][] adjacencyMatrix;
	private int numVertices;
	public Graph(int numVertices) {
		super();
		this.numVertices = numVertices;
		adjacencyMatrix = new int[numVertices][numVertices];
	}
	public void addEdge(int start,int end)
	{
		adjacencyMatrix[start][end]=1;
		adjacencyMatrix[end][start]=1;
	}
	public void bfs(int startVertex)
	{
		boolean[] visited=new boolean[numVertices];
		int[]queue=new int[numVertices];
		int front=0,rear=0;
		
		visited[startVertex]=true;
		queue[rear++]=startVertex;
		System.out.println("BFS Traversal Starting from vertex "+ startVertex+":");
		
		while (front<rear) 
		{
			int currentVertex=queue[front++];
			System.out.print(currentVertex+" ");
			
			for(int i=0;i<numVertices;i++)
			{
				if (adjacencyMatrix[currentVertex][i]==1 && !visited[i]) 
				{
					visited[i]=true;
					queue[rear++]=i;
				}
			}
		}
		System.out.println();
	}
	public void dfs(int startVertex)
	{
		boolean[] visited=new boolean[numVertices];
		int[] stack=new int[numVertices];
		int top=-1;
		
		stack[++top]=startVertex;
		visited[startVertex]=true;
		
		System.out.println("DFS traversal staring from vertex"+ startVertex+" : ");
		while (top>=0) 
		{
			int currentVertex=stack[top--];
			System.out.print(currentVertex+" ");
			
			for(int i= numVertices-1;i>=0;i--)
			{
				if (adjacencyMatrix[currentVertex][i]==1 && !visited[i])
				{
					visited[i]=true;
					stack[++top]=i;
				}
			}
		}
		System.out.println();
	}
	public void displayAdjacencyMatrix()
	{
		System.out.println("Adjancy Matrix: ");
		for(int i=0;i<numVertices;i++)
		{
			for(int j=0;j<numVertices;j++)
			{
				System.out.print(adjacencyMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter the number of vertices: ");
	    int numVertices = scanner.nextInt();

	    Graph graph = new Graph(numVertices);

	    System.out.print("Enter the number of edges: ");
	    int numEdge = scanner.nextInt();

	    System.out.println("Enter the edge (Source and Destination): ");
	    for (int i = 0; i < numEdge; i++) {
	        int src = scanner.nextInt();
	        int dest = scanner.nextInt();
	        graph.addEdge(src, dest);
	    }

	    graph.displayAdjacencyMatrix();

	    System.out.println("Enter the start vertex for BFS: ");
	    int bfsStartVertex = scanner.nextInt();
	    graph.bfs(bfsStartVertex);

	    System.out.println("Enter the start vertex for DFS: ");
	    int dfsStartVertex = scanner.nextInt();
	    graph.dfs(dfsStartVertex);  // Corrected the variable name here

	    scanner.close();
	}
}
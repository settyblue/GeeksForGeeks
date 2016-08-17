import java.util.ArrayList;
import java.util.Stack;
/**
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 * 
 */

/**
 * @author rakshith
 *
 */
public class Graph {
	
	private int vertices;
	private int edges;
	private boolean directional = false;
	private ArrayList<ArrayList<Integer>> adjList;
	
	Graph(int vertices, int edges){
		this.vertices = vertices;
		this.edges = edges;
		adjList = new ArrayList<>();
		for(int i=0; i<vertices; i++){
			adjList.add(new ArrayList<Integer>()) ;
		}
	}
	
	Graph(int vertices, int edges, boolean directional){
		this(vertices,edges);
		this.directional = directional;
	}
	
	public void addEdge(int v1, int v2){
		this.getAdjList().get(v1).add(v2);
		this.edges++;
	}
	
	public void addSymmetricEdge(int v1, int v2){
		this.getAdjList().get(v1).add(v2);
		this.getAdjList().get(v2).add(v1);
		this.edges += 2;
	}

	public ArrayList<ArrayList<Integer>> getAdjList() {
		return adjList;
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public int getEdges() {
		return edges;
	}

	public void setEdges(int edges) {
		this.edges = edges;
	}

	public void BFS(int startVertex) {
		boolean[] visited = new boolean[this.vertices];
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(startVertex);
		
		while(!queue.isEmpty()){
			int head = (int) queue.get(0);
			if(!visited[head]){
				visited[head] = true;
				for(Integer to:this.adjList.get(head)){
					queue.add(to);
				}
				System.out.println("visited node :"+head+" "+queue);
			}else{
				queue.remove(0);
			}
		}
	}
	
	public void DFS(int startVertex){
		
	}
}

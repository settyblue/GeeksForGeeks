/**
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 * 
 */

/**
 * @author Rakshith Kunchum
 *
 */
public class Main {

	public static void main(String[] args) {
		Graph g = new Graph(6,0,true);
		g.addEdge(5, 0); g.addEdge(4, 0); g.addEdge(5, 2); g.addEdge(4, 1);
		g.addEdge(2, 3); g.addEdge(3, 1);
		System.out.println("Hello World");
		g.printTopologicalSort();
	}

}

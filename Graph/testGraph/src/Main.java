/**
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		
		Graph g = new Graph(4,0,true);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal");
 
        g.BFS(0);

	}

}

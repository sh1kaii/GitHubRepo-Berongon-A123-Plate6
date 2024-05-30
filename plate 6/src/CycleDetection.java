import java.util.*;

public class CycleDetection {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list representation

    // Constructor
    public CycleDetection(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Utility function for DFS traversal
    private boolean isCyclicUtil(int v, boolean visited[], boolean recStack[]) {
        if (recStack[v])
            return true;

        if (visited[v])
            return false;

        visited[v] = true;
        recStack[v] = true;

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (isCyclicUtil(n, visited, recStack))
                return true;
        }

        recStack[v] = false;
        return false;
    }

    // Method to check if the graph has a cycle
    public boolean isCyclic() {
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];

        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    public static void main(String args[]) {
        // Example usage
        CycleDetection g = new CycleDetection(4); // Creating a graph with 4 vertices

        // Adding edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        // Checking if the graph has a cycle
        if (g.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
import java.util.*;

public class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list representation

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Assuming undirected graph
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // Method to check if the graph is connected
    boolean isConnected() {
        boolean visited[] = new boolean[V];
        DFSUtil(0, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    // Method to find the number of connected components
    int countConnectedComponents() {
        boolean visited[] = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        // Example usage
        Graph g = new Graph(5); // Creating a graph with 5 vertices

        // Adding edges to the graph
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        // Checking if the graph is connected
        if (g.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            int connectedComponents = g.countConnectedComponents();
            System.out.println("Number of connected components: " + connectedComponents);
        }
    }
}
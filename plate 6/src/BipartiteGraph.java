import java.util.*;

public class BipartiteGraph {
    public static boolean isBipartite(List<List<Integer>> edges, int numVertices) {
        int[] color = new int[numVertices]; // Array to store the color of each vertex
        Arrays.fill(color, -1); // Initialize all vertices with color -1 (unvisited)

        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal

        // Start BFS traversal from each vertex
        for (int i = 0; i < numVertices; i++) {
            if (color[i] == -1) { // If the vertex is unvisited
                color[i] = 0; // Assign color 0 to the current vertex
                queue.offer(i); // Add the current vertex to the queue

                // Perform BFS traversal
                while (!queue.isEmpty()) {
                    int currVertex = queue.poll();

                    // Traverse through the adjacent vertices
                    for (int neighbor : edges.get(currVertex)) {
                        // If the neighbor is unvisited
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[currVertex]; // Assign the opposite color to the neighbor
                            queue.offer(neighbor); // Add the neighbor to the queue
                        } else if (color[neighbor] == color[currVertex]) { // If the neighbor has the same color as the current vertex
                            return false; // The graph is not bipartite
                        }
                    }
                }
            }
        }
        return true; // If no conflicts are found, the graph is bipartite
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        List<List<Integer>> edges = new ArrayList<>();

        // Initialize the adjacency list for each vertex
        for (int i = 0; i < numVertices; i++) {
            edges.add(new ArrayList<>());
        }

        // Prompt the user to enter the edges of the graph
        System.out.println("Enter the edges of the graph (vertex1 vertex2):");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            edges.get(vertex1).add(vertex2);
            edges.get(vertex2).add(vertex1);
        }

        // Check if the graph is bipartite
        if (isBipartite(edges, numVertices)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
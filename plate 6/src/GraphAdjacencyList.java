import java.util.*;

public class GraphAdjacencyList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Create an ArrayList of LinkedLists to represent the adjacency list
        ArrayList<LinkedList<Integer>> adjacencyList = new ArrayList<>(numVertices);

        // Initialize the adjacency list with empty LinkedLists for each vertex
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new LinkedList<>());
        }

        // Prompt the user to enter the vertex pairs associated with each edge
        System.out.println("Enter the vertex pairs associated with each edge:");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt(); // First vertex of the edge
            int vertex2 = scanner.nextInt(); // Second vertex of the edge

            // Add the second vertex to the adjacency list of the first vertex
            adjacencyList.get(vertex1).add(vertex2);
            // Add the first vertex to the adjacency list of the second vertex (for undirected graph)
            adjacencyList.get(vertex2).add(vertex1);
        }

        // Print the adjacency list
        System.out.println("Adjacency List:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
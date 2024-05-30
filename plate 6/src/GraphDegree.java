import java.util.*;

public class GraphDegree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of vertices
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        // Create an array to store the degree of each vertex
        int[] vertexDegrees = new int[numVertices];

        // Prompt the user to enter the number of edges
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Process each edge and update the degrees of the corresponding vertices
        System.out.println("Enter the pairs of vertices associated with each edge:");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt(); // First vertex of the edge
            int vertex2 = scanner.nextInt(); // Second vertex of the edge

            // Increment the degree of each vertex by 1
            vertexDegrees[vertex1]++;
            vertexDegrees[vertex2]++;
        }

        // Print the degree of each vertex
        System.out.println("Degrees of each vertex:");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + ": " + vertexDegrees[i]);
        }
    }
}
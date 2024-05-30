import java.util.*;

public class IncidenceMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Create an incidence matrix to store the connections between vertices and edges
        int[][] incidenceMatrix = new int[numVertices][numEdges];

        // Prompt the user to enter the vertex pairs associated with each edge
        System.out.println("Enter the vertex pairs associated with each edge:");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt(); // First vertex of the edge
            int vertex2 = scanner.nextInt(); // Second vertex of the edge

            // Increment the corresponding entries in the incidence matrix
            incidenceMatrix[vertex1][i]++;
            incidenceMatrix[vertex2][i]++;
        }

        // Print the incidence matrix
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

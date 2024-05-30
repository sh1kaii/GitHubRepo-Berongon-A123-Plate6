import java.util.*;

public class GraphEdges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of vertices
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        // Create an adjacency matrix to represent the graph
        int[][] adjacencyMatrix = new int[n][n];

        // Prompt the user to enter the adjacency matrix of the graph
        System.out.println("Enter the adjacency matrix of the graph:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        // Find the edges of the graph and store them in a list
        List<String> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    edges.add("(" + (i + 1) + ", " + (j + 1) + ")");
                }
            }
        }

        // Count the frequency of each edge and store it in a map
        Map<String, Integer> edgeFrequency = new HashMap<>();
        for (String edge : edges) {
            edgeFrequency.put(edge, edgeFrequency.getOrDefault(edge, 0) + 1);
        }

        // Display the edges of the graph along with their frequencies
        System.out.println("Edges of the graph:");
        for (Map.Entry<String, Integer> entry : edgeFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }
    }
}
import java.util.*;

public class GraphIsomorphic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of vertices for both graphs
        System.out.print("Enter the number of vertices for the first graph: ");
        int numVertices1 = scanner.nextInt();
        System.out.print("Enter the number of vertices for the second graph: ");
        int numVertices2 = scanner.nextInt();

        // Prompt the user to enter the adjacency matrices for both graphs
        System.out.println("Enter the adjacency matrix for the first graph:");
        int[][] adjMatrix1 = readAdjacencyMatrix(scanner, numVertices1);
        System.out.println("Enter the adjacency matrix for the second graph:");
        int[][] adjMatrix2 = readAdjacencyMatrix(scanner, numVertices2);

        // Check if the graphs are isomorphic
        if (isIsomorphic(adjMatrix1, adjMatrix2)) {
            System.out.println("The two graphs are isomorphic.");
        } else {
            System.out.println("The two graphs are not isomorphic.");
        }
    }

    // Function to read an adjacency matrix from user input
    public static int[][] readAdjacencyMatrix(Scanner scanner, int numVertices) {
        int[][] adjMatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }
        return adjMatrix;
    }

    // Function to check if two graphs are isomorphic
    public static boolean isIsomorphic(int[][] adjMatrix1, int[][] adjMatrix2) {
        // Check if the number of vertices is the same for both graphs
        if (adjMatrix1.length != adjMatrix2.length) {
            return false;
        }

        // Check if the number of edges is the same for both graphs
        int numEdges1 = countEdges(adjMatrix1);
        int numEdges2 = countEdges(adjMatrix2);
        if (numEdges1 != numEdges2) {
            return false;
        }

        // Check if the degrees of vertices are the same for both graphs
        int[] degreeSequence1 = calculateDegreeSequence(adjMatrix1);
        int[] degreeSequence2 = calculateDegreeSequence(adjMatrix2);
        Arrays.sort(degreeSequence1);
        Arrays.sort(degreeSequence2);
        if (!Arrays.equals(degreeSequence1, degreeSequence2)) {
            return false;
        }

        return true;
    }

    // Function to count the number of edges in an adjacency matrix
    public static int countEdges(int[][] adjMatrix) {
        int numEdges = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = i + 1; j < adjMatrix.length; j++) {
                numEdges += adjMatrix[i][j];
            }
        }
        return numEdges;
    }

    // Function to calculate the degree sequence of a graph
    public static int[] calculateDegreeSequence(int[][] adjMatrix) {
        int numVertices = adjMatrix.length;
        int[] degreeSequence = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                degreeSequence[i] += adjMatrix[i][j];
            }
        }
        return degreeSequence;
    }
}
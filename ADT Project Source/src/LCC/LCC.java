package LCC;
import Data.Edge;
import Data.Graph;
import Data.Vertex;

import java.util.*;

/**
 * @author vishnurajendran
 */
public class LCC {

    private LCC(){

    }

    public static Graph largestConnectedComponent(Graph graph) {
        List<Vertex> largestComponentVertices = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();

        for (Vertex vertex : graph.vertexList) {
            if (!visited.contains(vertex)) {
                List<Vertex> currentComponent = depthFirstSearch(vertex, visited);
                if (currentComponent.size() > largestComponentVertices.size()) {
                    largestComponentVertices = currentComponent;
                }
            }
        }

        // Extract edges of the largest connected component
        List<Edge> largestComponentEdges = new ArrayList<>();
        for (Vertex vertex : largestComponentVertices) {
            for (Edge edge : vertex.getEdgeList()) {
                if (largestComponentVertices.contains(edge.v1) && largestComponentVertices.contains(edge.v2)) {
                    largestComponentEdges.add(edge);
                }
            }
        }

        // Create a new graph instance for the largest connected component
        return new Graph("Largest Connected Component", largestComponentVertices, largestComponentEdges);
    }

    private static List<Vertex> depthFirstSearch(Vertex startVertex, Set<Vertex> visited) {
        List<Vertex> connectedComponent = new ArrayList<>();
        Stack<Vertex> stack = new Stack<>();
        stack.push(startVertex);
        visited.add(startVertex);

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();
            connectedComponent.add(currentVertex);

            for (Edge edge : currentVertex.getEdgeList()) {
                Vertex neighbor = edge.v1.equals(currentVertex) ? edge.v2 : edge.v1;
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return connectedComponent;
    }
}

package Algorithms;

import Data.Edge;
import Data.Graph;
import Data.Vertex;
import Data.Vector2;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class DFS {

    public static List<Vertex> findLongestSimplePath(Graph graph) {
        Set<Vertex> visited = new HashSet<>();
        Stack<Vertex> stack = new Stack<>();
        Map<Vertex, Vertex> parent = new HashMap<>();
        Map<Vertex, Double> distance = new HashMap<>();

        Vertex start = graph.vertexList.getFirst();

        stack.push(start);
        visited.add(start);
        distance.put(start, 0.0);

        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            for (Edge edge : current.getEdgeList()) {
                Vertex neighbor = edge.v1.equals(current) ? edge.v2 : edge.v1;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                    parent.put(neighbor, current);
                    distance.put(neighbor, distance.get(current) + Vector2.euclidianDistance(current.getPosition(), neighbor.getPosition()));
                }
            }
        }

        Vertex farthest = start;
        for (Vertex vertex : distance.keySet()) {
            if (distance.get(vertex) > distance.get(farthest)) {
                farthest = vertex;
            }
        }

        List<Vertex> longestPath = new ArrayList<>();
        Vertex current = farthest;
        while (current != null) {
            longestPath.add(current);
            current = parent.get(current);
        }

        Collections.reverse(longestPath);
        return longestPath;
    }
}

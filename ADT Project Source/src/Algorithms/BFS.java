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
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;


public class BFS {
    public static List<Vertex> findLongestSimplePath(Graph graph) {
        // Store the visited vertices
        Set<Vertex> visited = new HashSet<>();
        // Store the parent of each vertex
        Map<Vertex, Vertex> parent = new HashMap<>();
        // Store the distance from the starting vertex
        Map<Vertex, Double> distance = new HashMap<>();

        Vertex start = graph.vertexList.getFirst();

        // Initialize the distance from the starting vertex
        distance.put(start, 0.0);

        // Queue for BFS
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            visited.add(current);
            for (Edge edge : current.getEdgeList()) {
                Vertex neighbor = edge.v1.equals(current) ? edge.v2 : edge.v1;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    distance.put(neighbor, distance.get(current) + Vector2.euclidianDistance(current.getPosition(), neighbor.getPosition()));
                    queue.add(neighbor);
                }
            }
        }

        // Find the vertex farthest from the start
        Vertex farthest = start;
        for (Vertex vertex : distance.keySet()) {
            if (distance.get(vertex) > distance.get(farthest)) {
                farthest = vertex;
            }
        }

        // Reconstruct the longest path
        List<Vertex> longestPath = new ArrayList<>();
        Vertex current = farthest;
        while (current != null) {
            longestPath.add(current);
            current = parent.get(current);
        }

        // Reverse the path to get the correct order
        Collections.reverse(longestPath);
        return longestPath;
    }
}

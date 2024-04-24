package Algorithms;

import Data.Edge;
import Data.Graph;
import Data.Vertex;

import java.util.*;

public class DFS {

    static int time = 0;

    public static int findDepth(Vertex u) {
        Set<Vertex> visited = new HashSet<>();
        Stack<Vertex> stack = new Stack<>();
        Map<Vertex, Integer> depth = new HashMap<>();

        stack.push(u);
        visited.add(u);
        depth.put(u, 0);

        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            for (Edge edge : current.getEdgeList()) {
                Vertex neighbor = edge.v1.equals(current) ? edge.v2 : edge.v1;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                    depth.put(neighbor, depth.get(current) + 1);
                }
            }
        }

        int maxDepth = 0;
        for (Integer d : depth.values()) {
            maxDepth = Math.max(maxDepth, d);
        }
        return maxDepth;
    }

    public static int DFSVisit(Vertex u, Set<Vertex> visited, Stack<Vertex> stack,
                               Map<Vertex, Integer> discoveryTime, Map<Vertex, Integer> finishTime) {
        time++;
        discoveryTime.put(u, time);
        stack.push(u);
        visited.add(u);
        int depth = 0;

        for (Edge edge : u.getEdgeList()) {
            Vertex v = edge.v1.equals(u) ? edge.v2 : edge.v1;
            if (!visited.contains(v)) {
                depth = Math.max(depth, DFSVisit(v, visited, stack, discoveryTime, finishTime));
            }
        }

        time++;
        finishTime.put(u, time);
        stack.pop();
        return depth + 1;
    }

    public static int DFSBasedLongestSimplePath(Graph graph) {
        // Determine Largest Connected Component (LCC)
        // Find Lmax
        int Lmax = 0;
        int sqRootVLCC = (int) Math.sqrt(graph.vertexList.size());
        for (int i = 0; i < sqRootVLCC; i++) {
            Vertex u = graph.get((new Random().nextInt(graph.vertexList.size())));
            int vDepth = findDepth(u);

            Vertex v = graph.get(new Random().nextInt(graph.vertexList.size()));
            int wDepth = findDepth(v);

            Lmax = Math.max(Lmax, Math.max(vDepth, wDepth));
        }
        return Lmax;
    }
}

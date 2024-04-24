package Algorithms;

import Data.Edge;
import Data.Graph;
import Data.Vertex;

import java.util.*;


public class BFS {

    public static int BFSBasedLongestSimplePath(Graph graph) {
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

    public static int findDepth(Vertex u) {
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        Map<Vertex, Integer> depth = new HashMap<>();

        queue.add(u);
        visited.add(u);
        depth.put(u, 0);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            for (Edge edge : current.getEdgeList()) {
                Vertex neighbor = edge.v1.equals(current) ? edge.v2 : edge.v1;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
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
}

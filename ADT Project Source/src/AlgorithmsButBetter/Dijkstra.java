package AlgorithmsButBetter;

import Data.Edge;
import Data.Graph;
import Data.Vertex;

import java.util.*;

/**
 * @author vishnurajendran
 */
public class Dijkstra {

    private Dijkstra(){}

    private static void initializeSingleSourceMax(Graph G, Vertex s) {
        for (Vertex v : G.vertexList) {
            v.dist = Double.NEGATIVE_INFINITY;
            v.prev = null;
        }
        s.dist = 0;
    }

    // Relax-MAX method
    private static void relaxMax(Vertex u, Vertex v) {
        if (v.dist < u.dist + 1) {
            v.dist = u.dist + 1;
            v.prev = u;
        }
    }

    // Dijkstra-MAX method
    public static int lsp(Graph G, Vertex s) {
        initializeSingleSourceMax(G, s);
        Set<Vertex> S = new HashSet<>();
        PriorityQueue<Vertex> Q = new PriorityQueue<>(Comparator.comparingDouble((Vertex v) -> v.dist).reversed());
        Q.addAll(G.vertexList);

        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            S.add(u);
            for (Edge e : u.getEdgeList()) {
                Vertex v = (e.v1 == u) ? e.v2 : e.v1;
                if(S.contains(v))
                    continue;
                var currDist = v.dist;
                relaxMax(u, v);
                if (v.dist > currDist) {
                    Q.remove(v);
                    Q.offer(v);
                }
            }
        }

        // Retrieve the longest simple path
        List<Vertex> longestPath = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        Vertex current = findVertexWithMaxDistance(G.vertexList);
        while (current != null) {
            longestPath.add(current);
            var e = G.getEdge(current, current.prev);
            if(e != null)
                edges.add(e);
            current = current.prev;
        }
        return edges.size();
    }

    // Find the vertex with the maximum distance
    private static Vertex findVertexWithMaxDistance(List<Vertex> vertexList) {
        Vertex maxVertex = null;
        double maxDistance = Double.NEGATIVE_INFINITY;
        for (Vertex v : vertexList) {
            if (v.dist > maxDistance) {
                maxDistance = v.dist;
                maxVertex = v;
            }
        }
        return maxVertex;
    }
}

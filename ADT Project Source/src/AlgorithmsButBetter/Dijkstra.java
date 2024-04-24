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
            v.dijDist = Double.NEGATIVE_INFINITY;
            v.dijkPrev = null;
        }
        s.dijDist = 0;
    }

    // Relax-MAX method
    private static void relaxMax(Vertex u, Vertex v) {
        if (v.dijDist < u.dijDist + 1) {
            v.dijDist = u.dijDist + 1;
            v.dijkPrev = u;
        }
    }

    // Dijkstra-MAX method
    public static int lsp(Graph G, Vertex s) {
        initializeSingleSourceMax(G, s);
        Set<Vertex> S = new HashSet<>();
        PriorityQueue<Vertex> Q = new PriorityQueue<>(Comparator.comparingDouble((Vertex v) -> v.dijDist).reversed());
        Q.addAll(G.vertexList);

        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            S.add(u);
            for (Edge e : u.getEdgeList()) {
                Vertex v = (e.v1 == u) ? e.v2 : e.v1;
                if(S.contains(v))
                    continue;
                var currDist = v.dijDist;
                relaxMax(u, v);
                if (v.dijDist > currDist) {
                    Q.remove(v);
                    Q.offer(v);
                }
            }
        }

        // Retrieve the longest simple path
        List<Vertex> longestPath = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        Vertex current = findVertexWithMaxDistance(G.vertexList);
        var dist = current.dijDist;
        while (current != null) {
            longestPath.add(current);
            var e = G.getEdge(current, current.dijkPrev);
            if(e != null)
                edges.add(e);
            current = current.dijkPrev;
        }
        return edges.size();
    }

    // Find the vertex with the maximum distance
    private static Vertex findVertexWithMaxDistance(List<Vertex> vertexList) {
        Vertex maxVertex = null;
        double maxDistance = Double.NEGATIVE_INFINITY;
        for (Vertex v : vertexList) {
            if (v.dijDist > maxDistance) {
                maxDistance = v.dijDist;
                maxVertex = v;
            }
        }
        return maxVertex;
    }
}

package AlgorithmsButBetter;

import Data.Edge;
import Data.Graph;
import Data.Vector2;
import Data.Vertex;

import java.util.*;

/**
 * @author vishnurajendran
 */
public class AStar {

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

    public static int lsp(Graph G, Vertex s, Vertex d) {
        initializeSingleSourceMax(G, s);
        for (Vertex v : G.vertexList) {
            v.heuristic = Vector2.euclidianDistance(s.getPosition(),d.getPosition());
        }
        Set<Vertex> S = new HashSet<>();
        PriorityQueue<Vertex> Q = new PriorityQueue<>(Comparator.comparingDouble((Vertex v) -> v.dist + v.heuristic).reversed()); // Max heap
        Q.addAll(G.vertexList);

        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            S.add(u);
            for (Edge e : u.getEdgeList()) {
                Vertex v = (e.v1 == u) ? e.v2 : e.v1;
                var curr = v.dist;
                relaxMax(u, v);
                if (v.dist > curr && !S.contains(v)) {
                    if (v.prev == null || !v.prev.equals(u)) {
                        if (Q.contains(v)) {
                            Q.remove(v);
                        }
                        Q.offer(v);
                    }
                }
            }
        }
        // Reconstruct the longest path
        Set<Vertex> visited = new HashSet<>();
        List<Vertex> longestPath = new ArrayList<>();
        var edges = new ArrayList<Edge>();
        Vertex current = d;

        while (current != null && !visited.contains(current)) {
            visited.add(current);
            longestPath.add(current);
            Vertex next = current.prev;
            if (next != null) {
                var e = G.getEdge(current, next);
                if (e != null)
                    edges.add(e);
            }
            current = next;
        }

        if (hasCycle(longestPath)) {
            return 0;
        }
        return edges.size();
    }

    private static boolean hasCycle(List<Vertex> path) {
        Set<Vertex> visited = new HashSet<>();
        for (Vertex v : path) {
            if (!visited.add(v)) {
                return true;
            }
        }
        return false;
    }

}

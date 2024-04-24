package AlgorithmsButBetter;

import Data.Edge;
import Data.Graph;
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
            v.heuristic = 0; // Set heuristic distance from v to d to 0
        }
        Set<Vertex> S = new HashSet<>(); // Closed list
        PriorityQueue<Vertex> Q = new PriorityQueue<>(Comparator.comparingDouble((Vertex v) -> v.dist + v.heuristic).reversed()); // Max heap
        Q.addAll(G.vertexList);

        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            S.add(u); // Add u to closed list
            for (Edge e : u.getEdgeList()) {
                Vertex v = (e.v1 == u) ? e.v2 : e.v1;
                relaxMax(u, v); // Relaxation process for LSP
                if (v.dist != Double.NEGATIVE_INFINITY) {
                    if (S.contains(v)) {
                        S.remove(v); // Remove v from closed list
                        Q.offer(v); // Insert v back into open list
                    } else {
                        Q.remove(v);
                        Q.offer(v);
                    }
                }
            }
        }

        // Reconstruct the longest path
        List<Vertex> longestPath = new ArrayList<>();
        Vertex current = d;
        while (current != null) {
            longestPath.add(current);
            current = current.prev;
        }
        Collections.reverse(longestPath);
        return longestPath.size();
    }

}

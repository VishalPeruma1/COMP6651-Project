package GraphGeneration;

import Data.Edge;
import Data.Graph;
import Data.Vector2;
import Data.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author vishnurajendran
 */
public class Generator {

    private Generator(){

    }

    public static Graph generateGraph(int n, float r){
        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0;i<n;i++){
            Random random = new Random(); // use a seed?
            float x = (float)Math.random();
            float y = (float)Math.random();
            vertices.add(new Vertex("vert_"+i, new Vector2(x, y)));
        }

        int edgeIndx = 0;
        List<Edge> edges = new ArrayList<>();
        for (Vertex vert1 : vertices){
            for (Vertex vert2: vertices) {
                if(vert1 == vert2)
                    continue;
                var sqauredDist = Vector2.sqauredDist(vert1.getPosition(),vert2.getPosition());
                //System.out.println("SQRD: " + sqauredDist + ", R^2: " + (r*r));
                if(sqauredDist > (r*r))
                    continue;
                Edge e = new Edge("edge_"+edgeIndx,vert1, vert2);
                if(edges.contains(e))
                    continue;
                edgeIndx++;
                vert1.addEdge(e);
                edges.add(e);
            }
        }
        return new Graph("Graph_"+n+"_"+r,vertices, edges);
    }

}

package FileIO;

import Data.Edge;
import Data.Graph;
import Data.Vector2;
import Data.Vertex;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class GraphSaver {
    public static boolean saveGraph(Graph graph, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/resources/graphs/" + fileName + ".edges"))) {
            bw.write("% CustomGraph: " + graph.name + "\n");
            for (Edge edge : graph.edgeList) {
                Vertex v1 = edge.v1;
                Vertex v2 = edge.v2;
                Vector2 v1Position = v1.getPosition();
                Vector2 v2Position = v2.getPosition();
                bw.write(v1.getName().replace("vert_", "") + " " + v1Position.x + " " + v1Position.y + " " +
                        v2.getName().replace("vert_", "") + " " + v2Position.x + " " + v2Position.y + "\n");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
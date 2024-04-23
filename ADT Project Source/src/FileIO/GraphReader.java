package FileIO;

import Data.Edge;
import Data.Graph;
import Data.Vector2;
import Data.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vishal Perumal
 */
public class GraphReader {
    public static Graph readGraph(String fileName) {
        BufferedReader br;
        try {
            List<Vertex> vertexList = new ArrayList<>();
            List<Edge> edgeList = new ArrayList<>();
            Map<String, Vector2> vertexPositions =  new HashMap<>();
            String filePath = "src/resources/graphs/" + fileName;
            String graphName = fileName.substring(0, fileName.lastIndexOf('.'));
            br = new BufferedReader(new FileReader(filePath));
            int edgeIndex = 0;
            float positionIndex = 0.0f;
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("%")) continue; // Skipping comments
                String[] parts = line.trim().split("\\s+");
                if (parts.length != 2) {
                    continue;
                }
                String vertex1Name = parts[0];
                String vertex2Name = parts[1];
                if (!vertexPositions.containsKey(vertex1Name)) {
                    vertexPositions.put(vertex1Name, new Vector2(positionIndex, positionIndex));
                    positionIndex++;
                }
                if (!vertexPositions.containsKey(vertex2Name)) {
                    vertexPositions.put(vertex2Name, new Vector2(positionIndex, positionIndex));
                    positionIndex++;
                }
                Vertex vertex1 = new Vertex(vertex1Name, vertexPositions.get(vertex1Name));
                Vertex vertex2 = new Vertex(vertex2Name, vertexPositions.get(vertex2Name));
                vertexList.add(vertex1);
                vertexList.add(vertex2);
                Edge edge = new Edge("edge_"+(++edgeIndex), vertex1, vertex2);
                vertex1.addEdge(edge);
                vertex2.addEdge(edge);
                edgeList.add(edge);
            }
            br.close();
            return new Graph(graphName, vertexList, edgeList);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

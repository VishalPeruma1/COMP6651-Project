package FileIO;

import Data.Edge;
import Data.Graph;
import Data.Vector2;
import Data.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
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
            Map<String, Vertex> vertexMap = new HashMap<>();
            String filePath = "src/resources/graphs/" + fileName;
            String graphName = fileName.substring(0, fileName.lastIndexOf('.'));
            String r = "-";
            br = new BufferedReader(new FileReader(filePath));
            int edgeIndex = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("%")) {
                    if(line.startsWith("% CustomGraph:")) {
                        String[] graphParams = line.split("_");
                        r = graphParams[2];
                    }
                    continue;
                }// Skipping comments
                String[] parts = line.trim().split("\\s+");
                String vertex1Name;
                String vertex2Name;
                Vertex vertex1;
                Vertex vertex2;
                Edge edge;
                switch(parts.length) {
                    case 2:
                        vertex1Name = "vert_"+parts[0];
                        vertex2Name = "vert_"+parts[1];
                        if(!vertexMap.containsKey(vertex1Name)) {
                            vertex1 = new Vertex(vertex1Name, Vector2.zero()); //new Vector2((float) Math.random(), (float) Math.random()));
                            vertexMap.put(vertex1Name, vertex1);
                            vertexList.add(vertex1);
                        }
                        if(!vertexMap.containsKey(vertex2Name)) {
                            vertex2 = new Vertex(vertex2Name, Vector2.zero()); //new Vector2((float) Math.random(), (float) Math.random()));
                            vertexMap.put(vertex2Name, vertex2);
                            vertexList.add(vertex2);
                        }
                        vertex1 = vertexMap.get(vertex1Name);
                        vertex2 = vertexMap.get(vertex2Name);
                        edge = new Edge("edge_"+(++edgeIndex), vertex1, vertex2);
                        if(!edgeList.contains(edge)) {
                            edgeList.add(edge);
                            vertex1.addEdge(edge);
                            vertex2.addEdge(edge);
                        }
                        break;
                    case 6:
                        vertex1Name = "vert_"+parts[0];
                        vertex2Name = "vert_"+parts[3];
                        if(!vertexMap.containsKey(vertex1Name)) {
                            vertex1 = new Vertex(vertex1Name, new Vector2(Float.parseFloat(parts[1]), Float.parseFloat(parts[2])));
                            vertexMap.put(vertex1Name, vertex1);
                            vertexList.add(vertex1);
                        }
                        if(!vertexMap.containsKey(vertex2Name)) {
                            vertex2 = new Vertex(vertex2Name, new Vector2(Float.parseFloat(parts[4]), Float.parseFloat(parts[5])));
                            vertexMap.put(vertex2Name, vertex2);
                            vertexList.add(vertex2);
                        }
                        vertex1 = vertexMap.get(vertex1Name);
                        vertex2 = vertexMap.get(vertex2Name);
                        edge = new Edge("edge_"+(++edgeIndex), vertex1, vertex2);
                        if(!edgeList.contains(edge)) {
                            edgeList.add(edge);
                            vertex1.addEdge(edge);
                            vertex2.addEdge(edge);
                        }
                        break;
                    default:
                }
            }
            br.close();
            return new Graph(graphName, vertexList, edgeList, vertexList.size(), r);
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("File does not exist!");
            return null;
        }
    }
}

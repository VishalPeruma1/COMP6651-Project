package Data;

import java.util.List;

/**
 * @author vishnurajendran
 */
public class Graph {
    public String name;
    public List<Vertex> vertexList;
    public List<Edge> edgeList;

    public Graph(String name, List<Vertex> vertexList, List<Edge> edgeList){
        this.name = name;
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }
}

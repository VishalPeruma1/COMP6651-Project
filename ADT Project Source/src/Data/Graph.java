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

    @Override
    public String toString() {
        var str = "Graph: " + name+"\nVertices";
        for (Vertex v : vertexList) {
            str += "\n\t"+v.toString();
        }
        str += "\nEdges";
        for (Edge e : edgeList) {
            str += "\n\t"+e.toString();
        }
        return str+"\n";
    }
}

package Data;

import java.util.List;

/**
 * @author vishnurajendran
 */
public class Graph {
    public String name;
    public List<Vertex> vertexList;
    public List<Edge> edgeList;
    public int n;
    public String r;

    public Graph(String name, List<Vertex> vertexList, List<Edge> edgeList, int n, String r){
        this.name = name;
        this.vertexList = vertexList;
        this.edgeList = edgeList;
        this.n = n;
        this.r = r;
    }

    public Edge getEdge(Vertex v1, Vertex v2){
        if(v1 == null || v2 == null)
            return null;

        for (var e: edgeList) {
            if(e.v1.equals(v1) && e.v2.equals(v2))
                return e;
            else if (e.v1.equals(v2) && e.v2.equals(v1))
                return e;
        }
        return null;
    }

    public void resetStats(){
        for(Vertex v : vertexList){
            v.resetStats();
        }
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

    public Vertex get(int i) {
        return vertexList.get(i);
    }
}

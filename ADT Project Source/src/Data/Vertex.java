package Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vishnurajendran
 */
public class Vertex {
    private Vector2 position;
    private String name;
    private List<Edge> edgeList;

    //for dijkstra
    public double dist;
    public Vertex prev;

    public double heuristic;


    public void resetStats(){
        heuristic = 0;
        dist = 0;
        prev = null;
    }

    public Vector2 getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public List<Edge> getEdgeList(){
        return edgeList;
    }

    public void setPosition(Vector2 position){
        this.position = position;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEdgeList(List<Edge> edgeList){
        this.edgeList = edgeList;
    }

    public void addEdge(Edge edge){
        if(edgeList == null)
            edgeList = new ArrayList<>();
        edgeList.add(edge);
    }

    public Vertex(String name, Vector2 position){
        this.name = name;
        this.position = position;
        edgeList = new ArrayList<>();
    }

    public Vertex(String name, Vector2 position, List<Edge> edges){
        this.name = name;
        this.position = position;
        this.edgeList = edges;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != Vertex.class)
            return false;

        var other = (Vertex)obj;
        return other.position.equals(position) && other.name.equals(name);
    }

    @Override
    public String toString() {
        return name + " " + position.toString();
    }
}

package Data;

import java.util.List;

/**
 * @author vishnurajendran
 */
public class Vertex {
    private Vector2 position;
    private String name;
    private List<Edge> edgeList;


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

    public Vertex(String name, Vector2 position){
        this.name = name;
        this.position = position;
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
}
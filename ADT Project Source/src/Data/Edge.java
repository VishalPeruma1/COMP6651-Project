package Data;

/**
 * @author vishnurajendran
 */
public class Edge {
    public String name;
    public Vertex v1;
    public Vertex v2;

    public Edge(String name, Vertex v1, Vertex v2){
        this.name = name;
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != Edge.class)
            return false;

        var other = (Edge)obj;
        return other.name == name && other.v1.equals(v1) && other.v2.equals(v2);
    }
}

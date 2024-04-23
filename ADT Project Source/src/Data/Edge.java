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
        return other.v1.equals(v1) && other.v2.equals(v2) || other.v1.equals(v2) && other.v2.equals(v1);
    }

    @Override
    public String toString() {
        return v1.getName() + "---" + v2.getName();
    }
}

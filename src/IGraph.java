public interface IGraph {

    public void addVertex(String label);

    public boolean addEdge (String fromLabel, String toLabel);

    public boolean remove (String label);

    public Vertex findVertex (String label);

    int indexOf(String label);

    void bfs(String startVertexLabel);

    public void display();
}

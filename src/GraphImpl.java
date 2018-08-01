import java.util.ArrayDeque;
import java.util.Queue;

public class GraphImpl implements IGraph {

    private Vertex[] vertices;
    private int[][] matrix;

    private int currentVertexSize;

    public GraphImpl(int maxVertexSize) {
        this.vertices = new Vertex[maxVertexSize];
        this.matrix = new int[maxVertexSize][maxVertexSize];
        this.currentVertexSize = 0;

        fillUpMatrix(maxVertexSize);
    }

    private void fillUpMatrix(int maxVertexSize) {
        for (int i = 0; i < maxVertexSize; i++) {
            for (int j = 0; j < maxVertexSize; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    @Override
    public void addVertex(String label) {
        Vertex newVertex = new Vertex(label);
        vertices[currentVertexSize++] = newVertex;
    }

    @Override
    public boolean addEdge(String fromLabel, String toLabel) {
        int from = indexOf(fromLabel);
        int to = indexOf(toLabel);

        if (from == -1 || to == -1) {
            return false;
        }
        matrix[from][to] = 1; // если ребро, связь с вершинами установлена добавляем в матрицу 1
        matrix[to][from] = 1; // так как матрица зеркальная, то и для обратного порядка вершин добавляем 1

        return true;
    }

    private boolean hasEdge(Vertex from, Vertex to) {
        return hasEdge(from.getLabel(), to.getLabel());
    }

    private boolean hasEdge(String fromLabel, String toLabel) {
        int from = indexOf(fromLabel);
        int to = indexOf(toLabel);
        if (from == -1 || to == -1)
            return false;

        return matrix[from][to] == 1;
    }

    @Override
    public boolean remove(String label) {
        Vertex removedVertex = findVertex(label);
        if (removedVertex == null) {
            return false;
        }
        int vertexIndex = indexOf(label);
        clearEdgesInMatrix(vertexIndex);

        vertices[vertexIndex] = null; // удаляем саму вершину
        currentVertexSize--;

        return false;
    }

    private void clearEdgesInMatrix(int vertexIndex) {
        for (int i = 0; i < currentVertexSize; i++) { // удаяем в матрице 1, ставим 0, что связи отсутствуют
            matrix[vertexIndex][i] = 0;
            matrix[i][vertexIndex] = 0;
        }
    }

    @Override
    public Vertex findVertex(String label) {
        for (int i = 0; i < currentVertexSize; i++) {
            if (vertices[i] == null) {
                continue;
            }
            String vertexLabel = vertices[i].getLabel(); // получаем стринг из Vertex

            if (vertexLabel.equals(label)) { // уже стравниваем стрин со стринг
                return vertices[i];
            }
        }
        return null;
    }

    @Override
    public int indexOf(String label) {
        for (int index = 0; index < currentVertexSize; index++) {
            if (vertices[index] == null) {
                continue;
            }
            String vertexLabel = vertices[index].getLabel(); // получаем стринг из Vertex

            if (vertexLabel.equals(label)) { // уже стравниваем стринг со стринг
                return index;
            }
        }
        return -1;
    }

    @Override
    public void display() {
        for (int i = 0; i < currentVertexSize; i++) {
            if (vertices[i] == null) {
                continue;
            }
            String out = vertices[i].toString();
            for (int j = 0; j < currentVertexSize; j++) {
                if (matrix[i][j] == 1) {
                    out += "->" + vertices[j];
                }
            }
            System.out.println(out);
        }
    }

    private void visit(Vertex vertex, Queue<Vertex> queue) {
        display();
        vertex.setWasVisited(true);
        queue.add(vertex);
    }

    private Vertex getAdjUnvisitedVertex(Vertex vertex) {
        for (int i = 0; i < vertices.length; i++) {
            Vertex currentVertex = vertices[i];
            if (hasEdge(vertex, currentVertex) && !currentVertex.isWasVisited()) {
                return currentVertex;
            }
        }

        return null;
    }


    @Override
    public void bfs(String startVertexLabel) {
        Vertex vertex = findVertex(startVertexLabel);
        if (vertex == null) {
            return;
        }

        Queue<Vertex> queue = new ArrayDeque();
        visit(vertex, queue);

        while (!queue.isEmpty()) {
            vertex = queue.remove();
            Vertex currentVertex = null;
            while ((currentVertex = getAdjUnvisitedVertex(vertex)) != null) {
                visit(currentVertex, queue);
            }
        }

//        private void display (Vertex vertex){
//            System.out.println(vertex);
//        }
    }
}
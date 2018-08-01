public class Main {

    public static void main(String[] args) {
        IGraph graph = new GraphImpl(10);
        graph.addVertex("Iron Man");
        graph.addVertex("Star-Lord");
        graph.addVertex("Thor");
        graph.addVertex("Spider Man");
        graph.addVertex("Hulk");
        graph.addVertex("Rocket Raccoon");
        graph.addVertex("Groot");
        graph.addVertex("Gomorra");
        graph.addVertex("Deadpool");
        graph.addVertex("Doctor Strange");

        graph.addEdge("Iron Man", "Spider Man");
        graph.addEdge("Star-Lord", "Thor");
        graph.addEdge("Hulk", "Rocket Raccoon");
        graph.addEdge("Hulk", "Groot");
        graph.addEdge("Rocket Raccoon", "Groot");
        graph.addEdge("Star-Lord", "Gomorra");
        graph.addEdge("Doctor Strange", "Deadpool");
        graph.addEdge("Star-Lord", "Rocket Raccoon");
        graph.addEdge("Star-Lord", "Groot");

        graph.display();

        System.out.println("---bfs---");

        graph.bfs("Iron Man");
    }
}

package Graphs;

public class Main {

    public static void main (String[] args) {
        Graph graph = new Graph(5);
        graph.addVertx(0);
        graph.addVertx(1);
        graph.addVertx(2);
        graph.addVertx(3);
        graph.addVertx(4);

        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(2, 4);
        graph.addEdge(2, 1);
        graph.addEdge(3, 4);
        graph.addEdge(1, 3);

        graph.bfs(0);
    }
}

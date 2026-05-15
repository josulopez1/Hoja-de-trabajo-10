public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(4);

        graph.addCity("Guatemala");
        graph.addCity("Antigua");
        graph.addCity("Escuintla");
        graph.addCity("SantaLucia");

        graph.addEdge("Guatemala", "Antigua", 45);
        graph.addEdge("Antigua", "Escuintla", 30);
        graph.addEdge("Escuintla", "SantaLucia", 20);

        graph.printMatrix();

        FloydWarshall floyd = new FloydWarshall(graph);

        floyd.runFloydWarshall();

        floyd.printShortestPath("Guatemala", "SantaLucia");

        floyd.findGraphCenter();
    }
}
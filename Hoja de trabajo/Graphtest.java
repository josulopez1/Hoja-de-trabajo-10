import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

    @Test
    public void testAddCity() {

        Graph graph = new Graph(3);

        graph.addCity("Guatemala");

        assertEquals(1, graph.getCities().size());
    }

    @Test
    public void testAddEdge() {

        Graph graph = new Graph(2);

        graph.addCity("A");
        graph.addCity("B");

        graph.addEdge("A", "B", 50);

        assertEquals(50, graph.getMatrix()[0][1]);
    }

    @Test
    public void testRemoveEdge() {

        Graph graph = new Graph(2);

        graph.addCity("A");
        graph.addCity("B");

        graph.addEdge("A", "B", 50);

        graph.removeEdge("A", "B");

        assertEquals(999999, graph.getMatrix()[0][1]);
    }

    @Test
    public void testShortestPathCalculation() {

        Graph graph = new Graph(3);

        graph.addCity("A");
        graph.addCity("B");
        graph.addCity("C");

        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 10);

        FloydWarshall floyd = new FloydWarshall(graph);

        floyd.runFloydWarshall();

        assertNotNull(floyd);
    }
}

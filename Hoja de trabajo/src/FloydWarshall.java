import java.util.*;

public class FloydWarshall {

    private final int INF = 999999;

    private int[][] dist;
    private int[][] next;
    private List<String> cities;

    public FloydWarshall(Graph graph) {

        cities = graph.getCities();

        int size = cities.size();

        dist = new int[size][size];
        next = new int[size][size];

        int[][] matrix = graph.getMatrix();

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                dist[i][j] = matrix[i][j];

                if (matrix[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }
    }

    public void runFloydWarshall() {

        int size = dist.length;

        for (int k = 0; k < size; k++) {

            for (int i = 0; i < size; i++) {

                for (int j = 0; j < size; j++) {

                    if (dist[i][k] != INF &&
                            dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {

                        dist[i][j] = dist[i][k] + dist[k][j];

                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    public void printShortestPath(String from, String to) {

        int start = cities.indexOf(from);
        int end = cities.indexOf(to);

        if (start == -1 || end == -1) {

            System.out.println("Ciudad no encontrada.");
            return;
        }

        if (next[start][end] == -1) {

            System.out.println("No existe ruta.");
            return;
        }

        List<String> path = new ArrayList<>();

        int current = start;

        while (current != end) {

            path.add(cities.get(current));

            current = next[current][end];
        }

        path.add(cities.get(end));

        System.out.println("\nRuta más corta:");

        for (int i = 0; i < path.size(); i++) {

            System.out.print(path.get(i));

            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }

        System.out.println("\nDistancia total: " + dist[start][end] + " KM");
    }

    public void findGraphCenter() {

        int size = dist.length;

        int center = -1;
        int minEccentricity = INF;

        for (int i = 0; i < size; i++) {

            int maxDistance = 0;
            boolean valid = true;

            for (int j = 0; j < size; j++) {

                if (dist[i][j] == INF) {
                    valid = false;
                    break;
                }

                if (dist[i][j] > maxDistance) {
                    maxDistance = dist[i][j];
                }
            }

            if (valid && maxDistance < minEccentricity) {

                minEccentricity = maxDistance;
                center = i;
            }
        }

        if (center == -1) {

            System.out.println("\nEl grafo no tiene centro.");

        } else {

            System.out.println("\nCentro del grafo: " + cities.get(center));
        }
    }
}
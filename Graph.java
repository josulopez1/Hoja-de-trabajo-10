import java.util.*;

public class Graph {

    private final int INF = 999999;

    private List<String> cities;
    private int[][] matrix;

    public Graph(int size) {
        cities = new ArrayList<>();
        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = INF;
                }
            }
        }
    }

    public void addCity(String city) {
        cities.add(city);
    }

    public void addEdge(String from, String to, int distance) {
        int i = cities.indexOf(from);
        int j = cities.indexOf(to);

        matrix[i][j] = distance;
    }

    public void removeEdge(String from, String to) {
        int i = cities.indexOf(from);
        int j = cities.indexOf(to);

        matrix[i][j] = INF;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public List<String> getCities() {
        return cities;
    }

    public void printMatrix() {

        System.out.println("\nMatriz de Adyacencia:");

        for (int[] row : matrix) {
            for (int value : row) {

                if (value == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }
}

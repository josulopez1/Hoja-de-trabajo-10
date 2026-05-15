import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileManager {

    public static Graph loadGraph(String filename) {

        Set<String> citySet = new HashSet<>();
        List<String[]> connections = new ArrayList<>();

        try {

            Scanner scanner = new Scanner(new File(filename));

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] parts = line.split(" ");

                String from = parts[0];
                String to = parts[1];
                int distance = Integer.parseInt(parts[2]);

                citySet.add(from);
                citySet.add(to);

                connections.add(parts);
            }

            Graph graph = new Graph(citySet.size());

            for (String city : citySet) {
                graph.addCity(city);
            }

            for (String[] connection : connections) {

                String from = connection[0];
                String to = connection[1];
                int distance = Integer.parseInt(connection[2]);

                graph.addEdge(from, to, distance);
            }

            return graph;

        } catch (FileNotFoundException e) {

            System.out.println("Archivo no encontrado.");

            return null;
        }
    }
}
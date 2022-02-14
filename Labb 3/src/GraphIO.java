import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class GraphIO {

    private static int[] x;

    static public void readFile(Graph g, String filename) throws IOException {

        File data = new File(filename);
        Scanner scan = null;

        try {
            scan = new Scanner(data);
        } catch (IOException e) {
            throw new IOException();
        }

        int lines = scan.nextInt();

        for (int i = 0; i < lines; i++) {
            g.addNode(scan.nextInt(), scan.nextInt(), scan.nextInt());
        }

        while (scan.hasNext()) {
            g.addEdge(scan.nextInt(), scan.nextInt(), scan.nextInt());
        }

    }
}

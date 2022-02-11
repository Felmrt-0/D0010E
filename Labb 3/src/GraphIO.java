import java.util.NoSuchElementException;
import java.io.*;
import java.util.Scanner;

public class GraphIO {

    private static int[] x;

    static public void readFile(Graph g, String filename) {
        System.out.print(filename);

        File data = new File(filename);
        Scanner scan = null;

        try {
            scan = new Scanner(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int lines = scan.nextInt();

        for(int i = 0; i < lines; i++){
            g.addNode(scan.nextInt(), scan.nextInt(), scan.nextInt());
        }

        while(scan.hasNext()){
            g.addEdge(scan.nextInt(), scan.nextInt(), scan.nextInt());
        }

    }
}

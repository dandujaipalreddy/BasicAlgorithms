package eocp.arrays;


import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Jai on 11/15/2016.
 */
public class Main {


    public static void main(String[] args) {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);

        int n = in.readInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i - 1; j >= 0; j--)
                if (arr[i].compareTo(arr[j]) > 0) count++;
            sb.append(count);
            sb.append("\n");
        }

        System.out.print(sb);

    }


    static class InputReader {
        private BufferedReader input;
        private StringTokenizer line = new StringTokenizer("");

        public InputReader(InputStream in) {
            input = new BufferedReader(new InputStreamReader(in));
        }

        public void fill() {
            try {
                if (!line.hasMoreTokens()) {
                    line = new StringTokenizer(input.readLine());
                }
            } catch (IOException io) {
                io.printStackTrace();
                System.exit(0);
            }
        }

        public String next() {
            fill();
            return line.nextToken();
        }

        public int readInt() {
            fill();
            return Integer.parseInt(line.nextToken());
        }

        public char readChar() {
            fill();
            return line.nextToken().charAt(0);
        }

    }

    static class OutputWriter {
        private PrintWriter output;

        public OutputWriter(OutputStream out) {
            output = new PrintWriter(out);
        }

        public void println(Object o) {
            output.println(o);
        }

        public void close() {
            output.close();
        }
    }
}

class Road implements Comparable<Road> {

    int x1;
    int x2;

    public Road(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Road o) {
        if (this.x1 < o.x1)
            return -1;
        return 1;

    }

    @Override
    public String toString() {
        return "Road{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                '}';
    }
}
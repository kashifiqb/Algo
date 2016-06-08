import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class Edge {
        int v, w, c;

        public Edge(int v, int w, int c) {
            this.v = v;
            this.w = w;
            this.c = c;
        }

        public int either() {return v;}

        public int other(int verx) {
            if( verx == v) return w;
            if (verx == w) return v;
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int v = sc.nextInt();
            int e = sc.nextInt();

            int maxV = v + 1;
            LinkedList<Edge> [] graph = new LinkedList[maxV];
            boolean[] inTree = new boolean[maxV];
            int[] distTo = new int[maxV];
            Arrays.fill(distTo, Integer.MAX_VALUE);

            for (int j = 0; j < maxV; j++) {
                graph[j] = new LinkedList<Edge>();
            }

            for (int j = 0; j < e; j++) {
                int f = sc.nextInt();
                int t = sc.nextInt();
                int w = sc.nextInt();

                Edge edge = new Edge(f, t, w);
                graph[f].add(edge);
                graph[t].add(edge);


            }

            int s = sc.nextInt();
            int start = s;
            distTo[s] = 0;

            while (!inTree[s]) {
                inTree[s] = true;
                for(Edge edge: graph[s]) {
                    if(distTo[edge.other(s)] > (distTo[s] + edge.c)) {
                        distTo[edge.other(s)] = (distTo[s] + edge.c);
                    }
                }

                s = 1;
                int dist = Integer.MAX_VALUE;
                for (int j = 0; j < maxV; j++) {
                    if(!inTree[j] && dist > distTo[j]) {
                        s = j;
                        dist = distTo[j];
                    }
                }
            }

            for (int j = 1; j < maxV; j++) {
                if (j == start) continue;
                if (distTo[j] == Integer.MAX_VALUE) System.out.print("-1 ");
                else System.out.print(distTo[j]+" ");
            }

            System.out.println();

        }

    }
}
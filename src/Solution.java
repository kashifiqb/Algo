import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] data = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            data[i] = sc.nextInt();
        }

        moveToFront(data, 4, 4);
        moveToEnd(data, 2, 4);

        for (int i = 1; i <= N; i++) {
            System.out.print(data[i] + " ");
        }
    }

    private static void moveToEnd(int[] data, int i, int j) {

    }

    private static void moveToFront(int[] data, int i, int j) {

        int[] aux = new int[j - i + 1];
        int auxIdx = 0;
        for (int k =i; k <= j; k++) {
            aux[auxIdx++] = data[k];
        }

        int[] front = new int[i-1];
        int frontIdx = 0;
        for (int k = 1; k <i ; k++) {
            front[frontIdx++] = data[k];
        }

        int idx = 1;
        for (int k = 0; k < aux.length; k++) {
            data[idx++] = aux[k];
        }

        for (int k = 0; k < front.length; k++) {
            data[idx++] = front[k];
        }

    }

}
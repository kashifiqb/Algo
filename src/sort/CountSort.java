package sort;

import java.util.Scanner;

/**
 * Created by NicqChen on 6/11/2016.
 */
public class CountSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] data = new char[N];
        char[] aux = new char[N];
        for (int i = 0; i < N; i++) {
            data[i] = sc.next().charAt(0);
        }

        int[] count = new int[128];

        for (int i = 0; i < data.length; i++) {
            count[data[i]+1]++;
        }

        for (int i = 0; i < 127; i++) {
            count[i + 1] += count[i];
        }

        for (int i = 0; i < data.length; i++) {
            aux[count[data[i]]++] = data[i];
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = aux[i];
        }

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }

}

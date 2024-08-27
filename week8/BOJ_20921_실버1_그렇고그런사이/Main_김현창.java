package week8.BOJ_20921_실버1_그렇고그런사이;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] v = new int[N];
        for (int i = 0; i < N; ++i) {
            v[i] = i + 1;
        }

        for (; K > 0;) {
            for (int j = 0; j < N - 1 && K > 0; ++j) {
                if (v[j] < v[j + 1]) {
                    swap(v, j, j + 1);
                    --K;
                }
            }
        }
        printArray(v, N);
        br.close();
    }

    private static void printArray(int[] arr, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
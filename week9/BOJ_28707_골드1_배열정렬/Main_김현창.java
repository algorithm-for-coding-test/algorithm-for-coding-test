package week9.BOJ_28707_골드1_배열정렬;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int A = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            A = 10 * A + (Integer.parseInt(st.nextToken()) - 1);
        }

        char[] temp = String.valueOf(A).toCharArray();
        Arrays.sort(temp);
        int target = Integer.parseInt(String.valueOf(temp));

        int M = Integer.parseInt(br.readLine());
        Operation[] operations = new Operation[M];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            operations[i] = new Operation(l, r, c);
        }

        final int INF = 123456789;
        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(A, 0);
        Queue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        heap.add(new Node(A, 0));
        while (heap.size() > 0) {
            Node currNode = heap.poll();

            if (distance.getOrDefault(currNode.num, INF) < currNode.cost)
                continue;

            for (Operation op: operations) {
                int nextNumber = digitSwap(currNode.num, N, op.l, op.r);
                int cost = currNode.cost + op.c;
                if (distance.getOrDefault(nextNumber, INF) > cost) {
                    distance.put(nextNumber, cost);
                    heap.add(new Node(nextNumber, cost));
                }
            }
        }
        System.out.println(distance.getOrDefault(target, -1));
        br.close();
    }

    private static int digitSwap(int num, int digits, int a, int b) {
        int l = (num / (int) Math.pow(10, digits - a)) % 10;
        int r = (num / (int) Math.pow(10, digits - b)) % 10;
        num -= l * (int) Math.pow(10, digits - a);
        num -= r * (int) Math.pow(10, digits - b);
        num += r * (int) Math.pow(10, digits - a);
        num += l * (int) Math.pow(10, digits - b);
        return num;
    }

    private static class Node {
        int num, cost;

        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    private static class Operation {
        int l, r, c;

        Operation(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }
}

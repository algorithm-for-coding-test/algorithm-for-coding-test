package week1.BOJ_17265_골드5_나의인생에는수학과함께;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    private static final int[] dx = {1, 0};
    private static final int[] dy = {0, 1};
    private static int N;
    private static char[][] graph;
    private static int[] answer = {-1234567, 1234567};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                graph[i][j] = st.nextToken().charAt(0);
            }
        }
        dfs(0, 0, new StringBuilder());
        System.out.println(answer[0] + " " + answer[1]);
        br.close();
    }

    private static void dfs(int x, int y, StringBuilder sb) {
        sb.append(graph[x][y]);
        if (x == N - 1 && y == N - 1) {
            int result = calculate(sb.toString());
            answer[0] = Math.max(answer[0], result);
            answer[1] = Math.min(answer[1], result);
        } else {
            for (int i = 0; i < 2; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= N || ny >= N)
                    continue;
                dfs(nx, ny, sb);
            }
        }
        sb.setLength(sb.length() - 1);
    }

    private static int calculate(String expression) {
        int result = 0;
        char operand = '+';
        int exprLength = expression.length();
        for (int i = 0; i < exprLength; ++i) {
            if ((i & 1) != 0) {
                operand = expression.charAt(i);
                continue;
            }
            switch (operand) {
                case '+':
                    result += expression.charAt(i) - '0';
                    break;
                case '-':
                    result -= expression.charAt(i) - '0';
                    break;
                case '*':
                    result *= expression.charAt(i) - '0';
                    break;
            }
        }
        return result;
    }
}

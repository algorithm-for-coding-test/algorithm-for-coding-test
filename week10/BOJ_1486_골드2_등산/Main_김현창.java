package week10.BOJ_1486_골드2_등산;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            for (int j = 0; j < M; ++j) {
                map[i][j] = convert(line.charAt(j));
            }
        }

        final int INF = 123456789;
        int sz = N * M;

        int[][] floyd = new int[sz][sz];
        for (int i = 0; i < sz; ++i)
            Arrays.fill(floyd[i], INF);

        for (int x = 0; x < N; ++x) {
            for (int y = 0; y < M; ++y) {
                floyd[x * M + y][x * M + y] = 0;
                for (int i = 0; i < 4; ++i) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                        continue;
                    int diff = map[nx][ny] - map[x][y];
                    if (Math.abs(diff) > T)
                        continue;
                    floyd[x * M + y][nx * M + ny] = diff > 0 ? diff * diff : 1;
                }
            }
        }

        for (int k = 0; k < sz; ++k) {
            for (int i = 0; i < sz; ++i) {
                for (int j = 0; j < sz; ++j) {
                    if (floyd[i][j] > floyd[i][k] + floyd[k][j])
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                }
            }
        }

        int answer = map[0][0];
        for (int i = 1; i < sz; ++i) {
            if (floyd[0][i] + floyd[i][0] <= D)
                answer = Math.max(answer, map[i / M][i % M]);
        }
        System.out.println(answer);
        br.close();
    }

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static int convert(char c) {
        if ('a' <= c && c <= 'z')
            return c - 'a' + 26;
        if ('A' <= c && c <= 'Z')
            return c - 'A';
        return -1;
    }
}

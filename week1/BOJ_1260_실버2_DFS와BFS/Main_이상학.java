import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이상학 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] map;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for(int i=0; i<M; i++) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = map[end][start] = 1;
        }

        dfs(V);
        sb.append("\n");
        visit = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int start) {

        visit[start] = true;
        sb.append(start).append(" ");
        for(int i=1; i<=N; i++) {

            if(map[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()) {

            start = q.poll();
            sb.append(start).append(" ");
            for(int i=1; i<=N; i++) {

                if(map[start][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}

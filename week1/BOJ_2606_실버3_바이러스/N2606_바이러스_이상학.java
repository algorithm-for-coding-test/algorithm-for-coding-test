import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2606_바이러스_이상학 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int computerCnt, networkCnt;
    static final int START = 1;
    static int[][] map;
    static boolean[] visit;
    static int result;

    public static void main(String[] args) throws IOException {

        computerCnt = Integer.parseInt(br.readLine());
        networkCnt = Integer.parseInt(br.readLine());

        map = new int[computerCnt+1][computerCnt+1];
        visit = new boolean[computerCnt+1];
        for(int i=0; i<networkCnt; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        result = 0;
        bfs(START);
        System.out.println(result);
    }

    static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()) {

            start = q.poll();
            for(int i=1; i<=computerCnt; i++) {

                if(map[start][i] == 1 && !visit[i]) {
                    result++;
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}

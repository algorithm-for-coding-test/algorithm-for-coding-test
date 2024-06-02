import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N21938_영상처리_이상학 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, T;
    static int[][] map;
    static int[][] rgbAvg;

    static boolean[][] visit;

    static int result;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        rgbAvg = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++) {

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {

                double r = Double.parseDouble(st.nextToken());
                double g = Double.parseDouble(st.nextToken());
                double b = Double.parseDouble(st.nextToken());

                int avg = (int) (r+g+b)/3;
                rgbAvg[i][j] = avg;
            }
        }

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {

                if(rgbAvg[i][j] < T) {
                    map[i][j] = 0;
                }
                else {
                    map[i][j] = 1;
                }
            }
        }

        result = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {

                if(map[i][j] == 1 && !visit[i][j]) {
                    dfs(i, j);

                    result++;
                }
            }
        }

        System.out.println(result);

    }

    static void dfs(int xPoint, int yPoint) {

        visit[xPoint][yPoint] = true;

        for(int dir=0; dir<4; dir++) {

            int x = xPoint + dx[dir];
            int y = yPoint + dy[dir];
            if((x < 0 || x >= N) || (y < 0 || y >= M)) {
                continue;
            }

            if(map[x][y] == 1 && !visit[x][y]) {
                dfs(x, y);
            }
        }
    }
}

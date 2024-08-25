package week6.BOJ_17144_골드4_미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_지인성 {
      static int R, C, T;
  static int[][] Map;

  static int[] ur = {-1, 0, 1, 0};
  static int[] uc = {0, 1, 0, -1};

  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static int cleanerR;
  static ArrayDeque<Dust> queue = new ArrayDeque<>();
  static int totalDust;
  static StringTokenizer st;

  static class Dust {
    int r, c;
    int amount;

    public Dust(int r, int c, int amount) {
      super();
      this.r = r;
      this.c = c;
      this.amount = amount;
    }

    public int getR() {
      return r;
    }

    public void setR(int r) {
      this.r = r;
    }

    public int getC() {
      return c;
    }

    public void setC(int c) {
      this.c = c;
    }

    public int getAmount() {
      return amount;
    }

    public void setAmount(int amount) {
      this.amount = amount;
    }

    @Override
    public String toString() {
      return "Dust [r=" + r + ", c=" + c + ", amount=" + amount + "]";
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine(), " ");
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());
    Map = new int[R][C];

    makeMap(br);
    start();

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (Map[i][j] != -1 && Map[i][j] != 0)
          totalDust += Map[i][j];
      }
    }


    System.out.println(totalDust);

  }



  static void makeMap(BufferedReader br) throws IOException {
    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < C; j++) {
        Map[i][j] = Integer.parseInt(st.nextToken());
        if (Map[i][j] == -1 && cleanerR == 0) {
          cleanerR = i;
        } else if (Map[i][j] != -1 && Map[i][j] != 0) {
          queue.offer(new Dust(i, j, Map[i][j]));
        }
      }
    }
  }

  static void start() {
    for (int i = 0; i < T; i++) {
      dustSpread();
      dustCleaning();
      RemainDust(); // 현재 남아있는 먼지들을 다시 큐에 집어넣음.
    }
  }

  // 먼지 확산
  static void dustSpread() {
    int[][] tempMap = new int[R][C]; // Create a temporary map to store the spread dust

    while (!queue.isEmpty()) {
      Dust dust = queue.poll();
      int spreadCount = 0;
      int r = dust.r;
      int c = dust.c;
      int amount = dust.amount;

      for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || nc < 0 || nr >= R || nc >= C)
          continue;

        else {
          if (Map[nr][nc] != -1) {
            spreadCount++;
            tempMap[nr][nc] += amount / 5;
          }
        }
      }

      tempMap[r][c] += Map[r][c] - (amount / 5 * spreadCount);
    }

    for (int i = 0; i < R; i++) {
      Map[i] = Arrays.copyOf(tempMap[i], C);
    }
  }

  static void dustCleaning() {
    int tmp = cleanerR;
    for (int i = tmp; i > 0; --i)
      Map[i][0] = Map[i - 1][0];
    Map[tmp][0] = 0;
    for (int j = 0; j < C - 1; ++j)
      Map[0][j] = Map[0][j + 1];
    for (int i = 0; i < tmp; ++i)
      Map[i][C - 1] = Map[i + 1][C - 1];
    for (int j = C - 1; j > 0; --j)
      Map[tmp][j] = Map[tmp][j - 1];

    tmp = cleanerR + 1;
    for (int i = tmp; i < R - 1; ++i)
      Map[i][0] = Map[i + 1][0];
    Map[tmp][0] = 0;
    for (int j = 0; j < C - 1; ++j)
      Map[R - 1][j] = Map[R - 1][j + 1];
    for (int i = R - 1; i > tmp; --i)
      Map[i][C - 1] = Map[i - 1][C - 1];
    for (int j = C - 1; j > 0; --j)
      Map[tmp][j] = Map[tmp][j - 1];
  }



  static void RemainDust() {
    queue = new ArrayDeque<Dust>();
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        // 미세먼지가 남아있는 칸의 먼지들을 다시 큐에 집어넣음
        if (Map[i][j] != -1 && Map[i][j] != 0) {
          queue.offer(new Dust(i, j, Map[i][j]));
        }
      }
    }

  }
}

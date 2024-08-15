package week7.BOJ_21317_실버1_징검다리건너기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** topDown **/
public class Main_김희연 {
    static int[][] arr;
    static int n, k;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        dp = new int[n+1][2];

        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i=1; i<=n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }

        k = Integer.parseInt(br.readLine());

        System.out.println(topDown(1, 0));
        //System.out.println(topDown1(n, 0));
    }

    private static int topDown(int x, int visit) { //밑에서 위로
        if(x == n)
            return 0;
        if(x > n)
            return Integer.MAX_VALUE >> 1;
        if (dp[x][visit] != -1)
            return dp[x][visit];

        dp[x][visit] = Integer.MAX_VALUE;
        dp[x][visit] = Math.min(dp[x][visit], topDown(x + 1, visit) + arr[x][0]); // 작은 점프
        dp[x][visit] = Math.min(dp[x][visit], topDown(x + 2, visit) + arr[x][1]); // 큰 점프
        if(visit == 0)
            dp[x][visit] = Math.min(dp[x][visit], topDown(x + 3, 1) + k); // 매우 큰 점프

        return dp[x][visit];
    }

    private static int topDown1(int x, int visit) { //위에서 밑으로
        if(x == 1)
            return 0;
        if(x <= 0)
            return Integer.MAX_VALUE >> 1;
        if (dp[x][visit] != -1)
            return dp[x][visit];

        dp[x][visit] = Integer.MAX_VALUE;
        dp[x][visit] = Math.min(dp[x][visit], topDown1(x - 1, visit) + arr[x-1][0]); // 작은 점프
        dp[x][visit] = Math.min(dp[x][visit], topDown1(x - 2, visit) + arr[x-2][1]); // 큰 점프
        if(visit == 0)
            dp[x][visit] = Math.min(dp[x][visit], topDown1(x - 3, 1) + k); // 매우 큰 점프

        return dp[x][visit];
    }
}
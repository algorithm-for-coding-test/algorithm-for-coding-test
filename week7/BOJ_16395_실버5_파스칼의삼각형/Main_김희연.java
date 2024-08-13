package week7.BOJ_16395_실버5_파스칼의삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_김희연 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n][k];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(topDown(n-1, k-1));
    }

    private static int topDown(int x, int y){
        if(y == 0 || x == y)
            return 1;

        if(dp[x][y] != -1)
            return dp[x][y];

        return dp[x][y] = topDown(x-1, y-1) + topDown(x-1, y);
    }
}

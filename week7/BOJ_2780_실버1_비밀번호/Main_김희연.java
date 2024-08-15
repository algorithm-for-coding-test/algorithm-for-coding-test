package week7.BOJ_2780_실버1_비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_김희연 {
    static final int MOD = 1234567;
    static int[][] dp;
    static int[][] adj = {
            {7},        // 0
            {2, 4},     // 1
            {1, 3, 5},  // 2
            {2, 6},     // 3
            {1, 5, 7},  // 4
            {2, 4, 6, 8}, // 5
            {3, 5, 9},  // 6
            {4, 8, 0},  // 7
            {5, 7, 9}, // 8
            {6, 8}      // 9
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            int n = Integer.parseInt(br.readLine());

            dp = new int[n+1][10];
            for(int i=0; i<=n; i++){
                Arrays.fill(dp[i], -1);
            }

            int result = 0;
            for(int i=0; i<=9; i++){
                result = (result + topDown(n, i)) % MOD;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int topDown(int length, int x){
        if(length == 1)
            return 1;
        if(dp[length][x] != -1)
            return dp[length][x];

        dp[length][x] = 0;
        for(int next : adj[x]){
            dp[length][x] = (dp[length][x] + topDown(length-1, next)) % MOD;
        }

        return dp[length][x];
    }
}

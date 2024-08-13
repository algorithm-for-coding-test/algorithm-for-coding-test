package week7.BOJ_2302_실버1_극장좌석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_김희연 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        long answer = 1;
        int pre = 0;
        for (int i = 0; i < m; i++) {
            int pos = Integer.parseInt(br.readLine());
            answer *= topDown(pos - pre - 1); // 구간 크기 계산
            pre = pos;
        }
        answer *= topDown(n - pre); // 마지막 구간 계산

        System.out.println(answer);
    }

    private static int topDown(int x) {
        if (x == 0) return 1;
        if (x == 1) return 1;
        if (dp[x] != -1) return dp[x];

        return dp[x] = topDown(x - 1) + topDown(x - 2);
    }
}
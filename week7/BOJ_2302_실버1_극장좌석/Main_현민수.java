package week7.BOJ_2302_실버1_극장좌석;

import java.io.*;
import java.util.*;

public class Main_현민수 {
	static int N; 
    static List<Integer> vipSeats = new ArrayList<>(); 
    static int[] dp; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 
        int K = Integer.parseInt(br.readLine()); 

        for (int i = 0; i < K; i++) {
            vipSeats.add(Integer.parseInt(br.readLine())); 
        }
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        
        int result = 1; 
        int last = 0; 
        for (int vip : vipSeats) {
            int gap = vip - last - 1; 
            result *= seat(gap); 
            last = vip;
        }

        int gap = N - last; 
        result *= seat(gap); 

        System.out.println(result); 
    }

    static int seat(int n) {
        if (n == 0) return 1; 
        if (n == 1) return 1;
        if (dp[n] != -1) return dp[n]; 

        dp[n] = seat(n - 1) + seat(n - 2);
        return dp[n];
    }
}

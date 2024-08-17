package week7.BOJ_1446_실버1_지름길;

import java.io.*;
import java.util.*;

public class Main_현민수 {
	
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[N][K];
        
        System.out.println(fibo(N-1, K-1));
    }

    static int fibo(int n, int k) {
    	if(k==0 || n==k)return 1;
    	
    	if(dp[n][k]!=0) {
    		return dp[n][k];
    	}

    	dp[n][k] = fibo(n-1,k) + fibo(n-1,k-1);
    	return dp[n][k];
    }

}

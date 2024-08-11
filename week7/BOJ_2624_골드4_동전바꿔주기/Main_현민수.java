package week7.BOJ_2624_골드4_동전바꿔주기;

import java.io.*;
import java.util.*;

public class Main_현민수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10001];
        
        for(int i=0;i<N+1;i++){
            dp[i][0] = 1;
        }
        
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            int coin = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            for(int j=1;j<=T;j++){
                dp[i][j] = dp[i-1][j];
                for(int k=coin;k<=coin*val;k+=coin){
                    if(j-k>=0)
                        dp[i][j] += dp[i-1][j-k];
                }
            }  
        }
        System.out.println((dp[N][T]));
        
    }
}

package week7.BOJ_2342_골드3_DanceDanceRevolution;

import java.io.*;
import java.util.*;

public class Main_현민수 {
    // 몇번째,왼발, 오른발
	static int[][][] dp;
	static int[] dance;
	static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        size = (s.length()-1)/2;
        dance = new int[size+1];
        dp = new int[size+1][5][5];
        for(int i=1;i<size+1;i++) {
        	dance[i] = Character.getNumericValue(s.charAt(2*i-2));
        }
        
        for(int i=0;i<size+1;i++) {
        	for(int j=0;j<5;j++) {
        		Arrays.fill(dp[i][j], Integer.MAX_VALUE);
        	}
        }
        
        
        int ans = move(1,0,0);

        System.out.println(ans);
    }
    static int move(int idx,int left,int right) {
    	if(idx>size)return 0;
    	
    	if(dp[idx][left][right] != Integer.MAX_VALUE)return dp[idx][left][right];
    	
    	int next = dance[idx];
    	
        if (next == left || next == right) {
            dp[idx][left][right] = Math.min(dp[idx][left][right], move(idx + 1, left, right) + 1);
        }

        // 센터
        if (left == 0) {
            dp[idx][left][right] = Math.min(dp[idx][left][right], move(idx + 1, next, right) + 2);
        }
        if (right == 0) {
            dp[idx][left][right] = Math.min(dp[idx][left][right], move(idx + 1, left, next) + 2);
        }

        // 왼발
        if (left != 0) {
            if (next != left) {
                if (Math.abs(left - next) == 1 || Math.abs(left - next) == 3) { 
                    dp[idx][left][right] = Math.min(dp[idx][left][right], move(idx + 1, next, right) + 3);
                } else { 
                    dp[idx][left][right] = Math.min(dp[idx][left][right], move(idx + 1, next, right) + 4);
                }
            }
        }

        // 오른발
        if (right != 0) {
            if (next != right) {
                if (Math.abs(right - next) == 1 || Math.abs(right - next) == 3) {
                    dp[idx][left][right] = Math.min(dp[idx][left][right], move(idx + 1, left, next) + 3);
                } else { 
                    dp[idx][left][right] = Math.min(dp[idx][left][right], move(idx + 1, left, next) + 4);
                }
            }
        }
    	
    	return dp[idx][left][right];
    }
}

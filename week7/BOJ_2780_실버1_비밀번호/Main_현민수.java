package week7.BOJ_2780_실버1_비밀번호;

import java.io.*;
import java.util.*;

public class Main_현민수 {
    
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] map = new int[1001][4][3];
        int[] dr = new int[]{0,0,-1,1};
        int[] dc = new int[]{1,-1,0,0};
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                map[1][i][j] = 1;
            }  
        }
        
        for(int tc=2;tc<1001;tc++){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    int cnt = 0;
                    for(int k=0;k<4;k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr<0 || nc<0 || nr>2|| nc>2 ) continue;
                        cnt += map[tc-1][nr][nc];
                    }
                    map[tc][i][j] = cnt%1234567;
                    if(i==2 && j==0){
                        map[tc][i][j] = (map[tc][i][j]+map[tc-1][3][0])%1234567;
                        
                    }
                }
            }
            map[tc][3][0] += map[tc-1][2][0]%1234567;
        }
        for(int i=0;i<N;i++){
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            for(int j=0;j<10;j++){
                ans += map[n][j/3][j%3]%1234567;
            }
            System.out.println(ans%1234567);
        }
    }
}

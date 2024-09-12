package week2.BOJ_25708_실버1_만남의광장;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	// 가로 2개 선택하고
	// 0처리하고
	// 세로 2개 선택
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> que = new PriorityQueue<Integer>((a,b)->b-a);
		int[][] map = new int[R][C];
		int[] row = new int[R];
		int[] col = new int[C];
		int ans = Integer.MIN_VALUE;
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<R;i++) {
			int temp = 0;
			for(int j=0;j<C;j++) {
				temp+=map[i][j];
			}
			row[i] = temp;
		}
		
		for(int i=0;i<C;i++) {
			int temp = 0;
			for(int j=0;j<R;j++) {
				temp += map[j][i];
			}
			col[i] = temp;
		}
		

		for(int i=0;i<R-1;i++) {
			for(int j=i+1;j<R;j++) {
				for(int k=0;k<C-1;k++) {
					for(int z=k+1;z<C;z++) {
						int temp = row[i] + row[j] + col[k] + col[z];
						temp += (j-i-1) * (z-k-1);
						temp -= map[i][z]+map[i][k]+map[j][z]+map[j][k];
						ans = Math.max(ans, temp);
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	
	
}
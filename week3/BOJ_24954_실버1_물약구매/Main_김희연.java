package week3.BOJ_24954_실버1_물약구매;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int n;
	static int price[];
	static int sale[][];
	static boolean visit[];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		price = new int[n];
		visit = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			price[i] = Integer.parseInt(st.nextToken());
		}

		sale = new int[n+1][n+1];
		for(int i=0; i<n; i++){
			int m = Integer.parseInt(br.readLine());
			for(int j=0; j<m; j++){
				st = new StringTokenizer(br.readLine());
				int saleIdx = Integer.parseInt(st.nextToken()) - 1;
				int salePrice = Integer.parseInt(st.nextToken());
				sale[i][saleIdx] = salePrice;
			}
		}

		dfs(0, 0);
		System.out.println(min);
	}

	public static void dfs(int depth, int cost){
		if(cost >= min) //현재 비용이 최소 비용을 초과하면 종료
			return;
		if(depth == n){
			min = Math.min(min, cost);
			return;
		}

		for(int i=0; i<n; i++){
			if(visit[i])
				continue;
			visit[i] = true;
			int temp[] = Arrays.copyOf(price, n);
			for(int j=0; j<n; j++){
				if(price[j] - sale[i][j] <= 0){ //물약의 가격은 0이하로 내려가지 않음
					price[j] = 1;
				} else {
					price[j] -= sale[i][j];
				}
			}

			dfs(depth+1, cost+price[i]);
			price = Arrays.copyOf(temp, n); //물약을 구매하기 전의 가격으로 되돌림
			visit[i] = false;
		}
	}
}
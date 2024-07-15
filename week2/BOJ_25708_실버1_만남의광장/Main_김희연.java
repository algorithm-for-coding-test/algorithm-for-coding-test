package week2.BOJ_25708_실버1_만남의광장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] hori = new int[n+1];
		int[] verti = new int[m+1];
		int[][] arr = new int[n+1][m+1];

		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				hori[i] += arr[i][j];
			}
		}

		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				verti[i] += arr[j][i];
			}
		}

		int max = Integer.MIN_VALUE;
		for(int i=1; i<n; i++){
			for(int j=i+1; j<=n; j++){
				for(int k=1; k<m; k++){
					for(int l=k+1; l<=m; l++){
						int beauty = hori[i] + hori[j] + verti[k] + verti[l];
						beauty -= arr[i][k] + arr[i][l] + arr[j][k] + arr[j][l];
						beauty += (j-i-1) * (l-k-1);
						max = Math.max(max, beauty);
					}
				}
			}
		}

		System.out.println(max);
	}
}
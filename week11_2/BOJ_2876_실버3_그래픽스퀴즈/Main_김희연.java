package week11_2.BOJ_2876_실버3_그래픽스퀴즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] num = new int[6][n];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(i == 0){
				num[a][i] = 1;
				num[b][i] = 1;
				continue;
			}

			num[a][i] = num[a][i-1] + 1;
			num[b][i] = num[b][i-1] + 1;
		}

		int grade = 0;
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=5; i++){
			for(int j=0; j<n; j++) {
				if (max < num[i][j]){
					max = num[i][j];

					grade = i;
				}
			}
		}

		System.out.println(max + " " + grade);
	}
}

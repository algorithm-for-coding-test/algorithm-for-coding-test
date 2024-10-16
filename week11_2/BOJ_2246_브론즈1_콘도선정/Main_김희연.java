package week11_2.BOJ_2246_브론즈1_콘도선정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] dc = new int[n][2];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			dc[i][0] = Integer.parseInt(st.nextToken());
			dc[i][1] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for(int i=0; i<n; i++){
			boolean flag = true;
			for(int j=0; j<n; j++){
				if(i == j)
					continue;

				if(dc[i][0] > dc[j][0]) {
					if (dc[i][1] >= dc[j][1]) {
						flag = false;
						break;
					}
				}

				if(dc[i][1] > dc[j][1]){
					if(dc[i][0] >= dc[j][0]){
						flag = false;
						break;
					}
				}
			}
			if (flag)
				cnt++;
		}

		System.out.println(cnt);
	}
}

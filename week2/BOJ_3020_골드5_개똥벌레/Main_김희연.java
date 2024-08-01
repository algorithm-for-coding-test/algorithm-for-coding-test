package week2.BOJ_3020_골드5_개똥벌레;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] down = new int[h+2];
		int[] up = new int[h+2];

		//높이 1~H
		for(int i=1; i<=n/2; i++){
			int a = Integer.parseInt(br.readLine());
			int b = h - Integer.parseInt(br.readLine()) + 1; //거꾸로 있으므로
			down[a]++;
			up[b]++;
		}

		for(int i=1; i<=h; i++){
			up[i] += up[i-1]; //높이가 i이상일 때 i-1이상인 것도 개수에 포함해야되기 때문
		}

		for(int i=h-1; i>=1; i--){
			down[i] += down[i+1]; //높이가 i일 때 i+1인 것도 개수에 포함해야되기 때문
		}

		int min = n;
		int cnt = 0;
		for(int i=1; i<=h; i++) {
			int conflict = up[i] + down[i];
			if(conflict < min) {
				min = conflict;
				cnt = 1;
			} else if(conflict == min)
				cnt++;
		}
		System.out.println(min +" " + cnt);
	}
}

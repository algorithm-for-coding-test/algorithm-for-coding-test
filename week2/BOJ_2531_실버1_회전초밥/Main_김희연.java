package week2.BOJ_2531_실버1_회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] arr = new int[n+k];
		int[] sushi = new int[d+1];

		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		for(int i=0; i<k; i++){
			arr[n+i] = arr[i];
		}

		//System.arraycopy(arr, 0, arr, arr.length-k, k);

		int cnt = 0;
		for(int i=0; i<k; i++){
			if(sushi[arr[i]] == 0)
				cnt++;
			sushi[arr[i]]++;
		}

		int max = cnt;
		if(sushi[c] == 0) {
			max++;
		}

		for(int i=k; i<n+k; i++){

			if(--sushi[arr[i-k]] == 0)
				cnt--;
			if(sushi[arr[i]] == 0)
				cnt++;
			sushi[arr[i]]++;


			int curCnt = cnt;
			if(sushi[c] == 0) {
				curCnt++;
			}

			max = Math.max(max, curCnt);
		}

		System.out.println(max);
	}
}
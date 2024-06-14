package week2.BOJ_2531_실버1_회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] plateList = new int[N];
		for(int i=0; i<N; i++) {
			
			plateList[i] = Integer.parseInt(br.readLine());
		}
		
		int[] sushiNumList = new int[d+1];
		sushiNumList[c] = 1;
		int max = 1;
		for(int i=0; i<k; i++) {
			
			if(sushiNumList[plateList[i]] == 0) {
				max++;
			}
			sushiNumList[plateList[i]]++;
		}
		
		int count = max;
		for(int i=0; i<N; i++) {
			
			if(--sushiNumList[plateList[i]] == 0) {
				count--;
			}
			
			if(++sushiNumList[plateList[(i+k)%N]] == 1) {
				count++;
			}
			
			if(count > max) {
				max = count;
			}
		}
		
		System.out.println(max);
	}
}
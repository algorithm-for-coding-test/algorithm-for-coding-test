package week2.BOJ_26091_실버1_현대모비스소프트웨어아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] abilityList = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			abilityList[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		Arrays.sort(abilityList);
		
		int start = 0;
		int end = N-1;
		while(start < end) {
			if(abilityList[start] + abilityList[end] >= M) {
				start++;
				end--;
				max++;
			}
			else {
				start++;
			}
		}
		
		System.out.println(max);
	}
}

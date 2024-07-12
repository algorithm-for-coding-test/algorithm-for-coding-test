package week5.BOJ_18115_실버3_카드놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] skillList = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			
			skillList[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = N-1;
		int second = 1;
		int[] cardList = new int[N];
		for(int i=0; i<N; i++) {
			
			int skill = skillList[i];
			if(skill == 1) {
				
				cardList[start] = N-i;
				
				start = second;
				second = start + 1;
			}
			else if(skill == 2) {
				
				cardList[second] = N-i;
				second++;
			}
			else if(skill == 3) {
				cardList[end] = N-i;
				end--;
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(cardList[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}

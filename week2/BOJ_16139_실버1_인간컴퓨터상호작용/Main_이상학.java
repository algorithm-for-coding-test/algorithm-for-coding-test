package week2.BOJ_16139_실버1_인간컴퓨터상호작용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int q = Integer.parseInt(br.readLine());
		
		int[][] sumNum = new int[26][S.length()+1];
		for(int i=0; i<26; i++) {
			for(int j=1; j<=S.length(); j++) {
				if(S.charAt(j-1) == 'a'+i) {
					sumNum[i][j] = sumNum[i][j-1] + 1;
				}
				else {
					sumNum[i][j] = sumNum[i][j-1];
				}
			}
		}
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int ch = 'a', start=0, end=0;
		for(int i=0; i<q; i++) {
			
			st = new StringTokenizer(br.readLine());
			ch = st.nextToken().charAt(0);
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			int idx = ch - 'a';
			int result = sumNum[idx][end+1] - sumNum[idx][start];
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
}

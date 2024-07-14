package week2.BOJ_16139_실버1_인간컴퓨터상호작용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String s = br.readLine();
		int size = s.length();

		int[][] arr = new int[size+1][26];

		for(int i=1; i<=size; i++){
			int num = s.charAt(i-1) - 'a';
			for(int j=0; j<26; j++){
				arr[i][j] = arr[i-1][j];
			}
			arr[i][num]++;
		}

		int q = Integer.parseInt(br.readLine());

		for(int i=0; i<q; i++){
			st = new StringTokenizer(br.readLine());
			int a = st.nextToken().charAt(0) - 'a';
			int b = Integer.parseInt(st.nextToken())+1;
			int c = Integer.parseInt(st.nextToken())+1;

			sb.append(arr[c][a] - arr[b-1][a]).append("\n");
		}

		System.out.println(sb);
	}
}


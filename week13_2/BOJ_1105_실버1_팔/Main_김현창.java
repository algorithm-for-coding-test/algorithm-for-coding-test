package week13_2.BOJ_1105_실버1_팔;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		String L = st.nextToken();
		String R = st.nextToken();

		int ll = L.length();
		int rl = R.length();
		int answer = 0;
		if (ll == rl) {
			for (int i = 0; i < ll; ++i) {
				if (L.charAt(i) != R.charAt(i)) {
					break;
				}
				if (L.charAt(i) == '8') {
					++answer;
				}
			}
		}
		System.out.println(answer);
		br.close();
	}
}

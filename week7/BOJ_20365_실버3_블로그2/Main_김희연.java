package week7.BOJ_20365_실버3_블로그2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int b = 0; //파란색
		int r = 0; //빨간색
		char color = '\n';

		for(int i=0; i<n; i++){
			char c = str.charAt(i);
			if(c == color)
				continue; //같은 색이면 카운트 안함
			if(c == 'R')
				r++;
			else
				b++;
			color = c;
		}

		System.out.println(Math.min(r, b) + 1);
	}
}

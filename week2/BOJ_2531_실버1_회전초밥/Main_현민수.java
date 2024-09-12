package week2.BOJ_2531_실버1_회전초밥;

import java.io.*;
import java.util.*;

public class Main_현민수{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int left = 0;
		int right = 0;
		int sum = 0;
		for(int i=0,end=s.length();i<end;i++) {
			if (s.charAt(i) == '(') {
                left++;
                sum++;
            } else if (s.charAt(i) == ')') {
                right++;
                sum--;
            }

            if (sum < 0) {
                System.out.println(right);
                return;
            }

            if (sum == 0) {
                left = 0;
            }
			
		}

		System.out.println(left);
	}
	


	
	


}
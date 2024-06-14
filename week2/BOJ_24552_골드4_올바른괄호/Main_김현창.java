package week2.BOJ_24552_골드4_올바른괄호;

import java.io.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		int length = S.length();
		int[] nums = new int[length];
		for (int i = 0; i < length; ++i) {
			nums[i] = S.charAt(i) == '(' ? 1 : -1;
		}

		for (int i = 0; i < length - 1; ++i) {
			nums[i + 1] += nums[i];
		}

		if (nums[length - 1] == -1) {
			int index = length - 1;
			for (int i = 0; i < length; ++i) {
				if (nums[i] == -1) {
					index = i;
					break;
				}
			}
			int answer = 0;
			for (int i = index; i >= 0; --i) {
				if (S.charAt(i) == ')')
					++answer;
			}
			System.out.println(answer);
		} else {
			int index = 0;
			for (int i = length - 1; i >= 0; --i) {
				if (nums[i] == 0) {
					index = i;
					break;
				}
			}
			int answer = 0;
			for (int i = index; i < length; ++i) {
				if (S.charAt(i) == '(')
					++answer;
			}
			System.out.println(answer);
		}
		br.close();
	}
}

package week8.BOJ_1541_실버2_잃어버린괄호;

import java.io.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] splited = ("0+" + br.readLine()).split("-");
		int answer = sum(splited[0]);
		for (int i = 1; i < splited.length; ++i) {
			answer -= sum(splited[i]);
		}
		System.out.println(answer);
		br.close();
	}

	private static int sum(String expr) {
		String[] split = expr.split("\\+");
		int res = 0;
		for (String num: split) {
			res += Integer.parseInt(num);
		}
		return res;
	}
}

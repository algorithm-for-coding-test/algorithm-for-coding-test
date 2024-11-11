package week12_2.BOJ_2922_골드4_즐거운단어;

import java.io.*;

public class Main_김현창 {

	private static char[] word;
	private static int wordLength;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine().toCharArray();
		wordLength = word.length;
		System.out.println(dfs(0, 0, 0, 0));
		br.close();
	}

	private static long dfs(int index, int l, int ja, int mo) {
		if (index == wordLength) {
			return (l > 0 && ja < 3 && mo < 3) ? 1 : 0;
		}
		if (word[index] == '_') {
			long temp = 0;
			if (ja < 2) {
				temp += 20 * dfs(index + 1, l, ja + 1, 0);
				temp += dfs(index + 1, l + 1, ja + 1, 0);
			}
			if (mo < 2) {
				temp += 5 * dfs(index + 1, l, 0, mo + 1);
			}
			return temp;
		} else if (isMo(word[index])) {
			return mo < 2 ? dfs(index + 1, l, 0, mo + 1) : 0;
		} else if (word[index] == 'L') {
			return ja < 2 ? dfs(index + 1, l + 1, ja + 1, 0) : 0;
		} else {
			return ja < 2 ? dfs(index + 1, l, ja + 1, 0) : 0;
		}
	}

	private static boolean isMo(char c) {
		return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}
}

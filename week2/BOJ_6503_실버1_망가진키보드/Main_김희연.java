package week2.BOJ_6503_실버1_망가진키보드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true){
			int m = Integer.parseInt(br.readLine());

			if (m == 0) {
				break;
			}

			String str = br.readLine();

			Map<Character, Integer> map = new HashMap<>();
			int answer = 0;
			int start = 0;

			for (int end = 0; end < str.length(); end++) {
				char word = str.charAt(end);
				map.put(word, map.getOrDefault(word, 0) + 1);

				while (map.size() > m) {
					char left = str.charAt(start);
					map.put(left, map.get(left) - 1);
					if (map.get(left) == 0) {
						map.remove(left);
					}
					start++;
				}

				answer = Math.max(answer, end - start + 1);
			}

			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}

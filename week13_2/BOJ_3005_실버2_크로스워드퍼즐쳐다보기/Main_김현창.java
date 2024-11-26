package week13_2.BOJ_3005_실버2_크로스워드퍼즐쳐다보기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] graph = new char[R + 1][C + 1];
		fill2D(graph, '#');
		for (int i = 1; i <= R; ++i) {
			String line = br.readLine();
			for (int j = 1; j <= C; ++j) {
				graph[i][j] = line.charAt(j - 1);
			}
		}

		List<String> words = new ArrayList<>();
		for (int i = 0; i <= R; ++i) {
			for (int j = 0; j <= C; ++j) {
				if (graph[i][j] != '#')
					continue;
				String word1 = getWord(graph, R, C, i, j + 1, 0);
				if (word1 != null)
					words.add(word1);
				String word2 = getWord(graph, R, C, i + 1, j, 1);
				if (word2 != null)
					words.add(word2);
			}
		}
		Collections.sort(words);
		System.out.println(words.get(0));
	    br.close();
	}

	private static String getWord(char[][] graph, int r, int c, int x, int y, int dir) {
		StringBuilder sb = new StringBuilder();
		if (dir == 0) {
			for (int j = y; j <= c; ++j) {
				if (graph[x][j] == '#')
					break;
				sb.append(graph[x][j]);
			}
		} else {
			for (int i = x; i <= r; ++i) {
				if (graph[i][y] == '#')
					break;
				sb.append(graph[i][y]);
			}
		}
		return sb.length() > 1 ? sb.toString() : null;
	}

	private static void fill2D(char[][] graph, char c) {
		for (int i = 0, rows = graph.length; i < rows; ++i) {
			Arrays.fill(graph[i], c);
		}
	}
}

package week11_1.BOJ_2371_실버3_파일구별하기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> files = new ArrayList<>(N);
		int maxFileLength = 0;
		for (int i = 0; i < N; ++i) {
			List<Integer> file = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			while (true) {
				int x = Integer.parseInt(st.nextToken());
				if (x == -1)
					break;
				file.add(x);
			}
			maxFileLength = Math.max(maxFileLength, file.size());
			files.add(file);
		}

		Set[] sets = new Set[maxFileLength + 1];
		for (int i = 1; i <= maxFileLength; ++i) {
			sets[i] = new HashSet<String>();
		}

		for (List<Integer> file: files) {
			StringBuilder sb = new StringBuilder();
			int j, sz;
			for (j = 0, sz = file.size(); j < sz; ++j) {
				sb.append(file.get(j)).append("_");
				sets[j + 1].add(sb.toString());
			}
			for (; j < maxFileLength; ++j) {
				sb.append(0).append("_");
				sets[j + 1].add(sb.toString());
			}
		}

		int answer = -1;
		for (int i = 1; i <= maxFileLength; ++i) {
			if (sets[i].size() == N) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	    br.close();
	}
}

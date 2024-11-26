package week13_2.BOJ_6581_골드5_HTML;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final String HORIZONTAL_LINE = "--------------------------------------------------------------------------------";

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<String> parsed = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				if (token.contains("<hr>")) {
					if (sb.length() > 0)
						parsed.add(sb.toString());
					parsed.add(HORIZONTAL_LINE);
					sb.setLength(0);
					continue;
				}
				if (token.contains("<br>")) {
					parsed.add(sb.toString());
					sb.setLength(0);
					continue;
				}
				if (sb.length() + token.length() > 79) {
					parsed.add(sb.toString());
					sb.setLength(0);
				}
				sb.append(" ").append(token);
			}
		}
		if (sb.length() > 0)
			parsed.add(sb.toString());

		sb.setLength(0);
		for (String s: parsed)
			sb.append(s.strip()).append("\n");
		System.out.println(sb.toString());
	    br.close();
	}
}

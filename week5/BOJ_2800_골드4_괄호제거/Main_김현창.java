package week5.BOJ_2800_골드4_괄호제거;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static int n;
	private static String expression;
	private static int pairCount;
	private static int[] closeBracket;
	private static int[] openBracket;
	private static final Set<String> stringSet = new HashSet<>();

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		expression = br.readLine();
		n = expression.length();
		Deque<Integer> stack = new ArrayDeque<>();
		pairCount = 0;
		openBracket = new int[11];
		closeBracket = new int[11];
		for (int i = 0; i < n; ++i) {
			if (expression.charAt(i) == '(') {
				stack.push(i);
			} else if (expression.charAt(i) == ')') {
				openBracket[pairCount] = stack.pop();
				closeBracket[pairCount] = i;
				++pairCount;
			}
		}

		dfs(0, 0);
		String[] strings = stringSet.toArray(new String[0]);
		Arrays.sort(strings);
		StringBuilder sb = new StringBuilder();
		for (String string: strings) {
			sb.append(string).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static void dfs(int index, int visit) {
		if (index == pairCount) {
			if (visit == 0)
				return;
			String removed = getBracketRemovedString(visit);
			stringSet.add(removed);
			return;
		}
		dfs(index + 1, visit | (1 << index));
		dfs(index + 1, visit);
	}

	private static String getBracketRemovedString(int visit) {
		boolean[] checker = new boolean[n];
		for (int i = 0; i < pairCount; ++i) {
			if ((visit & (1 << i)) > 0) {
				checker[openBracket[i]] = true;
				checker[closeBracket[i]] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			if (!checker[i])
				sb.append(expression.charAt(i));
		}
		return sb.toString();
	}
}

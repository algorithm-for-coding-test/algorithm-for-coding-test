package week8.BOJ_1931_실버1_회의실배정;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()),
									  Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(meetings, (o1, o2) -> {
			if (o1.e != o2.e)
				return Integer.compare(o1.e, o2.e);
			return Integer.compare(o1.s, o2.s);
		});

		int answer = 0;
		int prev = -1;
		for (Meeting meeting: meetings) {
			if (meeting.s >= prev) {
				prev = meeting.e;
				++answer;
			}
		}
		System.out.println(answer);
	    br.close();
	}

	private static class Meeting {
		int s, e;

		Meeting(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
}

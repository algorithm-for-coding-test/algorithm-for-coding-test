package week5.BOJ_15903_실버1_카드합체놀이;

import java.io.*;
import java.util.*;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Long>pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}

		for(int i=0; i<m; i++) {
			Long a = pq.poll();
			Long b = pq.poll();
			pq.add(a+b);
			pq.add(a+b);
		}

		long sum = 0;

		while(!pq.isEmpty()) {
			sum += pq.poll();
		}

		System.out.println(sum);
	}
}
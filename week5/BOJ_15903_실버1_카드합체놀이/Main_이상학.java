package week5.BOJ_15903_실버1_카드합체놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		for(int i=0; i<m; i++) {
			
			long card1 = pq.poll();
			long card2 = pq.poll();
			
			pq.add(card1 + card2);
			pq.add(card1 + card2);
		}
		
		long sum = 0;
		for(long card : pq) {
			
			sum += card;
		}
		
		System.out.println(sum);
	}
}

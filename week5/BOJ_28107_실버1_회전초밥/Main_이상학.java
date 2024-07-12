package week5.BOJ_28107_실버1_회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이상학 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = 0;
		
		// 초밥 번호가 같으면, 낮은 번호의 사람 우선으로 배치
		Queue<int[]> orderQ = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				
				return o1[0] - o2[0];
			}
		});
		
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			for(int j=0; j<k; j++) {
				
				orderQ.add(new int[] {Integer.parseInt(st.nextToken()), i});
			}
		}
		
		Queue<Integer> sushiQ = new PriorityQueue<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			
			sushiQ.add(Integer.parseInt(st.nextToken()));
		}
		
		int[] eatCntList = new int[N];
		while(!sushiQ.isEmpty()) {
			
			int sushi = sushiQ.peek();
			
			if(orderQ.isEmpty()) {
				break;
			}
			
			if(orderQ.peek()[0] == sushi) {
				
				sushiQ.poll();
				int[] order = orderQ.poll();
				eatCntList[order[1]]++;
			}
			else if(orderQ.peek()[0] < sushi) {
				
				orderQ.poll();
			}
			else if(orderQ.peek()[0] > sushi) {
				
				sushiQ.poll();
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int cnt : eatCntList) {
			
			sb.append(cnt).append(" ");
		}
		
		System.out.println(sb);
	}
}

//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int k = 0;
//		
//		Queue<Integer>[] orderQList = new PriorityQueue[N];
//		for(int i=0; i<N; i++) {
//			
//			orderQList[i] = new PriorityQueue<Integer>();
//			st = new StringTokenizer(br.readLine());
//			k = Integer.parseInt(st.nextToken());
//			for(int j=0; j<k; j++) {
//				
//				orderQList[i].add(Integer.parseInt(st.nextToken()));
//			}
//		}
//		
//		Queue<Integer> sushiQ = new PriorityQueue<Integer>();
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<M; i++) {
//			
//			sushiQ.add(Integer.parseInt(st.nextToken()));
//		}
//		
//		int[] eatCntList = new int[N];
//		for(int i=0; i<M; i++) {
//			
//			int sushi = sushiQ.poll();
//			for(int j=0; j<N; j++) {
//				
//				if(orderQList[j].isEmpty()) {
//					continue;
//				}
//				
//				if(orderQList[j].peek() == sushi) {
//					
//					orderQList[j].poll();
//					eatCntList[j]++;
//					break;
//				}
//			}
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for(int cnt : eatCntList) {
//			
//			sb.append(cnt).append(" ");
//		}
//		
//		System.out.println(sb);
//	}

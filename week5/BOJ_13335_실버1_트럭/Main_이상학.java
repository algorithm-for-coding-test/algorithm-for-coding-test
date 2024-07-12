package week5.BOJ_13335_실버1_트럭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Queue<Integer> truckQ = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			
			truckQ.add(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> onBridgeQ = new ArrayDeque<>();
		for(int i=0; i<w; i++) {
			onBridgeQ.add(0);
		}
		
		int time = 0;
		int sumWeight = 0;
		while(!truckQ.isEmpty()) {
			
			sumWeight -= onBridgeQ.poll();
			if(sumWeight + truckQ.peek() <= L) {
				
				int truck = truckQ.poll();
				onBridgeQ.add(truck);
				sumWeight += truck;
			}
			else {
				
				onBridgeQ.add(0);
			}
			
			time++;
		}
			
		System.out.println(time + w);
	}
}

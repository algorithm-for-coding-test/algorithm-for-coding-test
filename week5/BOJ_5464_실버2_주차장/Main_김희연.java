package week5.BOJ_5464_실버2_주차장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_김희연 {
	static PriorityQueue<Integer> parkingSpace = new PriorityQueue<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static Queue<Integer> queue = new ArrayDeque<>();

	static int[] cost;
	static int[] car;

	static long sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); //주차공간 수
		int m = Integer.parseInt(st.nextToken()); //자동차 수

		cost = new int[n];
		car = new int[m+1];

		for(int i=0; i<n; i++){
			parkingSpace.add(i);
			cost[i] = Integer.parseInt(br.readLine());
		}

		for(int i=1; i<=m; i++){
			car[i] = Integer.parseInt(br.readLine());
		}

		int size = 2*m;
		for(int i=0; i<size; i++){
			int num = Integer.parseInt(br.readLine());
			if(num > 0){
				in(num);
			} else{
				num = Math.abs(num);
				out(num);
				if(!queue.isEmpty())
					in(queue.poll());
			}
		}

		System.out.println(sum);
	}

	static public void in(int num){
		if(!parkingSpace.isEmpty()) {
			int parkingNum = parkingSpace.poll();
			sum += cost[parkingNum] * car[num];
			map.put(num, parkingNum);
		} else{
			queue.add(num);
		}
	}

	static public void out(int num){
		int key = map.get(num);
		parkingSpace.add(key);
	}
}

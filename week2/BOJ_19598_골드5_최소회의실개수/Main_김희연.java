package week2.BOJ_19598_골드5_최소회의실개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_김희연 {

	public static class Pair{
		int s, e;

		Pair(int s, int e){
			this.s = s;
			this.e = e;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Pair[] meeting = new Pair[n];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			meeting[i] = new Pair(s, e);
		}

		compress(meeting);

		int[] num = new int[222222];
		for(Pair p : meeting){
			num[p.s] += 1;
			num[p.e] -= 1;
		}

		for(int i=0; i<222221; i++){
			num[i+1] += num[i];
		}

		int max = 0;
		for(int i=0; i<222222; i++){
			max = Math.max(max, num[i]);
		}

		System.out.println(max);
	}

	public static void compress(Pair[] pairs){
		Map<Integer, Integer> map = new TreeMap<>();

		for(Pair p : pairs){
			map.put(p.s, 0);
			map.put(p.e, 0);
		}

		int idx = 0;
		for(int key : map.keySet()){
			if(map.get(key) != 0)
				continue;
			map.put(key, idx++);
		}

		for (Pair p: pairs) {
			p.s = map.get(p.s);
			p.e = map.get(p.e);
		}
	}
}

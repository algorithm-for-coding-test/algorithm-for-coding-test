package week10.BOJ_4192_골드2_친구네트워크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main_현민수 {

	static int find(int a) {
		if(parent[a]<0)return a;
		return parent[a] = find(parent[a]);
	}
	static int union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
        if (aRoot != bRoot) {
            parent[aRoot] += parent[bRoot];
            parent[bRoot] = aRoot;
        }
        return -parent[aRoot];

	}
	static int[] parent;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			parent = new int[N*2+1];
			Arrays.fill(parent,-1);
			Map<String,Integer> map = new HashMap<>();
			int idx = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String aName = st.nextToken();
				String bName = st.nextToken();
				if(!map.containsKey(aName)) {
					map.put(aName, idx++);
				}
				if(!map.containsKey(bName)) {
					map.put(bName, idx++);
				}
				int a = map.get(aName);
				int b = map.get(bName);
				sb.append(union(a,b)).append("\n");
			}
			
		}
		System.out.println(sb);
		
		
	}
}

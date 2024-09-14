package week9.BOJ_14907_골드2_프로젝트스케줄링;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_현민수 {
	
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] time = new int[26];
        int[] sum = new int[26];
        Arrays.fill(time, -1);
        Arrays.fill(sum, Integer.MIN_VALUE);
        int[] depth = new int[26];
    	ArrayList<Integer>[] graph = new ArrayList[26];
    	for(int i=0;i<26;i++) {
    		graph[i] = new ArrayList<Integer>();
    	}
    	
        while(true) {
        	String s = br.readLine();
        	if(s==null || s.trim().isEmpty())break;
        	st = new StringTokenizer(s);
        	int node = st.nextToken().charAt(0)-'A';
        	time[node] = Integer.parseInt(st.nextToken());
        	if(st.hasMoreTokens()) {
            	String work = st.nextToken();
            	for(int i=0,end=work.length();i<end;i++) {
            		int c = work.charAt(i)-'A';
            		graph[c].add(node);
            		depth[node]++;
            	}
        	}
        }
        Queue<Integer> que = new ArrayDeque<Integer>();
        for(int i=0;i<26;i++) {
        	if(time[i]!=-1 && depth[i]==0) {
        		que.add(i);
        		sum[i] = time[i];
        	}
        }
        while(!que.isEmpty()) {
        	int now = que.poll();
        	for(Integer i:graph[now]) {
    			sum[i] = Math.max(sum[i], sum[now]+time[i]);
        		if(--depth[i]==0) {
        			que.add(i);
        		}
        	}
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<26;i++) {
        	if(sum[i]!=Integer.MAX_VALUE>>2) {
        		ans = Math.max(ans, sum[i]);
        	}
        }
        System.out.println(ans);
    }
    

    

}
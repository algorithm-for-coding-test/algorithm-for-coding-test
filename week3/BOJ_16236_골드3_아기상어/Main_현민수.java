package week3.BOJ_16236_골드3_아기상어;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	static class feed implements Comparable<feed>{
		int r;
		int c;
		int dist;
		int up;
		int left;
		public feed(int r,int c,int dist, int up, int left) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.up = up;
			this.left = left;
		}
		public int compareTo(feed o) {
			if(this.dist==o.dist) {
				if(this.up==o.up) {
					return this.left-o.left;
				}
				return this.up-o.up;
			}
			return this.dist - o.dist;
		}
	}
	
	static int N;
	static int[][] map;
	static ArrayList<feed> feeds;
	static int size = 2;
	static int eat = 0;
	static int ans = 0;
	static int[] dr = new int[] {1,-1,0,0};
	static int[] dc = new int[] {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        ans = 0;
        int shaR = -1;
        int shaC = -1;
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		int n = Integer.parseInt(st.nextToken());
        		map[i][j] = n;
        		if(n==9) {
        			map[i][j] = 0;
        			shaR = i;
        			shaC = j;
        		}
        	}
        }
        bfs(shaR,shaC);
        
        
    }
    static void bfs(int r,int c) {
    	ArrayDeque<int[]> que = new ArrayDeque<>();
    	que.add(new int[] {r,c});
    	while(true) {
    		int[] cur = que.poll();
    		int curr = cur[0];
    		int curc = cur[1];
    		find(curr,curc);
    		if(feeds.size()==0)break;
    		
    		int nr = feeds.get(0).r;
    		int nc = feeds.get(0).c;
    		int dist = feeds.get(0).dist;
    		if(++eat==size) {
    			eat = 0;
    			size++;
    		}
    		map[nr][nc] = 0;
    		que.add(new int[] {nr,nc});
    		ans+=dist;
    	}
    	System.out.println(ans);
    }
    
    static void find(int r,int c) {
    	
    	feeds = new ArrayList<feed>();
    	ArrayDeque<int[]> que = new ArrayDeque<>();
    	boolean[][] visit = new boolean[N][N];
    	visit[r][c] = true;
    	que.add(new int[] {r,c,0});
    	while(!que.isEmpty()) {
    		int[] cur = que.poll();
    		int curr = cur[0];
    		int curc = cur[1];
    		int dist = cur[2];
    		for(int i=0;i<4;i++) {
    			int nr = curr + dr[i];
    			int nc = curc + dc[i];
    			if(nr<0 || nc<0|| nr>N-1|| nc>N-1 || visit[nr][nc])continue;
    			if(map[nr][nc]<=size) {
    				visit[nr][nc] = true;
    				if(map[nr][nc]<size && map[nr][nc]>0) {
    					feeds.add(new feed(nr,nc,dist+1,nr-r,nc-c));   
    				}
    				que.add(new int[] {nr,nc,dist+1});
    			}
    		}
    	}
    	
    	
    	Collections.sort(feeds);
    }
}
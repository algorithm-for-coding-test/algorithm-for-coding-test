package week5.BOJ_23294_골드4_웹브라우저1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_현민수 {

	static ArrayDeque<Integer> bPage;
	static ArrayDeque<Integer> fPage;
	static int cache;
	static int C;
	static int[] pages;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pages = new int[N+1];
		cache = 0;
		bPage = new ArrayDeque<Integer>();
		fPage = new ArrayDeque<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++) {
			pages[i] = Integer.parseInt(st.nextToken());
		}
		int now = -1;
		for(int i=0;i<Q;i++) {
			String[] s = br.readLine().split(" ");
			if(s[0].charAt(0)=='B') {
				if(!bPage.isEmpty()) {
					now = back(now);
				}
			}
			else if(s[0].charAt(0)=='F') {
				if(!fPage.isEmpty()) {
					now = front(now);
				}
			}
			else if(s[0].charAt(0)=='C') {
				if(!bPage.isEmpty()) {
					compression();
				}
			}
			else {
				int after = Integer.parseInt(s[1]);
				now = attend(now,after);
			}
		}
		
		System.out.println(now);
		if(bPage.isEmpty()) {
			System.out.println(-1);
		}else {
			while(!bPage.isEmpty()) {
				System.out.print(bPage.poll()+" ");
			}
			System.out.println();
		}
		if(fPage.isEmpty()) {
			System.out.println(-1);
		}else {
			while(!fPage.isEmpty()) {
				System.out.print(fPage.poll()+" ");
			}
			System.out.println();
		}
	}
	
	static int attend(int now,int after) {
		while(!fPage.isEmpty()) {
			cache -= pages[fPage.poll()];
		}
		if(now==-1) {
			cache += pages[after];
			return after;
		}
		cache += pages[after];
		bPage.addFirst(now);

		while(cache>C) {
			int temp = bPage.pollLast();
			cache -= pages[temp];
		}
		return after;
	}
	
	static int back(int now) {
		int p = bPage.poll();
		fPage.addFirst(now);
		
		return p; 
	}
	static int front(int now) {
		int p = fPage.poll();
		bPage.addFirst(now);
		return p; 
	}
	
	static void compression() {
		int size = bPage.size();
		if(size!=0)
			bPage.add(bPage.poll());
		for(int i=1;i<size;i++) {
			int temp = bPage.poll();
			if(temp==bPage.peekLast()) {
				cache -= pages[temp];
				continue;
			}
			bPage.add(temp);
		}
	}
	
	 



}
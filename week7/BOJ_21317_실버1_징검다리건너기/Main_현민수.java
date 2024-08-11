package week7.BOJ_21317_실버1_징검다리건너기;

import java.io.*;
import java.util.*;

public class Main_현민수 {
    static class Point implements Comparable<Point>{
        int key;
        int value;
        boolean flag;
        public Point(int key,int value, boolean flag){
            this.key= key;
            this.value = value;
            this.flag = flag;
        }
        
        public int compareTo(Point o){
            if(this.value==o.value){
                return Integer.compare(o.key,this.key);
            }
            return Integer.compare(this.value, o.value);
        }
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] jump = new int[N-1][2];
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            jump[i][0] = Integer.parseInt(st.nextToken());
            jump[i][1] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());
        PriorityQueue<Point> pq = new PriorityQueue<Point>();
        pq.add(new Point(0,0,false));
        while(!pq.isEmpty()){
            Point now = pq.poll();
            int v = now.value;
            int k = now.key;
            boolean f = now.flag;
            if(k>N-1)continue;
            if(k==N-1){
                System.out.println(v);
                break;
            }
            if(!f){
                pq.add(new Point(k+3,v+K,true)); 
            }
            pq.add(new Point(k+1,v+jump[k][0],f));
            pq.add(new Point(k+2,v+jump[k][1],f));
        }
        
    }
}

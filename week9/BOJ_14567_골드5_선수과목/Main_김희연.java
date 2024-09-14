package week9.BOJ_14567_골드5_선수과목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_김희연 {
    static int n;
    static List<Integer>[] arr;
    static int[] parent;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        parent = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            parent[b]++;
        }

        topologySort();

        for(int i=1; i<=n; i++){
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void topologySort(){
        //위상 정렬
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            if(parent[i] == 0)
                q.add(i);
        }

        answer = new int[n+1]; //각 과목당 걸리는 학기
        int num = 1; //학기
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int now = q.poll();
                answer[now] = num;
                for(int child : arr[now]){
                    if(--parent[child] == 0){
                        q.add(child);
                    }
                }
            }
            num++;
        }
    }
}

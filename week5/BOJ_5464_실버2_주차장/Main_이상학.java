package week5.BOJ_5464_실버2_주차장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// java 2등
public class Main_이상학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] costList = new int[N+1];
		for(int i=1; i<=N; i++) {
			costList[i] = Integer.parseInt(br.readLine());
		}
		
		int[] weightList = new int[M+1];
		for(int i=1; i<=M; i++) {
			weightList[i] = Integer.parseInt(br.readLine());
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] isUsing = new boolean[N+1];
		int sum = 0;
		int parkCnt = 0;
		for(int i=0; i<M*2; i++) {
			
			int order = Integer.parseInt(br.readLine());
			
			// 차량이 들어올 때,
			if(order > 0) {
				
				// 주차장에 공간이 있는 경우, 작은 주차장 번호부터 탐색하여 사용하지 않는 주차장을 할당시키고 그 비용을 map에 저장, 주차 카운트 증가 및 합산 증가
				if(parkCnt < N) {
					
					for(int j=1; j<=N; j++) {
						
						if(!isUsing[j]) {
							isUsing[j] = true;
							map.put(order, j);
							break;
						}
					}
					
					sum += costList[map.get(order)] * weightList[order];
					parkCnt++;
				}
				// 주차장에 공간이 없는 경우, 대기 큐에 추가
				else {
					
					q.add(order);
				}
			}
			// 차량이 나갈 때,
			else {
				
				order = order * -1;
				
				// 주차장에 공간이 있는 경우, 할당되어 있던 비용 map에서 삭제시키고 주차 카운트 감소, 주차장 상태 변환
				if(q.isEmpty()) {
					
					isUsing[map.get(order)] = false;
					map.remove(order);
					parkCnt--;
				}
				// 주차장에 공간이 없는 경우, 나가는 차량의 비용을 대기 큐 중 가장 앞에 있는 큐로 바꾸고 합산 증가
				else {
					
					int qOrder = q.poll();
					map.put(qOrder, map.get(order));
					sum += costList[map.get(qOrder)] * weightList[qOrder];
				}
			}
		}
		
		
		System.out.println(sum);
	}
}

package week8.BOJ_1092_골드5_배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		//크레인 무게 제한
		List<Integer> crane = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)
			crane.add(Integer.parseInt(st.nextToken()));

		int m = Integer.parseInt(br.readLine());

		//박스의 무게
		List<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m; i++)
			box.add(Integer.parseInt(st.nextToken()));

		//무거운 것부터 비교
		crane.sort(Collections.reverseOrder());
		box.sort(Collections.reverseOrder());

		//가장 무게 제한이 큰 크레인도 박스를 실을 수 없으면 -1
		if(crane.get(0) < box.get(0)){
			System.out.println(-1);
			return;
		}

		int day = 0;
		while(!box.isEmpty()){
			int boxIdx = 0, craneIdx = 0;

			while(craneIdx < n && boxIdx < box.size()){
				if(crane.get(craneIdx) >= box.get(boxIdx)){
					box.remove(boxIdx); //해당 인덱스가 삭제되면서 자동으로 다음 인덱스를 가리킴
					craneIdx++;
				}
				else
					boxIdx++;
			}

			day++;
		}

		System.out.println(day);
	}
}
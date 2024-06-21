package week3.BOJ_14889_실버1_스타트와링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {
	
	static int[][] abilityMap;
	static int[][] sumMap;
	static boolean[] visit;
	static int[] myTeam;
	static int smallestAbilityDiff;
	static int N;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		abilityMap = new int[N][N];
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				
				abilityMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sumMap = new int[N][N];
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<N; j++) {
				sumMap[i][j] = abilityMap[i][j] + abilityMap[j][i];
			}
		}
		
		visit = new boolean[N];
		myTeam = new int[N/2];
		smallestAbilityDiff = Integer.MAX_VALUE;
		getAbilityDiff(0, 0);
		
		System.out.println(smallestAbilityDiff);
	}
	
	static void getAbilityDiff(int depth, int start) {
		
		if(depth == N/2) {
			
			int myTeamAbility = 0;
			int apponentAbility = 0;
			for(int i=0; i<N-1; i++) {
				
				for(int j=i+1; j<N; j++) {
					
					if(visit[i] && visit[j]) {
						myTeamAbility += sumMap[i][j];
					}
					else if(!visit[i] && !visit[j]) {
						apponentAbility += sumMap[i][j];
					}
				}
			}
			
			int diff = Math.abs(myTeamAbility - apponentAbility);
			if(diff == 0) {
				System.out.println(diff);
				System.exit(0);
			}
			if(diff < smallestAbilityDiff) {
				
				smallestAbilityDiff = diff;
			}
			
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!visit[i]) {
				myTeam[depth] = i;
				visit[i] = true;
				getAbilityDiff(depth+1, i+1);
				visit[i] = false;
			}
		}
	}
}

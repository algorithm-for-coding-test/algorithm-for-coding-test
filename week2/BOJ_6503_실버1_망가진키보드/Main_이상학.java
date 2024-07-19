package week2.BOJ_6503_실버1_망가진키보드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		String str = "";
		while(m != 0) {
			
			int[] charCntList = new int[128];
			str = br.readLine();
			
			int startIdx = -1;
			int endIdx = -1;
			int charCnt = 0;
			int maxLength = 0;
			while(endIdx < str.length() - 1) {
				
				// 서로 다른 문자의 개수가 m 미만인 경우
				if(charCnt < m) {
					
					if(charCntList[str.charAt(endIdx+1)] == 0) {
						
						charCnt++;						
					}
					endIdx++;
					charCntList[str.charAt(endIdx)]++;
				}
				else {
					
					// 새로운 문자일 경우
					if(charCntList[str.charAt(endIdx+1)] == 0) {
						
						startIdx++;
						charCntList[str.charAt(startIdx)]--;
						if(charCntList[str.charAt(startIdx)] == 0) {
							
							charCnt--;
						}
					}
					// 기존의 문자일 경우
					else {
						
						endIdx++;
						charCntList[str.charAt(endIdx)]++;
					}
				}
				
				maxLength = Math.max(maxLength, endIdx - startIdx);
			}
			
			sb.append(maxLength).append("\n");
			
			m = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);
	}
}



//public static void main(String[] args) throws IOException {
//	
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	
//	int m = Integer.parseInt(br.readLine());
//	
//	StringBuilder sb = new StringBuilder();
//	String str = "";
//	while(m != 0) {
//		
//		int[] charCntList = new int[128];
//		str = br.readLine();
//		
//		int maxLength = 0;
//		for(int i=0; i<str.length(); i++) {
//			
//			if(charCntList[str.charAt(i)] == 0) {
//				maxLength++;
//			}
//			charCntList[str.charAt(i)]++;
//			
//			if(maxLength == m) {
//				break;
//			}
//		}
//		
//		int strLength = str.length();
//		int startIdx = 0;
//		int endIdx = maxLength - 1;
//		
//		while(endIdx < strLength - 1) {
//			
//			System.out.println("length = " + (endIdx - startIdx + 1));
//			for(int i=startIdx; i<=endIdx; i++) {
//				System.out.print(str.charAt(i));
//			}
//			System.out.println();
//	
//			// 다음칸이 새로운 문자일 경우
//			if(charCntList[str.charAt(endIdx+1)] == 0) {
//				
//				// 가장 앞 문자가 하나인 경우
//				if(charCntList[str.charAt(startIdx)] == 1) {
//					
//					endIdx++;
//					charCntList[str.charAt(endIdx)]++;
//				}
//				
//				charCntList[str.charAt(startIdx)]--;
//				startIdx++;
//				
//			}
//			// 다음칸이 기존에 있던 문자일 경우
//			else {
//				endIdx++;
//				charCntList[str.charAt(endIdx)]++;
//			}
//		
//			if(maxLength < endIdx - startIdx + 1) {
//				maxLength = endIdx - startIdx + 1;
//			}
//		}
//		
//		sb.append(maxLength).append("\n");
//		m = Integer.parseInt(br.readLine());
//	}
//	
//	System.out.println(sb);
//}
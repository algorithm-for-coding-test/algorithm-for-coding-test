package week5.BOJ_1406_실버2_에디터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main_이상학 {

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		List<Character> linkedList = new LinkedList<>();
		ListIterator<Character> listIterator = linkedList.listIterator();

		for(int i=0; i<str.length(); i++) {
			
			listIterator.add(str.charAt(i));
		}
		
		for(int i=0; i<M; i++) {
			
			st = new StringTokenizer(br.readLine());
			char order = st.nextToken().charAt(0);
			if(order == 'L') {
				if(listIterator.hasPrevious()) {
					listIterator.previous();					
				}
			}
			else if(order == 'D') {
				if(listIterator.hasNext()) {
					listIterator.next();
				}
			}
			else if(order == 'B') {
				if(listIterator.hasPrevious()) {
					
					listIterator.previous();
					listIterator.remove();
				}
				
			}
			else if(order == 'P') {
				listIterator.add(st.nextToken().charAt(0));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : linkedList) {
			sb.append(c);
		}
		
		System.out.println(sb);
	}
}

/**
 * 문제의 코드
 */
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		String str = br.readLine();
//		int M = Integer.parseInt(br.readLine());
//		
//		List<Character> linkedList = new LinkedList<>();
//		for(int i=0; i<str.length(); i++) {
//			
//			linkedList.addLast(str.charAt(i));
//		}
//		
//		int currentIdx = str.length();
//		int listSize = currentIdx;
//		for(int i=0; i<M; i++) {
//			
//			st = new StringTokenizer(br.readLine());
//			char order = st.nextToken().charAt(0);
//			if(order == 'L') {
//				if(currentIdx > 0) {
//					currentIdx--;					
//				}
//			}
//			else if(order == 'D') {
//				if(currentIdx < listSize) {
//					currentIdx++;
//				}
//			}
//			else if(order == 'B') {
//				if(currentIdx == 0) {
//					continue;
//				}
//				linkedList.remove(currentIdx-1);
//				currentIdx--;
//				listSize--;
//				
//			}
//			else if(order == 'P') {
//				linkedList.add(currentIdx, st.nextToken().charAt(0));
//				currentIdx++;
//				listSize++;
//			}
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for(int i=0; i<listSize; i++) {
//			sb.append(linkedList.get(i));
//		}
//		
//		System.out.println(sb);
//	}

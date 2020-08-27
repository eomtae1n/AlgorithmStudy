/* 2020-08-27
https://programmers.co.kr/learn/courses/30/lessons/17677    <---------------  링크추가
 <[2018 카카오블라인드 1차] - 뉴스 클러스터링> - 완전 탐색, 문자열
 
 Test Case 1
 	- input : 	str1 = "FRANCE"
 				str2 = "french"
 	- return : 16384
 	
 Test Case 2
 	- input : 	str1 = "handshake"
 				str2 = "shake hands"
 	- return : 65536
 	
 Test Case 3
 	- input : 	str1 = "aa1+aa2"
 				str2 = "AAAA12"
 	- return : 43690
 	
 Test Case 4
 	- input : 	str1 = "E=M*C^2"
 				str2 = "e=m*c^2"
 	- return : 65536
 */

import java.util.ArrayList;

public class Jaccard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "FRANCE";
		String str2 = "french";
		
		System.out.println(solution(str1, str2));
	}

	public static int solution(String str1, String str2) {
		str1 = str1.toUpperCase();		// 모두 대문자로 변환
		str2 = str2.toUpperCase();
		
		ArrayList<String> st1 = new ArrayList<>();		// 두 글자씩 끊은 문자열 저장한 리스트
		ArrayList<String> st2 = new ArrayList<>();
		
		for(int i=0; i<str1.length()-1; i++)
			if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i+1)))
				st1.add(str1.substring(i, i+2));		// 두 글자가 모두 알파벳이라면 리스트에 추가
		
		for(int i=0; i<str2.length()-1; i++)
			if(Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i+1)))
				st2.add(str2.substring(i, i+2));		// 두 글자가 모두 알파벳이라면 리스트에 추가
		
		if(st1.isEmpty() && st2.isEmpty()) return 65536;	// 모두 공집합이면 65536 리턴
		
		int intersection = 0;				// 교집합 갯수
		int all = st1.size() + st2.size();	// 전체 원소의 갯수
		
		for(int i=0; i<st1.size(); i++)
			for(int j=0; j<st2.size(); j++) {
				//System.out.println("s1 : " + st1.get(i) + " s2 : " + st2.get(j));
				if(st1.get(i).equals(st2.get(j))) {
					intersection++;
					st2.remove(j);
					st2.add(j, "");
					break;
				}
			}
		
		double answer = (double)intersection / (double)(all - intersection) * 65536;
		// 자카드 유사도 계산
		
		return (int)answer;
	}
	
}

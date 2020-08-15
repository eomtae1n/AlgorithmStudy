/* 
https://programmers.co.kr/learn/courses/30/lessons/42577
 <전화번호 목록> - 해시, 문자열비교
 
 Test Case 1
 	- input : phone_book = ["119", "97674223", "1195524421"]
 	- return : false
 
 Test Case 2
 	- input : phone_book = ["123","456","789"]
 	- return : true
 	
 Test Case 3
 	- input : phone_book = ["12","123","1235","567","88"]
 	- return : false
 */

import java.util.Arrays;

public class PhoneBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);			// 배열 정렬을 해주면 조금 더 빨리 찾을 수 있음
        
        for(int i=0; i<phone_book.length; i++) {
        	for(int j=0; j<phone_book.length; j++) {			// 이중 for문
        		if(i != j && phone_book[i].length() <= phone_book[j].length()) { 		// 자기 자신하고 비교 x, 문자열 긴 것과 비교 x
        			String str = phone_book[j].substring(0, phone_book[i].length());		// 비교할 문자열을 접두어만큼 잘라줌
        			if(phone_book[i].equals(str)) return false;		// 접두어가 맞으면 false 리턴
        		}
        	}
        }
        
        return answer;			// 접두어를 못찾으면 true 리턴
    }

}

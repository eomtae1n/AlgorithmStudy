/* 2020-08-15
https://programmers.co.kr/learn/courses/30/lessons/67258
 <[카카오 인턴] 보석 쇼핑> - 슬라이딩 윈도우
 
 Test Case 1
 	- input : gems = ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]
 	- return : [3, 7]
 
 Test Case 2
 	- input : gems = ["AA", "AB", "AC", "AA", "AC"]
 	- return : [1, 3]
 	
 Test Case 3
 	- input : gems = ["XYZ", "XYZ", "XYZ"]
 	- return : [1, 1]
 	
 Test Case 4
 	- input : gems = ["ZZZ", "YYY", "NNNN", "YYY", "BBB"]
 	- return : [1, 5]
 	
 	*** 슬라이딩 윈도우 알고리즘 복습!!! ***
 	https://ramees.tistory.com/52         <----   슬라이딩 윈도우 개념
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GemShopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		
		//System.out.println(solution(gems));
		int[] answer = solution(gems);
		for(int i : answer) System.out.println(i);
	}

	public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();
        for(String s : gems) set.add(s);
        
        int size = set.size();
        
        int lIdx = 0;    // 왼쪽 인덱스
        int rIdx = 0;    // 오른쪽 인덱스
        
        HashMap<String, Integer> hm = new HashMap<>();  // 보석 종류와 갯수 담은 HashMap
        hm.put(gems[0], 1);
        
        int length = gems.length+1;    // 기본 length값 최대치로 설정
        
        while(rIdx < gems.length && rIdx >= lIdx) {
        	if(hm.keySet().size() < size) {		// HashMap에 보석이 다 안 들어갔으면 오른쪽 인덱스 1 증가하며 Map에 보석추가
        		rIdx++;
        		if(rIdx == gems.length) break;
        		
        		if(!hm.containsKey(gems[rIdx])) hm.put(gems[rIdx], 1);
        		else hm.put(gems[rIdx], hm.get(gems[rIdx])+1);
        	}
        	else if(hm.keySet().size() == size) {	// HashMap에 보석이 다 들어갔으면 왼쪽 인덱스 1 증가하며 Map에서 보석제거
        		if(rIdx - lIdx + 1 < length) {
        			length = rIdx - lIdx + 1; // 최소 길이 갱신
        			answer[0] = lIdx + 1;
        		}
        		
        		hm.put(gems[lIdx], hm.get(gems[lIdx])-1);
        		if(hm.get(gems[lIdx]) == 0) hm.remove(gems[lIdx]);
        		lIdx++;
        	}
        }
        
        answer[1] = answer[0] + length - 1;
        
        return answer;
    }
	
}

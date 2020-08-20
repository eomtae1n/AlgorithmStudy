/* 2020-08-18
https://programmers.co.kr/learn/courses/30/lessons/64062    <---------------  링크추가
 <[카카오 인턴] 징검다리 건너기> - 이분탐색
 
 Test Case 1
 	- input : stones = [2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
 			  k = 3
 	- return : 3
 	
  2020-08-18 혼자 풀어보려고 시도했지만 효율성 문제를 풀지못함
  2020-08-19 스터디를 통해 이분탐색 알고리즘 설명을 듣고 다시 풀어서 정답 제출
  
  ----다음주 스터디까지 이분탐색 문제 풀어보기----
 */

import java.util.ArrayList;
import java.util.Collections;

public class SteppingStone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		System.out.println(solution(stones, k));
	}

	public static int solution(int[] stones, int k) {
        int left = 1;			// 1
        
        ArrayList<Integer> al = new ArrayList<>();
        for(int i : stones) al.add(i);
        Collections.sort(al);
        
        int right = al.get(al.size()-1) + 1;		// stones의 최댓값 + 1
        											// + 1 한 이유는 mid가 소숫값일때 내림하기위해
        
        while(left < right - 1) {
        	int mid = (left + right) / 2;
        	
        	if(possibleGo(stones, k, mid))		// 건널수있다면 mid ~ right로 다시 이분탐색
        		left = mid;
        	else								// 건널수없다면 left ~ mid로 다시 이분탐색
        		right = mid;
        }
        return left;
    }
	
	public static boolean possibleGo(int[] stones, int k, int stone) {
		int next = 0;
		for(int i=0; i<stones.length; i++) {
			
			if(stones[i] < stone) next++;
			else next = 0;
			
			if(next >= k) return false;		// 건널수없다면 false
		}
		return true;
	}
	
}

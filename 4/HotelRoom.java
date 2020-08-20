/* 2020-08-18
https://programmers.co.kr/learn/courses/30/lessons/64063    <---------------  링크추가
 <[카카오 인턴] 호텔 방 배정> - 재귀함수, 해쉬맵
 
 Test Case 1
 	- input : room_number = [1, 3, 4, 1, 3, 1]
 			  k = 10
 	- return : [1, 3, 4, 2, 5, 6]
 	
  2020-08-18 혼자 풀어보려고 시도했지만 효율성 문제를 풀지못함
  2020-08-19 구글링으로 문제 해설을 보고 풀어보려했으나 실패
  2020-08-20 자세한 문제 해설을 보고 재귀함수로 구현 성공
  
  ----재귀함수 예제 더 풀어봐야함..----
 */

import java.util.HashMap;

public class HotelRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		
		//System.out.println(solution(k, room_number));
		long[] answer = solution(k, room_number);
		for(long l : answer) System.out.println(l);
	}
	
	static HashMap<Long, Long> hm = new HashMap<>();
	
	public static long getParent(long re) {
		if(!hm.containsKey(re)) { 	// 빈 방이면
			hm.put(re, re+1);
//			System.out.println("New Room : " + re);
			return re;
		}
		else {						// 빈 방이 아니면
			hm.put(re, getParent(hm.get(re)));		// 부모 노드를 방문하면서 방문한 모든 노드의 부모노드를 업데이트
//			System.out.println("Update room_num : " + re + ", Parent : " + hm.get(re));
			return hm.get(re);
		}
	}
	
	public static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		
		for(int i=0; i<room_number.length; i++) {
			long requestRoom = room_number[i];
			
			answer[i] = getParent(requestRoom);
		}
        
        return answer;
    }
	
}

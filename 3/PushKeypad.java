/* 
https://programmers.co.kr/learn/courses/30/lessons/67256    <---------------  링크추가
 <[카카오 인턴] 키패드 누르기> - 시뮬레이션
 
 Test Case 1
 	- input : numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
 			  hand = "right"
 	- return : "LRLLLRLLRRL"
 
 Test Case 2
 	- input : numbers = [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]
 			  hand = "left"
 	- return : "LRLLRRLLLRR"
 	
 Test Case 3
 	- input : numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
 			  hand = "right"
 	- return : "LLRLLRLLRL"
 */

public class PushKeypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		System.out.println(solution(numbers, hand));
	}

	static class Hand {
		int idx;
		
		public Hand(int idx) {
			this.idx = idx;
		}
		
		public int distance(int num) {
			if(num == 2) {
				if(this.idx == 2) return 0;
				else if(this.idx == 1 || this.idx == 3 || this.idx == 5) return 1;
				else if(this.idx == 4 || this.idx == 6 || this.idx == 8) return 2;
				else if(this.idx == 7 || this.idx == 9 || this.idx == 0) return 3;
				else return 4;
			}
			else if(num == 5) {
				if(this.idx == 5) return 0;
				else if(this.idx == 1 || this.idx == 3 || this.idx == 0 || this.idx == 7 || this.idx == 9) return 2;
				else if(this.idx == 4 || this.idx == 6 || this.idx == 2 || this.idx == 8) return 1;
				else return 3;
			}
			else if(num == 8) {
				if(this.idx == 8) return 0;
				else if(this.idx == 1 || this.idx == 3) return 3;
				else if(this.idx == 7 || this.idx == 9 || this.idx == 5 || this.idx == 0) return 1;
				else return 2;
			}
			else {
				if(this.idx == 0) return 0;
				else if(this.idx == 1 || this.idx == 3) return 4;
				else if(this.idx == 4 || this.idx == 6 || this.idx == 2) return 3;
				else if(this.idx == 7 || this.idx == 9 || this.idx == 5) return 2;
				else return 1;
			}
		}
	}
	
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        
        Hand left = new Hand(10);
        Hand right = new Hand(11);
        
        for(int num : numbers) {
        	
        	if(num == 1 || num == 4 || num == 7) { // 번호가 1,4,7 이면
        		left.idx = num;
        		answer += "L";
        	}
        	
        	else if(num == 3 || num == 6 || num == 9) { // 번호가 3,6,9 이면
        		right.idx = num;
        		answer += "R";
        	}
        	
        	else { // 번호가 2,5,8,0 이면
        		int left_dis = left.distance(num); // 왼손 거리
            	int right_dis = right.distance(num); // 오른손 거리
        		
        		if(left_dis > right_dis) { // 오른손이 더 가까우면
            		right.idx = num;
            		answer += "R";
            	}
            	else if(left_dis < right_dis) { // 왼손이 더 가까우면
            		left.idx = num;
            		answer += "L";
            	}
            	else { // 오른손과 왼손의 거리가 같다면
            		if(hand.equals("right")) {  // 오른손잡이
            			right.idx = num;
            			answer += "R";
            		}
            		else { // 왼손잡이
            			left.idx = num;
                		answer += "L";
            		}
            	}
        	}
        }
        
        return answer;
    }
	
}

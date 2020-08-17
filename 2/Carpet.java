/* 2020-08-15
https://programmers.co.kr/learn/courses/30/lessons/42842
 <카펫> - 완전탐색
 
 Test Case 1
 	- input : brown = 10
 			  yellow = 2
 	- return : [4, 3]
 
 Test Case 2
 	- input : brown = 8
 			  yellow = 1
 	- return : [3, 3]
 	
 Test Case 3
 	- input : brown = 24
 			  yellow = 24
 	- return : [8, 6]
 */

public class Carpet { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int brown = 10;
		int yellow = 2;
		
		//System.out.println(solution(brown, yellow));
		int[] answer = solution(brown, yellow);
		for(int i: answer) System.out.println(i);
	}
	
	public static int[] solution(int brown, int yellow) {
        int carpet = brown + yellow;
        int a = 0;
        int b = 0;
        
        for(int i=1; i<=Math.sqrt(carpet); i++) {
        	if(carpet % i == 0) {
        		a = carpet / i;			// 가로
        		b = i;					// 세로
        	}
        	if((a-2) * (b-2) == yellow) {
        		break;
        	}
        }
        int[] answer = new int[2];
        answer[0] = a;
        answer[1] = b;
        
        return answer;
    }

}

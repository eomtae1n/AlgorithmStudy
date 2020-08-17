/* 2020-08-15
https://programmers.co.kr/learn/courses/30/lessons/12943
 <콜라츠 추측> - 배열, 시뮬레이션
 
 Test Case 1
 	- input : num = 6
 	- return : 8
 
 Test Case 2
 	- input : num = 16
 	- return : 4
 	
 Test Case 3
 	- input : num = 626331
 	- return : -1
 */

public class Collatz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 6;
		
		System.out.println(solution(num));
	}

	public static int solution(int num) {
        if(num == 1) return 0;
    	
    	int answer = 0;
        long num1 = (long)num;
        
        while(answer < 500) {
        //1-1. 입력된 수가 짝수라면 2로 나눕니다. 
        	if(num1 % 2 == 0) {
        		num1 /= 2;
        		answer++;
        	}
        //1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
        	else {
        		num1 = num1*3 + 1;
        		answer++;
        	}
        //2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
        	if(num1 == 1) return answer;
        }
        
        return -1;
	}
	
}

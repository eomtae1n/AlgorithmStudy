/* 2020-08-15
https://programmers.co.kr/learn/courses/30/lessons/12899
 <124 나라의 숫자> - 3진법, 반복문
 
 Test Case 1
 	- input : n = 3
 	- return : 4
 
 Test Case 2
 	- input : n = 9
 	- return : 24
 	
 Test Case 3
 	- input : n = 10
 	- return : 41
 	
 Test Case 3
 	- input : n = 35
 	- return : 422
 */

public class Country124 { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 35;
		
		System.out.println(solution(n));
	}

	public static String solution(int n) {
        String answer = "";
        
        int length = 1;   // 자릿수 정하는 변수 length
        
        while(n > Math.pow(3, length)) {  // while 문을 통해 숫자를 빼가면서 몇자리인지 계산
    		n -= Math.pow(3, length);
    		length++;
    	}
        
        n -= 1;   // 숫자를 0 ~ 3^length 로 맞춰줌
        
        int len = length;
        for(int i=0; i<len; i++) {   // 자릿수만큼 for문
        	
        	if(i == len-1) {		// 마지막 자리일때만 예외
        		switch(n) {
        		case 0 : answer += "1";
        			break;
        		case 1 : answer += "2";
        			break;
        		case 2 : answer += "4";
        		default : 
        			break;
        		}
        		break;
        	}
        	
        	int quotient = (int)(n / Math.pow(3, --length));		// 몫 : 자리에 들어갈 1,2,4결정
        	int balance = (int)(n % Math.pow(3, length));			// 나머지 : 다음 n이 됨 -> 다음 자리 들어갈 숫자 결정
        	
        	n = balance;		// 나머지를 다음 숫자로 설정
        	
        	switch(quotient) {		
        	case 0 : answer += "1";		// 몫이 0이면 "1" 추가
        		break;
        	case 1 : answer += "2";		// 몫이 1이면 "2" 추가
        		break;
        	case 2 : answer += "4";		// 몫이 2이면 "4" 추가
        		break;
        	default : 
        		break;
        	}
        }
        
        return answer;
    }
	
}

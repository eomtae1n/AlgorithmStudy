/* 
https://programmers.co.kr/learn/courses/30/lessons/12926
 <시저 암호> - 문자, 시뮬레이션
 
 Test Case 1
 	- input : s = "AB"
 			  n = 1
 	- return : "BC"
 
 Test Case 2
 	- input : s = "z"
 			  n = 1
 	- return : "a"
 	
 Test Case 3
 	- input : s = "a B z"
 			  n = 4
 	- return : "e F d"
 */

public class CaesarCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a B z";
		int n = 4;
		
		System.out.println(solution(s, n));
	}

	public static String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        
        for(char c : arr) {
        	int i = (int)c;
        	if(i == 32) {
        		
        	}
        	else if(i < 92) {
        		i = (i - 65 + n) % 26;
        		i = i + 65;
        	}
        	else {
        		i = (i - 97 + n) % 26;
        		i = i + 97;
        	}
        	c = (char)i;
        	answer += c;
        }
        
        return answer;
	}
	
}

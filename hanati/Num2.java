/* 2020-08-22
 <[하나금융티아이 코딩테스트] 문자열 비교>
 
 입력된 문자열이 뒤집혀도 같은지 확인하여라
 문자열의 길이는 항상 짝수
 1~문자열길이/2 만큼 탐색
 i번째 문자와 문자열길이-i번째 문자가 같으면 Same, 다르면 Different 출력 후 줄바꿈
 
 Test Case 1
 	- input : s = "abcdba"
 	- return : 	Same
 				Same
 				Different
 */

public class Num2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdba";
		solution(s);
	}

	public static void solution(String s) {
		String[] str = s.split("");
		
		for(int i=0; i<str.length/2; i++) {
			if(str[i].equals(str[str.length-1-i]))
				System.out.println("Same");
			else
				System.out.println("Different");
		}
	}
	
}

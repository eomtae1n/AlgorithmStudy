/* 2020-08-22
 <[하나금융티아이 코딩테스트] 약수 찾기>
 
 입력된 숫자의 약수를 출력하여라
 단, 한 줄에 10개씩 출력하고 약수와 공백을 동시에 출력
 	줄 마지막 10번째 약수는 공백 출력 x
 
 Test Case 1
 	- input : num = 120
 	- return : 	1 2 3 4 5 6 8 10 12 15
				20 24 30 40 60 120
 */

public class Num1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 120;
		solution(num);
	}

	public static void solution(int num) {
		int cnt = 0;
		
		for(int i=1; i<=num; i++) {
			if(num % i == 0) {
				cnt++;
				if(cnt == 10)
					System.out.println(i);
				else
					System.out.print(i + " ");
			}
		}
	}
	
}

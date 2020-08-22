/* 2020-08-22
 <[하나금융티아이 코딩테스트] 손절, 익절>
 
 주식 가격이 배열 앞에서부터 시간 순으로 주어짐
 언제 사서 언제 손절해야 가장 이득인지 구하여라
 주식 가격의 배열 길이는 5이상 50이하
 각 배열의 원소는 0이상 100이하이다
 
 ex) [5, 7, 1, 6, 4] 가 배열이면 1일때 사서 6일때 파는게 가장 이득
 
 Test Case 1
 	- input : n = [5, 7, 1, 6, 4]
 	- return : 	5
 */

public class Num3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {5, 7, 1, 6, 4};
		System.out.println(solution(n));
	}

	public static int solution(int[] n) {
		int max = -101;
		
		for(int i=0; i<n.length; i++) {
			for(int j=i+1; j<n.length; j++) {
				if(n[j] - n[i] > max)
					max = n[j] - n[i];
			}
		}
		
		return max;
	}
	
}

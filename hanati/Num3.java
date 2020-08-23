import java.util.Stack;

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
 	
 	
 2020-08-23 
 	기존 방법은 이중 for문을 이용한 완전탐색 방법으로 시간복잡도가 n^2이었기에
 	복잡도를 줄이고자 다양한 방법을 시도해봄
 	그 중 stack을 이용한 방법은 시간복잡도가 n으로 효율성이 좋기에 코드 수정
 */

public class Num3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {5, 7, 1, 6, 4};
		System.out.println(solution(n));
	}

	public static int solution(int[] n) {
		int max = -101;
		Stack<Integer> stack = new Stack<>();
		
		for(int i : n) {
			if(stack.isEmpty()) stack.add(i);		// 비어있다면
			
			else {
				if(i - stack.peek() > max) max = i - stack.peek();	// 지금까지의 최댓값보다 크다면 최댓값 갱신
			
				if(i < stack.peek()) {				// 스택 안에 있는 숫자가 새로운 숫자보다 크다면 스택 안의 숫자 갱신
					stack.pop();
					stack.add(i);
				}
			}
		}
		
		return max;
	}
	
}

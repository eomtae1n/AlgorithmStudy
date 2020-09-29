/* 2020-09-29
 <히스토그램> - 투포인터, 슬라이딩 윈도우
 
 Test Case 1
 	- input : 	[2,2,2,3]
 	- return : 4
 Test Case 2
 	- input : 	[6,5,7,3,4,2]
 	- return : 12
 
-------------- 투포인터 문제 자주 나오니 꼭 다시 기억해두기!!!! ---------------
 */

public class Histogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] histogram = {6,5,7,3,4,2};
		System.out.println(solution(histogram));
	}

	public static int solution(int[] histogram) {
		int answer = 0;
		
		int s = 0;						// 왼쪽 포인터
		int e = histogram.length-1;		// 오른쪽 포인터
		
		while(s+1 < e) {
			int x = e - s - 1;
			int y = Math.min(histogram[s], histogram[e]);
			int area = x * y;
			if(answer < area) answer = area;
			
			if(Math.min(histogram[s], histogram[e]) == histogram[s] && histogram[s] < histogram[s+1])
				s++;
			else if(Math.min(histogram[s], histogram[e]) == histogram[e] && histogram[e] < histogram[e-1])
				e--;
			else s++;
		}
		
		return answer;
	}
}

/* 2020-08-24
https://www.acmicpc.net/problem/10815    <---------------  링크추가
 <백준 10815번 - 숫자 카드> - 이분 탐색
 
 Test Case 1
 	- input : 	5						<--- 숫자 카드 갯수
 				6 3 2 10 -10			<--- 갖고있는 숫자 카드들
 				8						<--- 확인할 카드 갯수
 				10 9 -5 2 3 4 5 -10		<--- 확인할 카드들
 				
 	- return : 1 0 0 1 1 0 0 1			<--- 확인할 카드가 숫자 카드에 있으면 1, 없으면 0
 	
 
 2020-08-24 
 	왜인지는 모르지만 시간 초과.. 
 	이분 탐색은 nlogn의 시간복잡도인데 카드를 순서대로 정렬하는 과정에서 시간오류가 난 것으로 보임
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NumCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 0, M = 0;
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();				// 입력
		ArrayList<Integer> numCard = new ArrayList<>();
		for(int i=0; i<N; i++)
			numCard.add(scan.nextInt());
		M = scan.nextInt();
		int[] numList = new int[M];
		
		for(int i=0; i<M; i++)
			numList[i] = scan.nextInt();// 입력
		
		Collections.sort(numCard);	// 숫자 카드들 크기 순으로 정렬(시간복잡도?)
		
		for(int num : numList) {	// 확인할 카드들
			if(isInList(numCard, num))	// 숫자 카드 중 있으면 1
				System.out.print(1 + " ");
			else						// 없으면 0 출력
				System.out.print(0 + " ");
		}
	}

	public static boolean isInList(ArrayList<Integer> numCard, int num) {
		int left = -1;
		int right = numCard.size() + 1;
		
		while(left < right - 1) {
			int mid = (left + right) / 2;	// 가운데 카드
			
			if(num == numCard.get(mid))		// mid가 숫자카드이면 true 반환
				return true;
			else if(num < numCard.get(mid))	// mid보다 작으면 left ~ mid
				right = mid;
			else							// mid보다 크면 mid ~ right
				left = mid;
		}
		
		//System.out.println("left : " + left + " right : " + right);
		
		return false;
	}
}

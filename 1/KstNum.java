/* 2020-08-15
https://programmers.co.kr/learn/courses/30/lessons/42748
 <K번째 수> - 배열, 시뮬레이션
 
 Test Case 1
 	- input : array = [1, 5, 2, 6, 3, 7, 4]	
 			  commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
 	- return : [5, 6, 3]
 */

import java.util.Arrays;

public class KstNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {
				{2,5,3}, 
				{4,4,1}, 
				{1,7,3}};
		
		//System.out.println(solution(array, commands));
		int[] answer = solution(array, commands);
		for(int i: answer) System.out.println(i);
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int x = 0; x < commands.length; x++) {
	        int[] temp = Arrays.copyOfRange(array, commands[x][0]-1, commands[x][1]);
	        
	        Arrays.sort(temp);
	        
	        answer[x] = temp[commands[x][2]-1];
		}
		
		return answer;
	}

}

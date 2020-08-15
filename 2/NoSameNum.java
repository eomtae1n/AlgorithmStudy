/* 
https://programmers.co.kr/learn/courses/30/lessons/12906
 <같은 숫자는 싫어> - 중복제거
 
 Test Case 1
 	- input : arr = [1,1,3,3,0,1,1]
 	- return : [1,3,0,1]
 
 Test Case 2
 	- input : arr = [4,4,4,3,3]
 	- return : [4,3]
 */

import java.util.ArrayList;

public class NoSameNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,3,3,0,1,1};
		
		//System.out.println(solution(arr));
		int[] answer = solution(arr);
		for(int i: answer) System.out.println(i);
	}

	public static int[] solution(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        
        int prev = 10;
        for(int i : arr) {
        	if(i != prev) al.add(i);
        	prev = i;
        }
        
        int[] answer = new int[al.size()];
        int size = 0;
        		
        for(int i : al) {
        	answer[size++] = i;
        }
        
        return answer;
    }
	
}

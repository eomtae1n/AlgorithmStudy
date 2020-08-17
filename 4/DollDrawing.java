/* 2020-08-16
https://programmers.co.kr/learn/courses/30/lessons/64061    <---------------  링크추가
 <[카카오 인턴] 크레인 인형뽑기 게임> - 스택, 시뮬레이션
 
 Test Case 1
 	- input : board =  [[0,0,0,0,0],
 						[0,0,1,0,3],
 						[0,2,5,0,1],
 						[4,2,4,4,2],
 						[3,5,1,3,1]]
 			  moves = [1,5,3,5,1,2,1,4]
 	- return : 4
 */

import java.util.Stack;

public class DollDrawing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},
		                 {0,0,1,0,3},
		                 {0,2,5,0,1},
		                 {4,2,4,4,2},
		                 {3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i : moves) {
        	int pick = pick(board, i-1);
        	if(pick == 0) continue;
        	
        	while(!stack.isEmpty()) {		// 같은 인형 터뜨리기
        		if(pick == stack.peek()) {
        			stack.pop();
        			answer += 2;
        			if(stack.isEmpty()) {
        				pick = 0;
        				break;
        			}
        			else pick = stack.pop();
        		}
        		else break;
        	}
        	if(pick != 0) stack.add(pick);
        }
        
        return answer;
    }
	
    public static int pick(int[][] board, int column) {		// 뽑기
		for(int i=0; i<board.length; i++) {
			if(board[i][column] != 0) {
				int num = board[i][column];
				board[i][column] = 0;
				return num;
			}
		}
		return 0;
	}
	
}

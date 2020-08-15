/* 
https://programmers.co.kr/learn/courses/30/lessons/42587
 <프린터> - 큐
 
 Test Case 1
 	- input : priorities = [2, 1, 3, 2]
 			  location = 2
 	- return : 1
 
 Test Case 2
 	- input : priorities = [1, 1, 9, 1, 1, 1]
 			  location = 0
 	- return : 5
 	
 	*** PriorityQueue 객체 공부하기!! ***
 */

import java.util.LinkedList;
import java.util.Queue;

public class Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = {2,1,3,2};
		int location = 2;
		
		System.out.println(solution(priorities, location));
	}

	public static int solution(int[] priorities, int location) {
        class Num {
			int number;
			boolean checking;
			
			public Num(int number, boolean checking) {
				this.number = number;
				this.checking = checking;
			}
		}
		
        int answer = 0;
        
        Queue<Num> priority = new LinkedList<Num>();
        
        for(int i=0; i<priorities.length; i++) {
        	if(i == location) priority.add(new Num(priorities[i], true));
        	else priority.add(new Num(priorities[i], false));
        }
        
        int max = 0;
        for(Num i : priority) {
        	if(max < i.number) max = i.number;
        }
        
        while(true) {
        	if(max == priority.peek().number) {
        		Num t = priority.poll();
        		answer++;
        		if(t.checking) break;
        		max = 0;
        		for(Num i : priority) {
                	if(max < i.number) max = i.number;
                }
        	}
        	else {
        		Num t = priority.poll();
        		priority.offer(t);
        	}
        }
        
        
        return answer;
	}
	
}

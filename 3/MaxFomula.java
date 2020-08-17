/* 2020-08-15
https://programmers.co.kr/learn/courses/30/lessons/67257
 <[카카오 인턴] 수식 최대화> - 스택, 완전탐색, 시뮬레이션
 
 Test Case 1
 	- input : expression = "100-200*300-500+20"
 	- return : 60420
 
 Test Case 2
 	- input : expression = "50*6-3*2"
 	- return : 300
 	
 	*** 저번에 저장해뒀던 순열 생성 함수(pick) 사용 ***
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MaxFomula { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "100-200*300-500+20";
		
		System.out.println(solution(expression));
	}

	static String[] op;
    static Stack<String> stack;
    static ArrayList<Long> answerList = new ArrayList<>();
	
	public static long solution(String expression) {
        long answer = 0;
    	stack = new Stack<String>();
    	Set<String> set = new HashSet<String>();
    	
    	String[] split = expression.split("");
    	String next = "";
    	for(String s : split) {
    		
    		if(s.equals("*") || s.equals("+") || s.equals("-")) {
    			stack.add(next);
    			next = "";
    			stack.add(s);
    			set.add(s);
    		}
    		else {
    			next += s;
    		}
    	}
    	stack.add(next);
    	
    	int n = set.size();
    	op = new String[n+1];
    	int idx = 1;
    	for(String o : set) {
    		op[idx++] = o;
    	}
    	
    	ArrayList<Integer> picked = new ArrayList<Integer>();
        boolean[] check = new boolean[n+1];

        pick(n, picked, check);
        
        Collections.sort(answerList);
        answer = answerList.get(answerList.size()-1);
        
        return answer;
    }
	
	public static void pick(int n, ArrayList<Integer> picked, boolean[] check) {
        if(picked.size() == n) {
            
            Stack<String> tmp = new Stack<String>();
            @SuppressWarnings("unchecked")
			Stack<String> copy = (Stack<String>) stack.clone();

            for(int i : picked) {
            	// 계산
            	while(!copy.isEmpty()) {
            		String cur = copy.peek();
            		if(cur.equals(op[i])) {
            			copy.pop();
            			String prev = copy.pop();
            			long res = 0;
            			switch(op[i]) {
            			case "*" : 
            				res = Long.parseLong(prev) * Long.parseLong(tmp.pop());
            				tmp.add(Long.toString(res));
            				break;
            			case "+" : 
            				res = Long.parseLong(prev) + Long.parseLong(tmp.pop());
            				tmp.add(Long.toString(res));
            				break;
            			case "-" : 
            				long next = Long.parseLong(tmp.pop());
            				if(copy.isEmpty() || copy.peek().equals("+") || copy.peek().equals("*")) {
            					res = Long.parseLong(prev) - next;
                				tmp.add(Long.toString(res));
            				}
            				else if(copy.peek().equals("-")){
                				res = Long.parseLong(prev) + next;
                				tmp.add(Long.toString(res));
            				}
            				break;
            			default : break;
            			}
            		}
            		else {
            			copy.pop();
            			tmp.add(cur);
            		}
            	}
            	while(!tmp.isEmpty()) {
            		copy.add(tmp.pop());
            	}
            }
            long result = Math.abs(Long.parseLong(copy.pop()));
            
            answerList.add(result);
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(check[i])
                continue;
            check[i] = true;
            picked.add(i);
            pick(n, picked, check);
            picked.remove(picked.size()-1);
            check[i] = false;
        }
    }
	
}

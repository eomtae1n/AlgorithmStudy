/* 2020-08-28
https://programmers.co.kr/learn/courses/30/lessons/17682    <---------------  링크추가
 <[2018 카카오블라인드 1차] - 다트 게임> - 스택, 문자열
 
 Test Case 1
 	- input : 	dartResult = 1S2D*3T
 	- return : 37
 	
 Test Case 2
 	- input : 	dartResult = 1D2S#10S
 	- return : 9
 	
 Test Case 3
 	- input : 	dartResult = 1D2S0T
 	- return : 3
 	
 Test Case 4
 	- input : 	dartResult = 1S*2T*3S
 	- return : 23
 	
 Test Case 5
 	- input : 	dartResult = 1D#2S*3S
 	- return : 5
 	
 Test Case 6
 	- input : 	dartResult = 1T2D3D#
 	- return : -4
 	
 Test Case 7
 	- input : 	dartResult = 1D2S3T*
 	- return : 59
 */

import java.util.Stack;

public class DartGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dartResult = "1S2D*3T";
		System.out.println(solution(dartResult));
	}

	public static int solution(String dartResult) {
	      int answer = 0;
		      Stack<Integer> s = new Stack<Integer>();
		      String[] result = dartResult.split("");
		      String front = "";
		      
		      for(String i : result) {
		    	  //싱글
		    	  if(i.equals("S")) {
		    		  int tmp = s.pop();
		    		  s.add(tmp);
		    	  }
		    	  //더블
		    	  else if(i.equals("D")) {
		    		  int tmp = (int)Math.pow(s.pop(), 2);
		    		  s.add(tmp);
		    	  }
		    	  //트리플
		    	  else if(i.equals("T")) {
		    		  int tmp = (int)Math.pow(s.pop(), 3);
		    		  s.add(tmp);
		    	  }
		    	  //스타상
		    	  else if(i.equals("*")) {
		    		 if(s.size() < 2) {
		    			 int tmp = s.pop() * 2;
		    			 s.add(tmp);
		    		 }
		    		 else {
		    			 int tmp1 = s.pop() * 2;
		    			 int tmp2 = s.pop() * 2;
		    			 s.add(tmp2);
		    			 s.add(tmp1);
		    		 }
		    	  }
		    	  //아차상
		    	  else if(i.equals("#")) {
		    		  int tmp = s.pop() * (-1);
		    		  s.add(tmp);
		    	  }
		    	  //숫자
		    	  else if(i.equals("0") && front.equals("1")) {
		    		  int tmp = s.pop() * 10;
		    		  s.add(tmp);
		    	  }
		    	  else s.add(Integer.parseInt(i));
		    	  
		    	  front = i;
		      }
		      
		      for(int i : s) answer += i;
		      
		      return answer;
	  }
	
}

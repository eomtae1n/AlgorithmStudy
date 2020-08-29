/* 2020-08-29
https://programmers.co.kr/learn/courses/30/lessons/17684    <---------------  링크추가
 <[2018 카카오블라인드 3차] - 압축> - 해쉬맵
 
 Test Case 1
 	- input : 	msg = "KAKAO"
 	- return : [11, 1, 27, 15]
 	
 Test Case 2
 	- input : 	msg = "TOBEORNOTTOBEORTOBEORNOT"
 	- return : [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
 	
 Test Case 3
 	- input : 	msg = "ABABABABABABABAB"
 	- return : [1, 2, 27, 29, 28, 31, 30]
 */

import java.util.ArrayList;
import java.util.HashMap;

public class LZW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		int[] answer = solution(msg);
		for(int i : answer)
			System.out.println(i);
	}

	public static int[] solution(String msg) {
	      ArrayList<Integer> ans = new ArrayList<>();
		      
		      HashMap<String, Integer> hm = new HashMap<>();
		      for(int i=1; i<27; i++) hm.put(Character.toString((char)(64+i)), i);
		      
		      String[] mes = msg.split("");
		      
		      for(int i=0; i<mes.length; i++) {
		    	  String tmp = "";
		    	  if(i == mes.length-1) {
		    		  ans.add(hm.get(mes[i]));
		    		  break;
		    	  }
		    	  int start = i;
		    	  while(hm.containsKey(tmp + mes[start]) && start != mes.length) {
		    		  tmp += mes[start++];
		    		  if(start == mes.length) break; 
		    	  }
		    	  ans.add(hm.get(tmp));
		    	  if(start == mes.length) break; 
		    	  
		    	  tmp += mes[start];
		    	  i = start-1;
		    	  hm.put(tmp, hm.size() + 1);
		      }
		      
		      int[] answer = new int[ans.size()];
		      for(int i=0; i<ans.size(); i++) {
		    	  answer[i] = ans.get(i);
		      }
		      
		      return answer;
	  }
	
}

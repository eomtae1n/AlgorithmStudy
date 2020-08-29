/* 2020-08-29
https://programmers.co.kr/learn/courses/30/lessons/17686    <---------------  링크추가
 <[2018 카카오블라인드 3차] - 파일명 정렬> - 문자열 처리, 정렬
 
 Test Case 1
 	- input : 	files = [img12.png, img10.png, img02.png, img1.png, IMG01.GIF, img2.JPG]
 	- return : [img1.png, IMG01.GIF, img02.png, img2.JPG, img10.png, img12.png]
 	
 Test Case 2
 	- input : 	files = [F-5 Freedom Fighter, B-50 Superfortress, A-10 Thunderbolt II, F-14 Tomcat]
 	- return : [A-10 Thunderbolt II, B-50 Superfortress, F-5 Freedom Fighter, F-14 Tomcat]
 */

public class FileSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		
		String[] answer = solution(files);
		for(String s : answer)
			System.out.println(s);
	}

	public static String[] solution(String[] files) {
        String[][] ans = new String[files.length][3];
	      for(int j=0; j<files.length; j++) for(int k=0; k<3; k++) ans[j][k] = "";
	      int[] order = new int[files.length];
	      for(int i=0; i<files.length; i++) order[i] = i;
	      
	      for(int i=0; i<files.length; i++) {
	    	  String[] str = files[i].split("");
	    	  int idx = 0;
	    	  while(!isInteger(str[idx]) && idx != str.length) {
	    		  //Head
	    		  ans[i][0] += str[idx];
	    		  idx++;
	    	  }
	    	  while(isInteger(str[idx]) && idx != str.length) {
	    		  //NUMBER
	    		  ans[i][1] += str[idx];
	    		  idx++;
	    		  if(idx == str.length) break; 
	    	  }
	    	  while(idx < str.length) {
	    		  //TAIL
	    		  ans[i][2] += str[idx];
	    		  idx++;
	    	  }
	      }
	      //정렬
	      for(int i=0; i<ans.length-1; i++) {
	    	  for(int j=i; j<ans.length; j++) {
	    		  if(ans[i][0].toUpperCase().compareTo(ans[j][0].toUpperCase()) > 0) {
		    		  for(int k=0; k<3; k++) {
		    			  String t = ans[i][k];
		    			  ans[i][k] = ans[j][k];
		    			  ans[j][k] = t;
		    		  }
		    		  int tmp = order[i];
		    		  order[i] = order[j];
		    		  order[j] = tmp;
		    	  }
		    	  else if(ans[i][0].toUpperCase().compareTo(ans[j][0].toUpperCase()) == 0) {
		    		  if(Integer.parseInt(ans[i][1]) > Integer.parseInt(ans[j][1])) {
		    			  for(int k=0; k<3; k++) {
			    			  String t = ans[i][k];
			    			  ans[i][k] = ans[j][k];
			    			  ans[j][k] = t;
			    		  }
		    			  int tmp = order[i];
			    		  order[i] = order[j];
			    		  order[j] = tmp;
		    		  }
		    		  else if(Integer.parseInt(ans[i][1]) == Integer.parseInt(ans[j][1]) && order[i] > order[j]) {
		    			  for(int k=0; k<3; k++) {
			    			  String t = ans[i][k];
			    			  ans[i][k] = ans[j][k];
			    			  ans[j][k] = t;
			    		  }
		    			  int tmp = order[i];
			    		  order[i] = order[j];
			    		  order[j] = tmp;
		    		  }
		    	  }
	    	  }
	      }
	      
	      String[] answer = new String[files.length];
	      for(int i=0; i<files.length; i++) answer[i] = "";
	      for(int i=0; i<files.length; i++) for(int j=0; j<3; j++) {
	    	  answer[i] += ans[i][j];
	      }
	      return answer;
  }
	
    public static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
	
}

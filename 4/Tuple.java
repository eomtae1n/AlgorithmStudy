/* 2020-08-18
https://programmers.co.kr/learn/courses/30/lessons/64065    <---------------  링크추가
 <[카카오 인턴] 튜플> - 중복제거(해시), 문자열
 
 Test Case 1
 	- input : s = "{{2},{2,1},{2,1,3},{2,1,3,4}}"
 	- return : [2,1,3,4]
 	
 Test Case 2
 	- input : s = "{{1,2,3},{2,1},{1,2,4,3},{2}}"
 	- return : [2,1,3,4]
 	
 Test Case 3
 	- input : s = "{{20,111},{111}}"
 	- return : [111,20]
 	
 Test Case 4
 	- input : s = "{{123}}"
 	- return : [123]
 	
 Test Case 5
 	- input : s = "{{4,2,3},{3},{2,3,4,1},{2,3}}"
 	- return : [3,2,4,1]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Tuple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		
		//System.out.println(solution(s));
		int[] answer = solution(s);
		for(int i : answer) System.out.println(i);
	}

	public static int[] solution(String s) {
        StringTokenizer str = new StringTokenizer(s, "{}");
        ArrayList<String> list = new ArrayList<>();
        
        while(str.hasMoreTokens()) {
        	String token = str.nextToken();		// token은 숫자들 모음이거나 {} 사이에 있는 , 이다
        	
        	if(token.equals(","))		// {} 사이에 있는 ,인 경우 스킵
        		continue;
        	
        	list.add(token);			// 숫자들 모음을 list에 추가
        }
        String[] st = new String[list.size()];
        
        for(int i=0; i<st.length; i++) {
        	st[i] = list.get(i);			// list를 st배열에 저장
        }
        
        for(int i=0; i<st.length-1; i++) {
        	for(int j=i+1; j<st.length; j++) {
        		if(st[i].length() > st[j].length()) {
        			String tmp = st[j];				// 숫자들 모음의 길이가 작은것부터 오름차순 정렬
        			st[j] = st[i];
        			st[i] = tmp;
        		}
        	}
        }
        HashSet<Integer> hs = new HashSet<>();
        int[] answer = new int[st.length];
        int i=0;
        
        for(String ss : st) {					// 숫자들 모음이 작은것부터
        	String[] numbers = ss.split(",");
        	
        	for(String num : numbers) {
        		if(!hs.contains(Integer.parseInt(num))) {	// 이미 추가된 숫자가 아닌 새로운 숫자를
        			hs.add(Integer.parseInt(num));			// hs에 추가
        			answer[i++] = Integer.parseInt(num);	// answer 다음 인덱스에 저장
        		}
        	}
        }
        return answer;
    }
	
}
